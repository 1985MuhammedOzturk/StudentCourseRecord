package org.cst8288Lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.cst8288Lab2.dao.DAOFactory;
import org.cst8288Lab2.dao.RecordDAOInterface;
import org.cst8288Lab2.model.Record;
import org.cst8288Lab2.util.ReportGenerator;
import org.cst8288Lab2.validation.RecordValidation;


/**
 * 
 * @author moztu
 */

public class Lab2Starter {

    public static void main(String[] args) throws SQLException {
        String csvFile = "./data/bulk-import.csv";
        List<String> errorMessages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            RecordValidation validator = new RecordValidation();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 7) {
                    try {
                        int studentId = Integer.parseInt(values[0]);
                        String firstName = values[1];
                        String lastName = values[2];
                        String courseId = values[3];
                        String courseName = values[4];
                        int term = validator.parseTerm(values[5]);
                        int year = Integer.parseInt(values[6]);

                        if (validator.isValidStudentId(studentId) &&
                            validator.isValidCourseId(courseId) &&
                            validator.isValidTerm(term) &&
                            validator.isValidYear(year)) {
                            Record record = new Record(studentId, firstName, lastName, courseId, courseName, term, year);
                            RecordDAOInterface recordDAO = DAOFactory.getRecordDAO();
                            if (!recordDAO.insertRecord(record)) {
                                errorMessages.add("Failed to insert record: " + line);
                            }
                        } else {
                            errorMessages.add("Invalid record: " + line);
                        }
                    } catch (NumberFormatException e) {
                        errorMessages.add("Invalid record format: " + line);
                    }
                } else {
                    errorMessages.add("Invalid record format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReportGenerator.generateReports(errorMessages);
    }
}
