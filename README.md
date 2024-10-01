# Telia E-shop Backend API

A RESTful API for managing products, stock, orders and customers/users in an e-commerce shop. Built with Java, Spring Boot (initialized with Spring Ini), and JPA.


## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Database Schema](#database-schema)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)

## Project Overview

This project is the backend system for an e-shop application. It handles CRUD operations for products, orders, provides functionality for managing inventory, orders, and users, with support for sorting and filtering.

## Tech Stack

- **Java 21**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **Hibernate**
- **H2 in-memory database** (or MySQL for later implementation)
- **Maven** (for project management)
- **Swagger** (for API documentation)
- **JUnit** (for unit testing)

## Database Schema

The following is a visual schema for the e-shop:
![tes_db_structure](https://github.com/user-attachments/assets/a3e51c23-cab9-48ac-921a-958f97a71d00)

## Getting Started
### Prerequisites
Make sure you have the following installed on your machine:
- **Java 21**
- **Maven 3.3.9**
- **MySQL** (for later implementation)
- **Docker** (if running with Docker)

### Installation
1. Clone the repository
```bash
git clone https://github.com/HenriRa/tes1.git
cd tes1 
```
2. Set up the database (only afer MySQL implementation!)
 
### Running the Application
1. Build the application using Maven:
```bash
mvn clean install
```
2. Run the application:
```bash
mvn spring-boot:run
```
3. The API should now be accessible at: http://localhost:5000

## API Documentation

Once the app is running, you can access the Swagger API documentation at:
```bash
http://localhost:5000/swagger-ui/index.html
```
Here, you can test the endpoints, review the request/response format, and explore available routes.
