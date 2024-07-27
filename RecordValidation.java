package org.cst8288Lab2.validation;

/**
 * 
 * @author moztu
 */

public class RecordValidation implements Validation {

    @Override
    public boolean isValidStudentId(int studentId) {
        return String.valueOf(studentId).length() == 9;
    }

    @Override
    public boolean isValidCourseId(String courseId) {
        return courseId.matches("[A-Z]{3}\\d{4}");
    }

    @Override
    public boolean isValidTerm(int term) {
        return term == 1 || term == 2 || term == 3;
    }

    @Override
    public boolean isValidYear(int year) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return year >= 1967 && year <= currentYear; // Assuming Algonquin College was founded in 1967
    }

    @Override
    public int parseTerm(String term) {
        switch(term.toUpperCase()) {
            case "WINTER":
                return 1;
            case "SUMMER":
                return 2;
            case "FALL":
                return 3;
            default:
                throw new IllegalArgumentException("Invalid term: " + term);
        }
    }
}
