/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Student;
import java.sql.SQLException;

/**
 *
 * @author moztu
 */
public interface StudentDAOInterface {
    boolean insertStudent(Student student) throws SQLException;
}
