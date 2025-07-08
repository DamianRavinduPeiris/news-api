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
   - Edit `src/main/resources/application.yml` to set your database connection (H2 is default for development).

3. **Build the project:**
   ```
   ./mvnw clean install
   ```

4. **Run the application:**
   ```
   ./mvnw spring-boot:run
   ```

   The API will be available at `http://localhost:8080/`.

## API Endpoints

### News Categories

- `GET /categories`  
  Get all news categories.

- `GET /categories/{id}`  
  Get a category by its ID.

### News

- `GET /news`  
  Get all news articles.

- `GET /news/{id}`  
  Get a news article by ID.

- `POST /news`  
  Create a new news article.

- `PUT /news/{id}`  
  Update an existing news article.

- `DELETE /news/{id}`  
  Delete a news article.

## Example Request

**Create a News Article**
```http
POST /news
Content-Type: application/json

{
  "title": "Spring Boot 3 Released",
  "content": "Spring Boot 3 brings many new features...",
  "categoryId": "1"
}
```

## Error Handling

- Returns `404 Not Found` if a resource does not exist.
- Returns `400 Bad Request` for invalid input.
- Custom error messages are provided in the response body.

## Testing

Run all tests with:
```
./mvnw test
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

## License

This project is licensed under the MIT License.

