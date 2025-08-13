# Inventory Management System

A role-based Inventory Management backend system built using **Java**, **Spring Boot**, and **PostgreSQL**, designed to manage users and products with proper access control.

## 🔐 Features

- **User Roles**: `ADMIN` and `USER`
- **Authentication**: Spring Security (basic auth)
- **User Capabilities**:
  - Register and log in
  - Add and view their own products
- **Admin Capabilities**:
  - Manage all users
  - View and manage all products
- **Modular Architecture**:
  - Clean separation of concerns (Controller, Service, Repository, Entity, DTO)
- **Database**: PostgreSQL
- **Tested with**: Postman

## 📁 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven

## 🚀 API Endpoints Overview

### 🔑 Authentication

- `POST /api/auth/register` – Register a new user (user/admin)
- `POST /api/auth/login` – Basic login (username & password)

### 👥 User Management (Admin only)

- `GET /api/users` – Get all users
- `DELETE /api/users/{id}` – Delete a user

### 📦 Product Management

- `POST /api/products` – Add product (User/Admin)
- `GET /api/products` – Get products (User sees their own, Admin sees all)
- `PUT /api/products/{id}` – Update product
- `DELETE /api/products/{id}` – Delete product
  

## 🛠 Setup Instructions

1. **Clone the repository**  
   git clone https://github.com/sauravbudhathoki/inventory-management.git  
   cd inventory-management  
2. **Configure PostgreSQL**  
   Create a database (e.g., `inventory_db`) and update your `application.properties`:

   spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db  
   spring.datasource.username=your_username  
   spring.datasource.password=your_password
   
4. **Run the project**  
   You can use your IDE or run:  
   mvn spring-boot:run  
5. **Test with Postman**  
   - Use Basic Auth for protected routes.  
   - Register user → Log in → Use credentials to access secured endpoints.

**📸 Sample Roles**  
Default roles: USER, ADMIN  
These can be assigned when registering or programmatically.

**🧑‍💻 Author**  
Saurab Budhathoki



