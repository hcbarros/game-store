# game-store

Projeto de API criado com uso do framework Spring Boot (branch main) e o framwork ReactJs (branch main) para consumo da AI e exibição dos dados.

Endpoint base -> http://localhost:8080/

Possui os seguintes verbos:

GET/games/{cardId}\
GET/games/orderByPrice/{cardId}\
GET/games/orderByScore/{cardId}\
GET/games/orderByName/{cardId}\
GET/games/cartsEmpty\
POST/usuario\
PUT/games/{cardId}\
PUT/games/replaceProducts/{cardId}\


Também pode ser acessada por meio da URL:

### https://api-game-store.herokuapp.com/games/


Esse projeto pode ser facilmente executado utilizando a IDE Eclipse que se encontra no endereço https://spring.io/tools bastando clicar na opção "Maven Install" e em seguida "Spring Boot App".

Usando a linha de comando, é só digitar: mvn clean install
em seguida: mvn spring-boot:run

**É importante que se utilize o java na versao 11.

Os valores exibidos no checkout (frete, subtotal e total) são calculados dinamicamente
conforme o usuário seleciona ou remove produtos.
O usuário poderá adicionar e remover produtos do carrinho
O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.
A cada produto adicionado, é somado R$ 10,00 ao frete.
O frete é grátis para compras acima de R$ 250,00 (sem o frete dos demais produtos).

O usuário poderá realizar checkout de seu carrinho de compras. Deve ser exigido preencher
informações pessoais do usuário (Nome, CPF, Endereço, Número do Cartão de Crédito).
A API validará se as informações pessoais foram preenchidas e o preço a ser pago 
conforme os requisitos anteriores. As informações serão inseridas no banco de dados em memória.
