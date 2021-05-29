# game-store

Projeto de API criado com uso do framework Spring Boot (Java).

Endpoint base -> http://localhost:8080/games

Possui os seguintes verbos:

GET/  
GET/orderByPrice\
GET/orderByScore\
GET/orderByName\
GET/{id}\
POST/\
PUT/{id}\
DELETE/{id}

Também pode ser acessada por meio da URL https://api-game-store.herokuapp.com/games/

Os testes unitários foram realizados, cobrindo quase todo o código.

Esse projeto pode ser facilmente executado utilizando a IDE Eclipse que se encontra no endereço https://spring.io/tools bastando clicar na opção "Maven Install" e em seguida "Spring Boot App".

Usando a linha de comando, é só digitar: mvn clean install
em seguida: mvn spring-boot:run

**É importante que se utilize o java na versao 11.

    Os valores exibidos no checkout (frete, subtotal e total) são calculados dinamicamente
    O usuário poderá adicionar e remover produtos do carrinho
    O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.
    A cada produto adicionado, é somado R$ 10,00 ao frete.
    O frete é grátis para compras acima de R$ 250,00 (sem o frete dos demais produtos).


