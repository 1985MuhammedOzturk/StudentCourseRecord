package org.cst8288Lab2.dao;

import org.cst8288Lab2.model.Record;
import org.cst8288Lab2.util.DatabaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

public class RecordDAOTest {

    private static RecordDAO recordDAO;
    private static Connection connection;

    @BeforeAll
    public static void setup() {
        connection = DatabaseUtil.getConnection();
        recordDAO = new RecordDAO(connection);
    }

    @Test
    public void testInsertRecord() {
        Record record = new Record(123456789, "John", "Smith", "cst8288", "Software Design Patterns", 1, 2024);
        boolean isInserted = recordDAO.insertRecord(record);
        Assertions.assertTrue(isInserted, "Record should be inserted successfully.");
    }
}
