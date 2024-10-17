package Project.ClinicManagement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelHandler {
    private static final String FILE_PATH = "clinic_data.xlsx";

    // Method to write patient data into Excel
    public static void writeDataToExcel(List<Patient> patients) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Patients");

        // Create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Age");
        header.createCell(2).setCellValue("Gender");
        header.createCell(3).setCellValue("Disease");

        // Insert patient data
        int rowNum = 1;
        for (Patient patient : patients) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(patient.getName());
            row.createCell(1).setCellValue(patient.getAge());
            row.createCell(2).setCellValue(patient.getGender());
            row.createCell(3).setCellValue(patient.getDisease());
        }

        // Save the data to the Excel file
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
        }
        workbook.close();
    }

    // Method to read patient data from Excel
    public static List<String[]> readDataFromExcel() throws IOException {
        List<String[]> patientDataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int lastCellNum = row.getLastCellNum();
                String[] data = new String[lastCellNum];

                for (int i = 0; i < lastCellNum; i++) {
                    Cell cell = row.getCell(i);
                    data[i] = cell.toString();
                }

                patientDataList.add(data);
            }
            workbook.close();
        }

        return patientDataList;
    }
}