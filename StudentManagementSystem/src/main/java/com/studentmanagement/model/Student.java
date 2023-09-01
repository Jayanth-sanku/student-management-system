package com.studentmanagement.model;

public class Student {
    private int id; // Add the ID field
    private String name;
    private String rollNumber;
    private String contact;
    private String course;
    private String grade;

    public Student(int id, String name, String rollNumber, String contact, String course, String grade) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.contact = contact;
        this.course = course;
        this.grade = grade;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", contact='" + contact + '\'' +
                ", course='" + course + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
