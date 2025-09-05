# 📝 To-Do List API

Este projeto é uma API RESTful simples de **To-Do List** construída com **Spring Boot**, **Java 21** e **Maven**.  
A API permite **criar, listar, atualizar e remover tarefas** de forma fácil e rápida.

---

## 🚀 Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL (pode ser adaptado para outros bancos)
- Hibernate

---

## 📂 Estrutura do Projeto
- **Tasks** → Entidade que representa uma tarefa.
- **TaskRepository** → Interface para acesso ao banco de dados.
- **TaskController** → Controlador REST com os endpoints da aplicação.

---

## ⚙️ Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties` configure sua conexão com o banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
