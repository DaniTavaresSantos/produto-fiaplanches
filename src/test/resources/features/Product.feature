# language: pt

Funcionalidade: Criar Produto na base de Dados

  Cenario: : 01 - Criação de produto na base com sucesso
    Dado o produto Hamburguer de Id 5 e preco 10.00 e Categoria LANCHE
    Quando for realizada a chamada no endpoint de registro de produto
    Entao o produto deve ser localizado com sucesso na base

  Cenario: : 02 - Buscar produto na base com sucesso
    Dado o produto Hamburguer de Id 1 e preco 10.00 e Categoria LANCHE
    Quando for realizada a chamada no endpoint de busca de produto por categoria
    Entao o produto deve ser localizado com sucesso na base

  Cenario: : 03 - Buscar produtos na base com sucesso
    Dado o produto Hamburguer e preco 10.00 e Categoria LANCHE
    E o produto deve ser localizado com sucesso na base
    Dado o segundo produto Coca e preco 12.00 e Categoria BEBIDA
    E o segundo produto deve ser localizado com sucesso na base
    Quando for realizada a chamada no endpoint de busca de produto por ids
    Entao o produto deve ser localizado com sucesso na base

  Cenario: : 04 - Atualizar produto na base com sucesso
    Dado o produto Coca e preco 12.00 e Categoria BEBIDA
    E o produto deve ser localizado com sucesso na base
    E o produto será alterado para Coca de Preco 14.00 e Categoria BEBIDA
    Quando for realizada a chamada no endpoint de atualizar produto
    Entao o produto deve ser localizado com sucesso na base

  Cenario: : 05 - Deletar produto na base com sucesso
    Dado o produto Coca e preco 12.00 e Categoria BEBIDA
    E o produto deve ser localizado com sucesso na base
    Quando for realizada a chamada no endpoint de deletar produto
    Entao o produto deve não deve ser localizado na base




