# Telia E-shop Backend API

A RESTful API for managing products, stock, orders and customers/users in an e-commerce shop. Built with Java, Spring Boot (bootstrapped with [Spring Initializr](https://start.spring.io/)), and JPA.


## Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Database Schema](#database-schema)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Deployment](#deployment)

## Project Overview

This project is the backend system for an e-shop application. It handles CRUD operations for products, orders, provides functionality for managing inventory, orders, and users, with support for sorting and filtering.

## Tech Stack

- **Java 21 (IntelliJ IDEA 2024.2.3 (Community Edition))**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **Hibernate**
- **H2 in-memory database** (or MySQL for later implementation)
- **Maven** (for project management)
- **Swagger** (for API documentation)
- **JUnit** (for unit testing)

## Database Schema

The following is a visual schema for the e-shop:
![Current_DB_schema](https://github.com/user-attachments/assets/54a7e9e0-fc35-4f53-ac1d-ebe3fc54fa23)

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
2. Set up the database (will be noted afer MySQL implementation!)
- ***Currently, the use of an in-memory H2 database is implemented for the sake of simplicity and portability.***
 
### Running the Application
1. Build the application using Maven:
```bash
mvn clean install
```
2. Run the application:
```bash
mvn spring-boot:run
```
3. The API should now be accessible at: http://localhost:5000/api/shop/products

## API Documentation

Once the app is running, you can access the Swagger API documentation at:
```bash
http://localhost:5000/swagger-ui/index.html
```
Here, you can test some of the currently implemented endpoints, review the request/response format, and explore available routes.

## Deployment

The Spring Boot application is deployed to **AWS**, using **Elastic Beanstalk** as the platform (AWS Elastic Beanstalk is a Platform-as-a-Service (PaaS) that automates application deployment, including scaling, load balancing, and environment setup).
