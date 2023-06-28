# Microservices
Microservices in Java

This microservice is built with MySQL as its backend database. This current version of the microservice works with one table (called student) ONLY.

The connection string for the database is specified in the `application.properties` file and looks something like this:

spring.datasource.url=jdbc:mysql://localhost:3306/database

The username and password that are used to access the database are also specified in the `application.properties` file and their keys are:

spring.datasource.username={INPUT YOUR USERNAME}


spring.datasource.password={INPUT YOUR PASSWORD}

Use the following script to create the table student in the MySQL database:

CREATE TABLE students (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  name TEXT NOT NULL,
  grade TEXT NULL
);