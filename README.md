# Projeto do Produto

Este é o repositório do Projeto Produto fiaplanches, uma aplicação incrível desenvolvida pela equipe Grupo 48. Esse projeto consiste em uma aplicação web que fornece serviços relacionados a lanchonete FiapLanches que está informatizando seus processos onde este microServiço é responsável especificamente pelo contexto de Produto dessa Lanchonete

## Instruções de Instalação

Para executar o projeto localmente, siga as instruções abaixo:

1. Clone este repositório em sua máquina local:

   ```shell
   git clone https://github.com/DaniTavaresSantos/product-fiaplanches.git
   ```

2. Rode o comando de dockerCompose na raíz do projeto para subir os serviços e a infra relacionados a este microserviço:

   ```shell
   docker-compose up -d
   ```   

Isso iniciará os containers necessários para executar a aplicação.

## Para testar a funcionalidade da aplicação, basta utilizar a collection do Postman localizada na pasta: [Collection-Postman](/Collection-Postman), na raíz do projeto.

## Importe também o Environment também localizado na pasta:.

## Ordem do caminho feliz a partir dos endpoints do postman:

## Utilizar os seguintes requests, onde o body informado ja é funcional.
1. product/register
2. product/findByCategory
3. product/findByIds
4. product/Atualiza Produto
5. product/health


## Links dos Repositórios:
https://github.com/DaniTavaresSantos/conta-fiaplanches
https://github.com/DaniTavaresSantos/pedido-fiaplanches
https://github.com/DaniTavaresSantos/cozinha-fiaplanches
https://github.com/DaniTavaresSantos/pagamento-fiaplanches
https://github.com/dalexandrias/fiap-lanches-infra
https://github.com/DaniTavaresSantos/lambda-fiaplanches

## [Link do Google Drive contendo:](https://drive.google.com/drive/folders/16FyAlEpgWNXZFDkoz_PccqhihvkOUAfx?usp=drive_link)
- Justificativa Saga
- Relatorio RIPD
- Relatórios OWASP - ZAP
- Desenho Arquitetura do Projeto
