# Booking Meeting Rooms

This is a simple Spring Boot application for booking meeting rooms.

## Features

### Booking
*   **Create Booking**: Create a booking for a meeting room.
*   **Cancel Booking**: Cancel an existing booking.
*   **Get All Bookings (Admin only)**: View all bookings in the system.
*   **Check Room Availability**: Check if a room is available for a given time interval.

### Room
*   **Create Room (Admin only)**: Create a new meeting room.
*   **Get All Rooms**: Get a list of all available rooms.
*   **Get Room with Active Bookings**: View a room's details along with its active bookings.

### Employee
*   **Register Employee**: Register a new employee.
*   **Get Employee's Active Bookings**: View an employee's active bookings.
*   **Set Admin Status**: Grant admin privileges to an employee.
*   **Get Admins**: Get a list of all employees with admin privileges.

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
