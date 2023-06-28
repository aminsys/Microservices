package com.microservice.student;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    @ResponseBody
    public Collection<Student> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable int id){
        return studentService.get(id);
    }

    @PostMapping("/students/new")
    public void addNewStudent(@RequestBody Student student){
        studentService.add(student);
    }

    @PutMapping("/students/update/{id}")
    public void updateStudent(@RequestBody Student student){
        studentService.update(student);
    }

    @DeleteMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }
}
