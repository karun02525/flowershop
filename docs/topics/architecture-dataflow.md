# Architecture
🌸Flower Shop REST API

A simple **Flower Shop application** built using **Spring Boot** and **MongoDB**, following **Clean Architecture** and **loose coupling** principles.  
Users can register, view products, and place orders.

- ![arch_flow.png](arch_flow.png)
- ![img_1.png](img_1.png)
- ![img_2.png](img_2.png)

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data MongoDB
- Maven

### Client
- Mobile App UI (concept)
- REST API based communication

---

## Features

- User registration
- View flower products (`Product`)
- Place orders
- View order history
- Clean and scalable architecture

---

## Architecture Overview

``````
Client (Mobile App)
|
| REST API
v
Controller Layer
|
v
Service Layer (Interfaces)
|
v
Repository Layer
|
v
MongoDB
---

