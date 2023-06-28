package com.microservice.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class StudentService implements IStudentRepository {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;


    @Override
    public void add(Student student) {
        try 
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "INSERT INTO students (name, grade) VALUES (?, ?);";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, student.getName());
                statement.setString(2, student.getGrade());

                // Execute the query
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Student inserted.");
    }

    @Override
    public Student get(int id) {
        Student student = null;
        try 
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "SELECT * FROM students WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                // Execute the query
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("grade"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.printf("Student id: %d, student name: %s, student grade: %s.", student.id, student.name, student.grade);
        return student;
    }

    @Override
    public Collection<Student> getAll() {
        Collection<Student> students = new ArrayList<Student>();
        try 
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "SELECT * FROM students";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                // Execute the query
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    students.add(new Student(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("grade")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    @Override
    public void update(Student student) {
        try 
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "UPDATE students SET name = ?, grade = ? WHERE id = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, student.name);
                statement.setString(2, student.grade);
                statement.setInt(3, student.id);

                // Execute the query
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Student updated.");
    }

    @Override
    public void delete(int id) {
        try 
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sql = "DELETE FROM students WHERE id = ?;";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                // Execute the query
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Student deleted.");
    }
    
}
