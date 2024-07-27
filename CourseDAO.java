package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.cst8288Lab2.model.Course;
/**
 * 
 * @author moztu
 */

public class CourseDAO implements CourseDAOInterface {

    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCourse(Course course) {
        String sql = "INSERT INTO Courses (courseId, courseName) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, course.getCourseId());
            pstmt.setString(2, course.getCourseName());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
