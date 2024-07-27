package org.cst8288Lab2.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author moztu
 */
public class ReportGenerator {

    public static void generateReports(List<String> errorMessages) {
        generateSuccessReport();
        generateErrorReport(errorMessages);
    }

    private static void generateSuccessReport() {
        try (FileWriter writer = new FileWriter("./data/import-report.md")) {
            writer.write("# Success Report\n");
            writer.write("Date and Time: " + LocalDateTime.now() + "\n");
            writer.write("Number of records added: 0\n");  // Update this to reflect actual records added
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateErrorReport(List<String> errorMessages) {
        try (FileWriter writer = new FileWriter("./data/error-report.md")) {
            writer.write("# Error Report\n");
            for (String errorMessage : errorMessages) {
                writer.write(errorMessage + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
