/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Course;
import java.sql.SQLException;

/**
 *
 * @author moztu
 */
public interface CourseDAOInterface {
    boolean insertCourse(Course course) throws SQLException;
}