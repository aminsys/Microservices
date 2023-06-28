package com.microservice.student;

import java.util.Collection;

public interface IStudentRepository {
    void add(Student student);
    Student get(int id);
    void update(Student student);
    void delete(int id);
    Collection<Student> getAll();
}
