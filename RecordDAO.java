package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author moztu
 */

public class RecordDAO implements RecordDAOInterface {

    private Connection connection;

    public RecordDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertRecord(Record record) {
        String sql = "INSERT INTO StudentCourse (studentId, firstName, lastName, courseId, courseName, term, year) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, record.getStudentId());
            pstmt.setString(2, record.getFirstName());
            pstmt.setString(3, record.getLastName());
            pstmt.setString(4, record.getCourseId());
            pstmt.setString(5, record.getCourseName());
            pstmt.setInt(6, record.getTerm());
            pstmt.setInt(7, record.getYear());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
