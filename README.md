# learningSpringBoot
Um projeto simples para aprendizado de uma API em Java Spring Boot usando Postgres que basicamente consiste em um CRUD de 3 tabelas, sendo elas: 

* Pessoa
* Veículo
* Propriedade

Onde a tabela *Propriedade* é um relacional de *Pessoa* com *Veículo*, como uma relação de posse de uma pessoa a uma veículo, onde cada veículo só pode ter um dono e uma
pessoa pode ter mais de um veículo.

# Rotas e Métodos

### server/pessoa/  
  
  Rota CRUD para a tabela **pessoa** aceitando todos os métodos GET, POST, DELETE e PATCH.
  
  Dados dessa tabela são:
  * name
  * cpf
  * Data de nascimento (dob)

### server/veiculo/  
  
  Rota CRUD para a tabela **veiculo** aceitando todos os métodos GET, POST, DELETE e PATCH.
  
  Dados dessa tabela são:
  * licensePlate : Placa do veículo
  * chassis : Chassi do veículo
  * modelName : Modelo do veículo
  * cc : Capacidade cúbica do motor (Opcional)
  
  ### server/propriedade/  
  
  Rota CRUD para a tabela **pessoa** aceitando todos os métodos GET, POST, DELETE. Patch não foi implementado nesse controlador.
  
  Dados dessa tabela são:
  * owner : Entidade do tipo Pessoa.
  * vehicle : Entidade do tipo Veículo.
  
  Sendo que um pessoa pode ser dono de vários veículos, mas um veículo só pode ser propriedade de uma pessoa. A multiplicidade de veículos fica sendo **um para um** e 
  de pessoa fica **vários para um**.
