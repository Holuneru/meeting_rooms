# Booking Meeting Rooms

This is a simple Spring Boot application for booking meeting rooms.

## Features

*   Create a booking for a meeting room.
*   Cancel an existing booking.
*   View booking information.

## Technologies Used

*   **Java 21**
*   **Spring Boot**
*   **Spring Data JPA**
*   **PostgreSQL**
*   **Lombok**
*   **MapStruct**
*   **Swagger (OpenAPI)** for API documentation.

## How to Run

1.  **Prerequisites**:
    *   JDK 21 or later
    *   Maven 3.x
    *   PostgreSQL database running

2.  **Configuration**:
    *   Open `src/main/resources/application.properties` and configure your database connection details (URL, username, password).

3.  **Build the project**:
    ```bash
    mvn clean install
    ```

4.  **Run the application**:
    ```bash
    mvn spring-boot:run
    ```
    The application will start on `http://localhost:8080`.

5.  **API Documentation**:
    *   Once the application is running, you can access the Swagger UI for API documentation at `http://localhost:8080/swagger-ui.html`.
