# ✅ Sistema de Gestão de Tarefas com Spring Boot

Este projeto é uma aplicação Java desenvolvida com Spring Boot que oferece funcionalidades completas para gerenciamento de tarefas e cadastro de usuários. A aplicação conta com integração automática de endereços via API ViaCEP, autenticação segura com JWT, arquitetura limpa, documentação Swagger e práticas avançadas de desenvolvimento.

---

## 🚀 Tecnologias Utilizadas

- Java 24
- Spring Boot
- Spring Web
- Spring Data JPA + Hibernate
- Bean Validation (Jakarta)
- ModelMapper
- API ViaCEP
- Spring Security + JWT
- Swagger/OpenAPI
- Git + GitHub
- IntelliJ IDEA

---

## 📦 Funcionalidades

### 👤 Módulo Usuários
- Cadastro, consulta, edição e remoção de usuários
- Validação automática de endereço via consulta ao ViaCEP
- Cálculo de idade baseado na data de nascimento
- Criação de usuários com autenticação JWT e controle de acesso por `role`

### 📋 Módulo Tarefas
- Criação de tarefas com descrição, categoria, prioridade e prazo
- Listagem geral ou busca por ID
- Edição completa ou apenas alteração de status
- Exclusão de tarefas com retorno de status HTTP apropriado

### 🔐 Autenticação e Segurança
- Autenticação via login utilizando `username` e `password`
- Geração de tokens JWT com dados de usuário e role
- Filtro de autorização para proteger rotas privadas
- Customização do ponto de entrada não autorizado (HTTP 401)
- Proteção de rotas específicas com base em perfil (`ADMIN`, `USUARIO`)

### 📚 Documentação Técnica
- Swagger UI para visualização e teste dos endpoints
- Inclusão de esquema de segurança JWT no Swagger
- Descrições e respostas documentadas por operação

---

## 🧪 Testes

- Testes manuais via Swagger UI para fluxo completo (CRUD, autenticação, consulta de CEP)
- Planejamento de testes automatizados com JUnit e Spring Boot Test (em andamento)




