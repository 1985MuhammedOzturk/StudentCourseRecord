/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.util;

/**
 *
 * @author moztu
 */
public class Validator {
    public static boolean isValidStudentId(int studentId) {
        return String.valueOf(studentId).length() == 9;
    }

    public static boolean isValidCourseId(String courseId) {
        return courseId.matches("[A-Z]{3}\\d{4}");
    }

    public static boolean isValidTerm(int term) {
        return term >= 1 && term <= 3;
    }

    public static boolean isValidYear(int year) {
        return year >= 1967 && year <= java.time.Year.now().getValue(); // Assuming 1967 as founding year
    }

    public static int parseTerm(String term) {
        switch (term.toUpperCase()) {
            case "WINTER" -> {
                return 1;
            }
            case "SUMMER" -> {
                return 2;
            }
            case "FALL" -> {
                return 3;
            }
            default -> throw new IllegalArgumentException("Invalid term: " + term);
        }
    }
}