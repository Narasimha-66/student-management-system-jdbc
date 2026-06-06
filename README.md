# Student Management System (Java, JDBC, MySQL)

## Overview

A console-based Student Management System developed using Java, JDBC, MySQL, and Maven. The application performs CRUD (Create, Read, Update, Delete) operations and Search functionality on student records stored in a MySQL database.

## Features

* Add Student
* View All Students
* Search Student by Roll Number
* Update Student Details
* Delete Student Records
* JDBC-Based Database Connectivity
* MySQL Database Integration

## Technologies Used

* Java
* JDBC
* MySQL
* Maven
* Object-Oriented Programming (OOP)

## Database Schema

```sql
CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    marks DOUBLE
);
```

## Project Structure

```text
src
└── main
    └── java
        └── com.simha
            ├── Main.java
            ├── Student.java
            ├── StudentDAO.java
            ├── DBConnection.java
            └── TestConnection.java
```

## How to Run

1. Clone the repository.
2. Create the MySQL database and table.
3. Update MySQL username and password in `DBConnection.java`.
4. Run `Main.java`.
5. Use the menu to perform CRUD and Search operations.

## Learning Outcomes

* JDBC Architecture
* Database Connectivity using Java
* CRUD Operations
* Search Operations using SQL
* PreparedStatement and Statement
* ResultSet Handling
* Maven Dependency Management
* MySQL Integration

## Author

Narasimha Jaladurgam
