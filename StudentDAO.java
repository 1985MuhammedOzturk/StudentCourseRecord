package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.cst8288Lab2.model.Student;

/**
 * 
 * @author moztu
 */

public class StudentDAO implements StudentDAOInterface {

    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertStudent(Student student) {
        String sql = "INSERT INTO Students (studentId, firstName, lastName) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
