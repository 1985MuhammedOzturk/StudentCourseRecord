/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.model;

/**
 *
 * @author moztu
 */
public class Record {
    private int studentId;
    private String firstName;
    private String lastName;
    private String courseId;
    private String courseName;
    private int term;
    private int year;

    public Record(int studentId, String firstName, String lastName, String courseId, String courseName, int term, int year) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.term = term;
        this.year = year;
    }

    // Getters and Setters for all fields

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}