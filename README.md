# Employee Management API

## Overview
The `EmployeeController` class provides RESTful APIs to manage employee records. It is part of the `com.cvm.week2.Controller` package and interacts with the service and repository layers to handle CRUD operations for employees.

## Table of Contents
- [Features](#features)
- [Endpoints](#endpoints)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)

## Features
- Retrieve employee details by ID.
- Add new employees.
- Retrieve all employees.
- Update existing employee records.
- Delete employee records by ID.
- Retrieve employee details by name.

## Endpoints
### 1. Get Employee by ID
**URL**: `/emp/{id}`

**Method**: `GET`

**Response**: Returns the employee with the specified ID.

### 2. Add New Employee
**URL**: `/emp`

**Method**: `POST`

**Request Body**:
```json
{
  "id": 1,
  "name": "John Doe",
  "department": "Engineering",
  "salary": 50000
}
```

**Response**: Returns the saved employee object.

### 3. Get All Employees
**URL**: `/emp/all`

**Method**: `GET`

**Response**: Returns a list of all employees.

### 4. Update Employee
**URL**: `/emp/{id}`

**Method**: `PUT`

**Request Body**:
```json
{
  "name": "Jane Smith",
  "department": "Marketing",
  "salary": 60000
}
```

**Response**: Returns the updated employee object.

### 5. Delete Employee by ID
**URL**: `/emp/{id}`

**Method**: `DELETE`

**Response**: Returns `true` if the deletion was successful, `404` if the employee was not found.

### 6. Get Employee by Name
**URL**: `/emp/name/{name}`

**Method**: `GET`

**Response**: Returns the employee object with the specified name.

## Prerequisites
- Java 8 or later
- Spring Boot
- Maven or Gradle
- A database (e.g., MySQL, PostgreSQL) configured for use with the application

## Setup
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```bash
   cd project-directory
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage
1. Start the application using the `mvn spring-boot:run` command.
2. Use a tool like Postman or cURL to interact with the API endpoints.
3. Customize the `application.properties` file to connect to your database.

## Note
Ensure all necessary dependencies for Spring Boot and your database are included in the `pom.xml` file.
