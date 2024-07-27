package org.cst8288Lab2.dao;

import java.sql.Connection;
import org.cst8288Lab2.util.DatabaseUtil;

/**
 * 
 * @author moztu
 */

public class DAOFactory {

    public static RecordDAOInterface getRecordDAO() {
        Connection connection = DatabaseUtil.getConnection();
        return new RecordDAO(connection);
    }

    public static CourseDAOInterface getCourseDAO() {
        Connection connection = DatabaseUtil.getConnection();
        return new CourseDAO(connection);
    }

    public static StudentDAOInterface getStudentDAO() {
        Connection connection = DatabaseUtil.getConnection();
        return new StudentDAO(connection);
    }
}
