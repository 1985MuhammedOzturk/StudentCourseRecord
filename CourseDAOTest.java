package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Course;
import org.cst8288Lab2.util.DatabaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

public class CourseDAOTest {

    private static CourseDAO courseDAO;
    private static Connection connection;

    @BeforeAll
    public static void setup() {
        connection = DatabaseUtil.getConnection();
        courseDAO = new CourseDAO(connection);
    }

    @Test
    public void testInsertCourse() {
        Course course = new Course("cst8288", "Software Design Patterns");
        boolean isInserted = courseDAO.insertCourse(course);
        Assertions.assertTrue(isInserted, "Course should be inserted successfully.");
    }
}
