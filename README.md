# ☁️ Projeto Workshop Spring Boot + MongoDB
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/Alexandre-barbosa1/workshop-spring-boot-mongoDB/blob/main/LICENSE)

# Sobre o projeto
Este é um projeto backend desenvolvido com **Spring Boot** e **MongoDB**, com o objetivo de praticar conceitos de **API RESTful**, persistência de dados em **banco NoSQL**, e construção de um CRUD completo com relacionamento entre documentos.

A aplicação simula um sistema de postagens, com usuários, posts e comentários.

## Layout
Este projeto não possui interface gráfica, sendo acessado por meio de **endpoints REST**, que podem ser testados com ferramentas como **Postman**, **Insomnia** ou via navegador (GET).

## Modelo conceitual
- Cadastro de **Usuários** (id, nome, email)
- Cadastro de **Postagens** (id, data, título, corpo, autor)
- Cada postagem pode conter **comentários** com autor e texto
- Relacionamentos:
  - Um usuário pode ter vários posts (1:N)
  - Um post pode conter vários comentários (1:N)
  - Comentários e autor são armazenados como documentos embutidos (DTOs)

# Tecnologias utilizadas

## Back end
- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB (local ou em nuvem)
- Maven
- IntelliJ

# Como executar o projeto

### Pré-requisitos
- Java 17 ou superior
- MongoDB instalado e em execução na porta padrão (27017)

## Back end

```bash
# Clone o repositório
git clone https://github.com/Alexandre-barbosa1/workshop-spring-boot-mongoDB

# Acesse a pasta do projeto
cd workshop-spring-boot-mongoDB

# Execute o projeto com Maven
./mvnw spring-boot:run
Acesse os endpoints no navegador ou via Postman:

http://localhost:8080/users

http://localhost:8080/posts
```
Autor
👨‍💻 Alexandre Barbosa
www.linkedin.com/in/alexandrebarbosa01
