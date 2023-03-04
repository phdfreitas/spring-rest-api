# Spring Rest API

# Itens básicos

- [x] Classe Pessoa com seus respectivos atributos
- [x] CRUD para Pessoa
- [x] Usando API para envio de posição por sms

## Rotas

### Post (/pessoas)
```
{
    "nome": "Pedro Freitas"
    "idade": 50
    "posicaoFila": null
}
```

### Put(/pessoas/1)
```
{
    "nome": "Pedro Freitas"
    "idade": 45
    "posicaoFila": null
}
```

## Observações
1. Para não tornar público o número de telefone e nem a chave da API, o codigo para funcionalidade  de enviar o sms foi comentado, nesse caso, ao cadastrar um usuário o mesmo não receberá "uma posição na fila". No entanto, a funcionalidade está implemetada, necessitando portanto, apenas colocar um número e a chave da API pessoal. 

2. Não foram implementados testes automatizados

3. Não foi feita a conteinerização.