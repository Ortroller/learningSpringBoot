# learningSpringBoot
Um projeto simples de um API com Java Spring Boot usando Postgres que basicamente consistem em um CRUD de 3 tabelas, sendo elas: 

* Pessoa
* Veículo
* Propriedade

Onde a tabela *Propriedade* é um relacional de *Pessoa* com *Veículo*, como uma relação de posse de uma pessoa a uma veículo, onde cada veículo só pode ter um dono e uma
pessoa pode ter mais de um veículo.

# Rotas e Métodos

### server/pessoa/  
  
  Rota CRUD para a tabela **pessoa** aceitando todos os métodos GET, POST, DELETE e PATCH.
  
  Dados dessa tabela são:
  * Nome
  * CPF
  * Data de nascimento (dob)
