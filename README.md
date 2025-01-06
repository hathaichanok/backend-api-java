# Java Spring Boot Application - Backend API Web Service

This is a Java Spring Boot application built using Java 23, MySQL, and Docker. The project is designed to provide a robust, scalable backend service that is easy to deploy and maintain.

---

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 23**
- **Maven** (for building the application)
- **MySQL** (if not using Docker for the database)
- **Docker and Docker Compose** (for containerization)
- **Git** (for version control)

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <repository-name>
```

### 2. Configure the Database

- Update the `src/main/resources/application.properties` file with your database details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```

- If using Docker, skip this step as the database will be automatically set up.

### 3. Build the Application

### Running application and start MySQL / phpMyadmin in Docker

```bash
mvn spring-boot:run 
```

---

### 4. API Documentation

The API endpoints are documented using Swagger. Access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

---

