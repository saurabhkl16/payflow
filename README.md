# PayFlow

## Overview

Every time you tap **Pay** on apps like PhonePe or Google Pay, a backend server receives that request, validates the sender, records the transaction, and updates balances — all in under a second.

**PayFlow** is a simplified version of that system.

This project is a REST API built using Spring Boot that simulates a digital wallet and money transfer system. It allows users to register, maintain wallet balances, and transfer money between accounts.

There is no frontend UI in this project. The entire system is designed as a backend service that can be consumed by any frontend application through HTTP APIs.

---

## Features

### User Management

* Register a new user
* Assign a unique UPI ID
* Set an opening wallet balance
* Fetch user details by ID
* Search users by UPI ID
* List all registered users

### Money Transfer

* Transfer money between users
* Persist transaction records
* Maintain sender and receiver information
* Store transaction amount and timestamp

---

## Tech Stack

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* MySQL
* Maven

---

## Project Structure

```text
src/main/java/com/payflow
│
├── controller
│   ├── UserController
│   └── TransactionController
│
├── service
│   ├── UserService
│   └── TransactionService
│
├── repository
│   ├── UserRepository
│   └── TransactionRepository
│
├── entity
│   ├── User
│   └── Transaction
│
├── dto
│   ├── UserRequestDto
│   └── TransactionRequestDto
│
└── PayFlowApplication
```

---

## Layer Responsibilities

### Controller Layer

The Controller layer exposes REST endpoints.

Responsibilities:

* Accept HTTP requests
* Validate incoming data
* Invoke service methods
* Return API responses

Examples:

```http
POST /users
GET /users
GET /users/{id}
POST /transactions
```

---

### Service Layer

The Service layer contains business logic.

Responsibilities:

* Register users
* Validate transfer requests
* Check balances
* Execute transactions
* Coordinate repository calls

---

### Repository Layer

The Repository layer interacts with the database using Spring Data JPA.

Responsibilities:

* Save users
* Save transactions
* Fetch users by ID
* Search users by UPI ID

---

### Entity Layer

Entities map Java objects to database tables.

Examples:

* User
* Transaction

These classes are persisted using JPA/Hibernate.

---

## Database Configuration

Create a database:

```sql
CREATE DATABASE payflow;
```

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/payflow
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Running the Application

### Clone Repository

```bash
git clone <repository-url>
cd PayFlow
```

### Install Dependencies

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

or run:

```java
PayFlowApplication.java
```

The application starts on:

```text
http://localhost:8080
```

---

## API Endpoints

### Register User

```http
POST /users
```

Request Body:

```json
{
  "name": "Saurabh",
  "upiId": "saurabh@payflow",
  "balance": 5000
}
```

---

### Get User By ID

```http
GET /users/{id}
```

Example:

```http
GET /users/1
```

---

### Search User By UPI

```http
GET /users/upi/{upiId}
```

Example:

```http
GET /users/upi/saurabh@payflow
```

---

### List All Users

```http
GET /users
```

---

### Send Money

```http
POST /transactions
```

Request Body:

```json
{
  "senderId": 1,
  "receiverId": 2,
  "amount": 500
}
```

Response:

```json
{
  "message": "Transaction Successful"
}
```

---

## How Spring Boot Features Appear in PayFlow

### 1. Embedded Server

Spring Boot ships with an embedded Tomcat server.

How it appears in PayFlow:

* No separate Tomcat installation is required.
* Running `PayFlowApplication` immediately starts a web server.
* APIs become available on port 8080.

Example:

```java
@SpringBootApplication
public class PayFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(
            PayFlowApplication.class,
            args
        );
    }
}
```

Benefit:

* Faster development
* Easier deployment
* Single executable JAR

---

### 2. Auto-Configuration

Spring Boot automatically configures components based on project dependencies.

How it appears in PayFlow:

When we add:

```xml
spring-boot-starter-web
```

Spring Boot automatically configures:

* DispatcherServlet
* Embedded Tomcat
* JSON serialization with Jackson

When we add:

```xml
spring-boot-starter-data-jpa
```

Spring Boot automatically configures:

* Hibernate
* Entity Manager
* Transaction Management
* Repository implementations

No manual configuration classes are required.

Benefit:

* Less boilerplate code
* Faster setup
* Cleaner architecture

---

### 3. Production-Ready Defaults

Spring Boot provides sensible defaults out of the box.

How it appears in PayFlow:

* Dependency Injection
* Structured logging
* Exception handling support
* Database connection pooling
* JSON request/response conversion
* Bean lifecycle management

Benefit:

* Production-friendly configuration
* Better maintainability
* Reduced setup effort

---

## Sample Flow

1. Register User A

```json
{
  "name": "Alice",
  "upiId": "alice@payflow",
  "balance": 5000
}
```

2. Register User B

```json
{
  "name": "Bob",
  "upiId": "bob@payflow",
  "balance": 3000
}
```

3. Transfer Money

```json
{
  "senderId": 1,
  "receiverId": 2,
  "amount": 1000
}
```

4. Transaction gets recorded in the database.

5. Updated balances are persisted.

---

## Future Improvements

* JWT Authentication
* Wallet Balance Validation
* Transaction History APIs
* Global Exception Handling
* Swagger/OpenAPI Documentation
* Docker Support
* Unit and Integration Tests

---

## Author

Saurabh Lomte

Software Developer | Angular & Spring Boot
