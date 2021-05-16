package com.example.restservice;

import com.example.restservice.controllers.EquationController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

@Component
public class ExcelBuilder {

    private static final Logger logger = LogManager.getLogger(EquationController.class);

    public void buildExcel(Collection<Equation> equationList) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Equation List");
        sheet.setDefaultColumnWidth(20);
        HSSFRow header = sheet.createRow(0);
        int rowCount = 1;

        header.createCell(0).setCellValue("First parameter");
        header.createCell(1).setCellValue("Second parameter");
        header.createCell(2).setCellValue("Equation");
        header.createCell(3).setCellValue("Root of equation");

        for (Equation equation : equationList) {
            HSSFRow row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(equation.getA());
            row.createCell(1).setCellValue(equation.getB());
            row.createCell(2).setCellValue(equation.getStr());
            row.createCell(3).setCellValue(equation.getX());
        }
        try {
            FileOutputStream out = new FileOutputStream(ExcelFile.sheet);
            workbook.write(out);
            out.close();
            logger.info("Excel sheet is created");
        } catch (IOException e) {
            logger.error("Creating error");
            e.printStackTrace();
        }
    }
}

