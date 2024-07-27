/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author moztu
 */
public class StudentCourseDAO implements RecordDAOInterface {
    private final Connection connection;

    public StudentCourseDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertRecord(Record record) {
        String sql = "INSERT INTO StudentCourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, record.getStudentId());
            pstmt.setString(2, record.getCourseId());
            pstmt.setInt(3, record.getTerm());
            pstmt.setInt(4, record.getYear());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
