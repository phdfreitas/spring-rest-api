package com.desafio.spring.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.spring.restapi.model.Pessoa;
import com.desafio.spring.restapi.repository.PessoaRepository;
import com.desafio.spring.restapi.utils.SendMessage;
import com.telesign.MessagingClient;
import com.telesign.RestClient;

@Service
public class PessoaDao {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa) {
        
        //SendMessageClient(pessoa);
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findOne(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa update(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    private void SendMessageClient(Pessoa pessoa){
        int posicaoFila = (int) pessoaRepository.count() + 1;

        pessoa.setPosicaoFila(posicaoFila);

        SendMessage sendMessage = new SendMessage(pessoa.getNome() + " sua posição na fila é: " + pessoa.getPosicaoFila());

        try {
            MessagingClient messagingClient = new MessagingClient(
                sendMessage.getCustomerId(), 
                sendMessage.getApiKey(),
                sendMessage.getRestEndpoint()
            );
            RestClient.TelesignResponse telesignResponse = messagingClient.message(
                sendMessage.getPhoneNumber(), 
                sendMessage.getMessage(), 
                sendMessage.getMessageType(), 
                null
            );
            System.out.println(telesignResponse.json);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
