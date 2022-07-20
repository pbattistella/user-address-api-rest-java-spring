# user-address-api-rest-java-spring

API em Java SPRING com postgresql.

## Routes:

###Rota genérica
Get: http://localhsot:8080/

###Rota para todos os usuários
Get: http://localhsot:8080/user

###Rota para pegar um determinado usuário
Get: http://localhsot:8080/user/{id}

###Rota para criar usuário
Post: http://localhsot:8080/user

###Rota para atualizar usuário
Put: http://localhsot:8080/user/{id}

###Rota para deletar usuário
Get: http://localhsot:8080/user/{id}

###Rota para adicionar endereços
Put: http://localhsot:8080/user/{userId}/address

###Rota para adicionar definir endereço como principal
Put: http://localhsot:8080/user/{userId}/mainAddress/{addressId}


