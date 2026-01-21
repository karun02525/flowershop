# 🌸 Flower Shop Application – Setup Guide

This document explains how to set up the **Flower Shop REST API** and a **Mobile App UI client** step by step.

---

## Tech Stack

### Backend
- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven

### Frontend (Mobile UI)
- Android (Kotlin) iOS Swift
- Jetpack Compose
- Retrofit
- Coroutines
- REST API integration

---

## 🏗️ Backend Setup (Spring Boot + MongoDB)

### 1️⃣ Prerequisites
- Java 17 installed
- Maven installed
- MongoDB installed and running
- IDE (IntelliJ / VS Code / Eclipse)

---

### 2️⃣ Create Spring Boot Project

Use **Spring Initializr**:
- Project: Maven
- Language: Java
- Spring Boot: latest stable
- Group: `com.flowershop`
- Artifact: `flower-shop`
- Dependencies:
  - Spring Web
  - Spring Data MongoDB
  - Lombok

---

### 3️⃣ Project Structure

