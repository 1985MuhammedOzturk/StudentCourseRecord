package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Student;
import org.cst8288Lab2.util.DatabaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

public class StudentDAOTest {

    private static StudentDAO studentDAO;
    private static Connection connection;

    @BeforeAll
    public static void setup() {
        connection = DatabaseUtil.getConnection();
        studentDAO = new StudentDAO(connection);
    }

    @Test
    public void testInsertStudent() {
        Student student = new Student(123456789, "John", "Smith");
        boolean isInserted = studentDAO.insertStudent(student);
        Assertions.assertTrue(isInserted, "Student should be inserted successfully.");
    }
}
