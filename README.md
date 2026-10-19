# Spring Boot Student CRUD REST API

A beginner-friendly REST API application built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL. The project implements CRUD operations, custom JPA queries, and soft delete functionality. APIs are tested using Postman.

## Technologies Used

- **Java** – Application development
- **Spring Boot** – REST API development
- **Spring Data JPA** – Database access and query operations
- **Hibernate** – ORM (Object-Relational Mapping)
- **MySQL** – Relational database
- **Maven** – Dependency management and build automation
- **Postman** – API testing

## Features

- **Create:** Add new records to the database.
- **Retrieve:** Fetch records from the database.
- **Update :** Update existing  details using request parameters.
- **Soft Delete:** Mark a student record as deleted using an `isDeleted` flag instead of permanently removing it from the database.
- **Custom JPA Queries:** Use JPA query methods to perform database operations.
- **RESTful API Endpoints:** Handle student operations through HTTP requests.
- **Database Integration:** Persist student data in MySQL using Spring Data JPA and Hibernate.

## Project Structure

The project follows a layered architecture to separate responsibilities.

- **Controller:** Handles incoming HTTP requests and returns responses.
- **Entity:** Defines the Student entity and its database mapping, including the `isDeleted` field.
- **Repository:** Handles database access and custom JPA queries.
- **Service:** Contains business logic for student CRUD operations.

## Soft Delete Implementation

This project implements soft delete using an `isDeleted` flag in the Student entity.

- `isDeleted = false`: The student record is not marked as deleted.
- `isDeleted = true`: The student record is marked as deleted.

Instead of physically removing a record from the database, the application updates the flag. This allows the record to remain stored in the database.

Retrieval operations should filter out records marked as deleted where required by the application's query logic.

## Prerequisites

- Java JDK compatible with the project
- MySQL Server
- Maven or the included Maven Wrapper
- Postman
- IntelliJ IDEA or another Java IDE

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/santoshnaik91/SpringCrudProject.git
   ```

2. Open the project in IntelliJ IDEA.

3. Create a MySQL database named `studentdb`, or use your configured database name.

4. Configure the following environment variables for your database connection:

    - `DB_URL` – JDBC URL of your MySQL database
    - `DB_USERNAME` – MySQL username
    - `DB_PASSWORD` – MySQL password

   Example URL:

   ```text
   jdbc:mysql://localhost:3306/studentdb
   ```

5. Ensure that the database connection settings are configured correctly in `application.properties`.

6. Run the main application class:

   `CrudSpringBootApplication`

7. Use Postman to send requests to the API endpoints.

## API Endpoints

The following table describes the intended student CRUD operations. Confirm the exact paths and HTTP methods against your controller implementation.

| Operation | HTTP Method | Example Endpoint |
|---|---|---|
| Create student | POST | `/student/create` |
| Retrieve students | GET | `/student/getAll` |
| Update student | PUT | `/student/update?id=1` |
| Soft delete student | DELETE | `/student/delete?id=1` |

**Note:** These are example endpoint paths based on the current project description. Adjust them if your controller uses different mappings. The request body and required parameters depend on your implementation.

## Future Improvements

- Input validation
- Global exception handling
- Unit and integration testing
- Improved API documentation
- Additional error handling and response status codes

## Security

- Database credentials should be configured using environment variables.
- Never commit database passwords or other sensitive credentials to the repository.

## Learning Outcomes

Through this project, I gained practical experience with:

- Building REST APIs using Spring Boot.
- Implementing CRUD operations with Spring Data JPA.
- Connecting a Spring Boot application to MySQL.
- Writing custom JPA queries.
- Implementing soft delete using an entity flag.
- Testing REST endpoints using Postman.
- Organizing application code using a layered architecture.
