package com.rs.hospital.helper;


import com.rs.hospital.model.Customer;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Title", "Full Name", "E-mail Id", "Mobile Number", "Address", "Deliver Address", "State", "City", "Pincode" };
    static String SHEET = "sheet1";
    static String uploadDir="C:\\Users\\Ranjit\\OneDrive\\Desktop\\project\\17-07-2023\\file";

    public static boolean hasExcelFormat(MultipartFile file) {

       /* if (!TYPE.equals(file.getContentType())) {
            return false;
        }*/
        uploadFile(file);

        return true;
    }
    public static void uploadFile(MultipartFile file) {

        try {

            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }

    public static List<Customer> excelToNewCustomer(InputStream is) {
        try {

            Workbook workbook = WorkbookFactory.create(new File(uploadDir + File.separator +"file.xlsx"));
            //Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Customer> newCustomers = new ArrayList<Customer>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Customer newCustomer = new Customer();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            newCustomer.setTitle(currentCell.getStringCellValue());
                            break;

                        case 1:
                            newCustomer.setFullName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            newCustomer.setEmail(currentCell.getStringCellValue());
                            break;

                        case 3:
                            newCustomer.setMobileNo((long)currentCell.getNumericCellValue());
                            break;

                        case 4:
                            newCustomer.setAddress(currentCell.getStringCellValue());
                            break;

                        case 5:
                            newCustomer.setDeliveryAddress(currentCell.getStringCellValue());
                            break;

                        case 6:
                            newCustomer.setState(currentCell.getStringCellValue());
                            break;

                        case 7:
                            newCustomer.setCity(currentCell.getStringCellValue());
                            break;

                        case 8:
                            newCustomer.setPincode((long)currentCell.getNumericCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                newCustomers.add(newCustomer);
            }

            workbook.close();

            return newCustomers;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
