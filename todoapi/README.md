# Todo API (Spring Boot)

This is a backend REST API project built with Spring Boot.  
It includes user authentication with JWT and CRUD operations for tasks.

---

## Features

- User registration and login
- Password encryption (BCrypt)
- JWT authentication
- Create, read, update, delete tasks
- Mark tasks as completed
- Global exception handling
- Validation support

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT (jjwt)
- Maven

---

## Authentication Flow

1. User registers
2. User logs in
3. Server returns JWT token
4. Token is used to access protected endpoints

---

## API Endpoints

### Auth
- POST `/auth/register`
- POST `/auth/login`

### Tasks
- GET `/tasks`
- POST `/tasks`
- PUT `/tasks/{id}`
- DELETE `/tasks/{id}`
- PATCH `/tasks/{id}/complete`

---

## How to Run

1. Clone repository
2. Configure MySQL database
3. Update `application.properties`
4. Run:

## Notes
- JWT authentication is implemented
- Passwords are encrypted using BCrypt