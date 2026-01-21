# Flower Shop Application – Test Cases

This document contains **functional test cases** for the Flower Shop REST API.

---

## Test Environment

- Backend: Spring Boot
- Database: MongoDB
- Base URL: `http://localhost:8080/api`
- Tool: Postman / Curl

---

## 👤 User Module Test Cases

### TC-USER-01: Register User (Valid)

**API**  
`POST /api/users`

**Request Body**
```json
{
  "name": "Karun Kumar",
  "email": "karunkumar02525@gmail.com"
}
```

## Test Source Structure

This document describes the test package layout under `src/test/java` for the Flower Shop application.

## Directory Tree

```
src/test/java
└── com.flowershop
    ├── controller
    │   ├── UserControllerTest.java
    │   ├── ProductControllerTest.java
    │   └── OrderControllerTest.java
    │
    ├── service
    │   ├── UserServiceTest.java
    │   ├── ProductServiceTest.java
    │   └── OrderServiceTest.java
    │
    └── repository
        └── RepositoryIntegrationTest.java
```