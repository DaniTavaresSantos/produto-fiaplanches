# language: pt

Funcionalidade: Criar Produto na base de Dados

  Cenario: : 01 - Criação de produto na base com sucesso
    Dado o produto Hamburguer de Id 1 e preco 10.00 e Categoria LANCHE
    Quando for realizada a chamada no endpoint de registro de produto
    Entao Eu recebo uma resposta correta

  Cenario: : 02 - Buscar cliente na base com sucesso
    Dado o produto Hamburguer de Id 1 e preco 10.00 e Categoria LANCHE
    Quando for realizada a chamada no endpoint de busca de produto por categoria
    Entao Eu recebo uma resposta correta




