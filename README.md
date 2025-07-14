# 📋 Sistema de Gestão de Tarefas

Este é um projeto Java desenvolvido com Spring Boot que oferece funcionalidades completas para o gerenciamento de tarefas e cadastro de usuários. O sistema também realiza a integração automática de endereços via **API ViaCEP**, aplicando boas práticas como DTOs, validações, tratamento de exceções e arquitetura multicamada.

---

## 🚀 Tecnologias Utilizadas

- Java 24
- Spring Boot
- Spring Web
- Spring Data JPA + Hibernate
- Bean Validation (Jakarta)
- ModelMapper
- API ViaCEP
- Git + GitHub
- IntelliJ IDEA

---

## 📦 Funcionalidades

### 👤 Módulo Usuários
- ✅ Cadastro com validações
- ✅ Consulta, edição e deleção
- ✅ Integração automática com ViaCEP para preenchimento de endereço

### ✅ Módulo Tarefas
- ✅ Cadastro com campos como nome, descrição, prazo, prioridade e categoria
- ✅ Edição completa e atualização de status com controle de data de conclusão
- ✅ Listagem, busca por ID e exclusão
- ✅ Endpoint dedicado para alteração de status sem necessidade de DTO completo

### ⚙️ Estrutura Técnica
- Arquitetura organizada com camadas: DTOs, Models, Mappers, Services e Controllers
- Validações e exceções customizadas com mensagens personalizadas
- Documentação completa via Swagger/OpenAPI

---

## 📚 Documentação

A API está documentada com Swagger UI e pode ser acessada via:
http://localhost:8080/swagger-ui.html

