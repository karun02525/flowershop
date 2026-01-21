# Business Objective

---
## Core Modules

### User Module
- Register users
- View user details
- Link orders to users

Example users:
- **Karun Kumar** – karunkumar02525@gmail.com
- **Bhanu Priya** – priya02525@gmail.com

---

### 🌸 Product Module
- Manage flower products as `Product`
- View product list
- Update product details
- Manage stock

Example products:
- Red Rose Bouquet
- White Lily
- Orchid Flower Box

---

### 🛒 Order Module
- Place orders
- Calculate total amount
- Reduce product stock
- View user order history

Each order:
- Belongs to a user
- Contains multiple products
- Has status (PLACED)

---

## Application Flow

User registers
↓
User browses products
↓
User selects products & quantity
↓
User places order
↓
Order saved in database
↓
Product stock updated


---

## Design Principles Used

- **Clean Architecture**
- **Loose Coupling**
- **Single Responsibility Principle**
- **Dependency Inversion**
- Interface-based services
- Technology-agnostic business logic

---

## Backend Project Structure

controller → REST endpoints
service → Business logic
repository → Data access (MongoDB)
model → Domain models



MongoDB is fully hidden behind repository abstractions.

---

## 📱 Client UI Overview

The mobile UI represents:
- User list
- Product list
- Cart & order placement
- Recent orders

The UI communicates with backend APIs via HTTP.

---

## 🧪 Testing & Dummy Data

- Dummy users and products are provided
- API can be tested using Postman
- MongoDB collections:
  - `users`
  - `products`
  - `orders`

---

## Extensibility

This project can be easily extended with:
- JWT authentication
- Role-based access (Admin/User)
- Cart persistence
- Payment gateway
- Order status tracking
- Notifications

---

## Summary

The Flower Shop Application is:
- Simple but realistic
- Cleanly architected
- Easy to understand
- Scalable for future enhancements

---

