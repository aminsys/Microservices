# Microservices - a demo project written in Sping Boot and MySQL
The aim of this project is to gain a fundamental understanding of how microservices are developed, tested and maintained.

This microservice is built with MySQL as its backend database. This current version of the microservice works with one table (called student) ONLY.

The connection string for the database is specified in the `application.properties` file and looks something like this:
```
spring.datasource.url=jdbc:mysql://localhost:3306/your-own-database
```

The username and password that are used to access the database are also specified in the `application.properties` file and their keys are:
```
spring.datasource.username={INPUT YOUR USERNAME}
spring.datasource.password={INPUT YOUR PASSWORD}
```

The design for the students table in MySQL database dev_database:
```sql
CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  grade VARCHAR(10) NULL
);
```

This version of microservice is running against a MySQL server container. To setup the container user the following commands in terminal:

```t
# Pull MySQL DOcker Image:
docker pull mysql

# Start MySQL server container:
docker run -d --name mysql-server -p 3306:3306 -e MYSQL_ROOT_PASSWORD=<INPUT YOUR NEW OWN PASSWORD FOR ROOT> mysql
```

Currently, you will need to create the database `your-own-database` manually. Also, you will need to create own username and password to be used in `application.properties`:

```t
# Run the following to open mysql terminal: (You will use the password specified in <INPUT YOUR NEW OWN PASSWORD FOR ROOT>)
mysql -u root -p

# Create the database:
CREATE DATABASE IF NOT EXISTS your-own-database;

# then, create username and give the user privileges:
CREATE USER 'admin'@'%' IDENTIFIED BY '<SET YOUR NEW OWN PASSWORD>';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
exit
```
