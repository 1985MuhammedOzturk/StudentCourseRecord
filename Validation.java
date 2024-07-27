/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.validation;

/**
 *
 * @author moztu
 */
public interface Validation {
    boolean isValidStudentId(int studentId);
    boolean isValidCourseId(String courseId);
    boolean isValidTerm(int term);
    boolean isValidYear(int year);
    int parseTerm(String term);
}
