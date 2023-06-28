package com.microservice.student;

public class Student {
    int id;
    String name;
    String grade;

    public Student(int id, String name, String grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getGrade(){
        return grade;
    }

    // Setters
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

}
