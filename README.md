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
DELETE/{id}\

Também pode ser acessada por meio da URL https://api-game-store.herokuapp.com/games/

No Spring Boot foi utilizado o padrão MVC com as camadas do modelo, serviço, controle, com uma pequena configuração para permitir o uso da API a partir de qualquer origem. Caso haja necessidade de futuras mudanças na aplicação, o Spring Boot permite uma configuração de segurança bem robusta, com apenas alguns passos. Por isso essa biblioteca é sempre uma opção interessante. Como banco de dados, foi utilizado o H2 que fica embutido na própria aplicação.

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


