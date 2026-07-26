# 🔐 Auth API

API de autenticação desenvolvida com **Java e Spring Boot**, responsável pelo gerenciamento de usuários, cadastro, login e autenticação utilizando **JWT**.

Projeto desenvolvido como uma API backend seguindo boas práticas de organização, separação de responsabilidades e segurança.

---

## 🚀 Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.0
- Spring Security
- Spring Data JPA
- PostgreSQL
- Hibernate
- JWT (JSON Web Token)
- BCrypt
- MapStruct
- Maven
- Lombok

---

# 📌 Funcionalidades da V1

## Usuários

✅ Cadastro de usuário

- Nome
- Email
- Senha criptografada
- Aceite dos termos de uso

---

## Autenticação

✅ Login utilizando:

- Email
- Senha

Após autenticação, a API retorna um token JWT para acesso aos recursos protegidos.

---

## Segurança

Implementado:

- Spring Security
- BCrypt para criptografia de senha
- Autenticação stateless utilizando JWT
- Filtro de autenticação JWT

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, separando responsabilidades entre controller, service, repository, entity, DTOs e configurações.
```
auth_api
│
├── config
│
├── controller
│
├── dto
│
├── entity
│
├── exception
│
├── mapper
│
├── repository
│
├── service
│
└── AuthApiApplication
```
# 🗄️ Banco de Dados

Banco utilizado:

Configuração utilizando variáveis de ambiente:

```yaml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

spring:
  jpa:
    hibernate:
      ddl-auto: update

DB_URL=jdbc:postgresql://localhost:5432/auth_api
DB_USERNAME=postgres
DB_PASSWORD=sua_senha

JWT_SECRET=sua_chave_secreta
JWT_EXPIRATION=86400000