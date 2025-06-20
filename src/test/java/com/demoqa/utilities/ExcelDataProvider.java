package com.demoqa.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {

    @DataProvider(name = "excelData")
    public Object[][] readExcel() throws IOException {
        String filePath = "src/test/resources/testData.xlsx";
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue();
            data[i - 1][1] = row.getCell(1).getStringCellValue();
        }

        workbook.close();
        return data;
    }
}
