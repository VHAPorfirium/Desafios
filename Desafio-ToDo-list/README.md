# 📝 Desafio ToDo-List

Repositório com um **Desafio Back‑End Java** para gerenciamento de tarefas (ToDo‑List), ideal para teste de vaga de estagiario e júnior.  
Aqui você vai encontrar uma API REST construída com **Spring Boot** e **PostgreSQL** para criar, listar, atualizar e remover tarefas.

---

## 🚀 Tecnologias

- **Java 21**  
- **Spring Boot** 
- **PostgreSQL**  
- **Maven**  

Desafio: Crie uma API REST para gerenciar uma lista de tarefas (“to-do list”), permitindo operações de criação, leitura, atualização e exclusão (CRUD). O objetivo é avaliar sua capacidade de projetar e implementar um serviço back-end em Java usando Spring Boot e PostgreSQL.

```bash

1. **Cadastro de Tarefa**

   * **POST** `/api/tasks`

     * **Body**: `{ "title": "string", "description": "string (opcional)", "dueDate": "YYYY-MM-DD" }`
     * Cria uma nova tarefa com status inicial PENDING.

2. **Listagem de Tarefas**

   * **GET** `/api/tasks`

     * Retorna todas as tarefas, ordenadas por data de criação.

3. **Detalhes de uma Tarefa**

   * **GET** `/api/tasks/{id}`

     * Retorna a tarefa identificada por `{id}`.

4. **Atualização de Tarefa**

   * **PUT** `/api/tasks/{id}`

     * **Body**: `{ "title": "...", "description": "...", "status": "PENDING|IN_PROGRESS|DONE", "dueDate": "YYYY-MM-DD" }`
     * Atualiza campos permitidos da tarefa.

5. **Exclusão de Tarefa**

   * **DELETE** `/api/tasks/{id}`

     * Remove a tarefa do banco de dados.

---

## 3. Modelo de Dados (Exemplo)

```java
@Entity
@Table(name = "tasks")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // PENDING, IN_PROGRESS, DONE

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDate dueDate;
    // getters e setters...
}
```

## 4. Requisitos Técnicos

* **Java** 21
* **Spring Boot** 
* **Banco de Dados** PostgreSQL
* **Maven**
* **Spring Data JPA**
* **Validações** com `javax.validation` (e.g. `@NotBlank`, `@FutureOrPresent`)
* **Tratamento de erros** centralizado (ControllerAdvice)
* **Controle de versão** no Git (commits claros e atômicos)

> **Opcional / Bônus**
>
> * Docker-compose para orquestrar aplicação e banco
> * Flyway ou Liquibase para migrações de esquema
> * Paginação e filtros (por status, data)
> * Testes de integração com Testcontainers
> * 


## 📚 Endpoints da API

| Método | URL                  | Descrição                              | Body Exemplo                                                                       |
| ------ | -------------------- | -------------------------------------- | ---------------------------------------------------------------------------------- |
| GET    | `/tasks`             | Lista todas as tarefas                 | —                                                                                  |
| GET    | `/tasks/{id}`        | Busca tarefa por ID                    | —                                                                                  |
| POST   | `/tasks`             | Cria uma nova tarefa                   | `{ "title": "Comprar leite", "description": "2 litros", "dueDate": "2025-08-01" }` |
| PUT    | `/tasks/{id}`        | Atualiza todos os campos de uma tarefa | `{ "title": "Comprar pão", "status": "ANDAMENTO" }`                                |
| DELETE | `/tasks/{id}`        | Remove uma tarefa                      | —                                                                                  |



## 📁 Estrutura de Pastas

```bash
Desafio-ToDo-list/
├── src/
│   ├── main/
│   │   ├── java/com/seuprojeto/
│   │   │   ├── controller/   
│   │   │   ├── model/        
│   │   │   ├── repository/   
│   │   │   └── service/      
│   │   └── resources/
│   │       └── application.properties
├── pom.xml                  

```

---

## 🌟 Próximas melhorias (nível júnior)

* **Validações** mais completas (Bean Validation)
* **Tratamento de exceções** customizado (Controller Advice)
* **Documentação** de API com **Swagger/OpenAPI**
* **Testes unitários** (JUnit + Mockito)
* **Migrations** com Flyway ou Liquibase

---
Feito por Victor Hugo Aguiar Porfiro!!






