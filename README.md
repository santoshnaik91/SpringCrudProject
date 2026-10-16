# Spring Boot CRUD Application

A beginner-friendly REST API project built using Spring Boot, Spring Data JPA, Hibernate, and MySQL. The API is tested using Postman.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## Features

- Create student records
- Retrieve student records
- Update student records
- Delete student records

## Project Structure

- `controller` — Handles HTTP requests
- `entity` — Defines the Student entity
- `repository` — Communicates with the database using JPA
- `service` — Contains business logic

## Prerequisites

- Java JDK compatible with the project
- MySQL Server
- Maven (or the included Maven wrapper)
- Postman

## Setup Instructions

1. Clone this repository.
2. Create a MySQL database named `studentdb`, or use your configured database name.
3. Configure the `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables.
4. Open the project in IntelliJ IDEA.
5. Run `CrudSpringBootApplication`.
6. Test the API using Postman.

## API Endpoints

Document your actual endpoints here, including HTTP methods, request bodies, and example responses.

## Future Improvements

- Soft delete
- Input validation
- Global exception handling
- Unit and integration tests

## Security

Database credentials are not included in this repository. Configure them through environment variables before running the application.