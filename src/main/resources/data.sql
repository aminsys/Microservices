-- CREATE DATABASE IF NOT EXISTS dev_database;
USE dev_database;

-- Drop table students if it exists
DROP TABLE IF EXISTS students;

-- Create a new table called students
CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  grade VARCHAR(10) NULL
);

-- Insert som dummy values:

INSERT INTO students VALUES (1000, "Samir Hassan", "MVG");
INSERT INTO students VALUES (1001, "Kalle Håkansson", "G");
INSERT INTO students VALUES (1002, "Urban Vass", "MVG");
INSERT INTO students VALUES (1003, "Dalal Elahmar", "G");
INSERT INTO students VALUES (1004, "Saleman Salemansson", "VG");
INSERT INTO students VALUES (1005, "Iyori Kanna", "VG");
INSERT INTO students VALUES (1006, "Daniel Rickard von Haus", "G");
INSERT INTO students VALUES (1007, "Malik Mahfuuz", "G");
INSERT INTO students VALUES (1008, "Shaqiri Thomsson", "VG");
INSERT INTO students VALUES (1009, "Mustafa Kamil", "B-");
INSERT INTO students VALUES (1010, "Lupita Nyong\'o", "A+");
INSERT INTO students VALUES (1011, "Yemi Alade", "C");
