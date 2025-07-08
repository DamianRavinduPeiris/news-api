# News API

A RESTful API built with Spring Boot for managing news articles and their categories. This project demonstrates CRUD operations, exception handling, and a layered architecture using Java, Spring Boot, and JPA.

## Features

- Manage news articles and categories
- Retrieve all news or filter by category
- Add, update, and delete news articles
- Exception handling with custom error responses
- Layered architecture (Controller, Service, Repository)
- Uses Spring Data JPA for database operations

## Project Structure

```
src/
  main/
    java/
      com.damian.newsapi/
        controllers/         # REST controllers
        dto/                # Data Transfer Objects
        entity/             # JPA entities
        exception/          # Custom exceptions
        handler/            # Global exception handler
        repo/               # Spring Data JPA repositories
        service/            # Service interfaces and implementations
    resources/
      application.yml       # Application configuration
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- (Optional) MySQL or H2 database

### Setup

1. **Clone the repository:**
   ```
   git clone https://github.com/DamianRavinduPeiris/news-api/tree/master
   cd NEWS-API
   ```

2. **Configure the database:**
   - Edit `src/main/resources/application.yml` to set your database connection.

3. **Build the project:**
   ```
   ./mvnw clean install
   ```

4. **Run the application:**
   ```
   ./mvnw spring-boot:run
   ```

   The API will be available at `http://localhost:8080/`.


## License

This project is licensed under the MIT License.

