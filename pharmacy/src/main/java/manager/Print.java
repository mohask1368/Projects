package manager;

import entity.Drug;
import javafx.stage.FileChooser;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.*;
import java.util.List;

public class Print implements Serializable  {

public static void print() throws IOException {


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File As...");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(" MS Excel", ".xlsx"));
        File file = fileChooser.showSaveDialog(null);

        if ( file != null ) {
            try {

                List<Drug> drugs;
                String sheetName = "Sheet1";//name of sheet
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet(sheetName) ;
                sheet.setColumnWidth(0, 2000);
                sheet.setColumnWidth(1, 7500);
                sheet.setColumnWidth(2, 7500);
                sheet.setColumnWidth(3, 12000);
                XSSFFont font = wb.createFont();
                font.setFontHeightInPoints((short) 14);
                font.setFontName("ARIAL");
                font.setItalic(false);
                font.setColor(HSSFColor.BLACK.index);
                font.setBold(true);

                XSSFFont cellFont = wb.createFont();
                cellFont.setFontHeightInPoints((short) 12);
                cellFont.setFontName("ARIAL");
                cellFont.setItalic(false);
                cellFont.setColor(HSSFColor.BLACK.index);
                cellFont.setBold(false);

                XSSFCellStyle titleCellFormat = wb.createCellStyle();
                titleCellFormat.setFont(font);
                titleCellFormat.setWrapText(true);
                titleCellFormat.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                titleCellFormat.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                titleCellFormat.setBorderBottom(BorderStyle.THIN);
                titleCellFormat.setBorderLeft(BorderStyle.THIN);
                titleCellFormat.setBorderRight(BorderStyle.THIN);
                titleCellFormat.setBorderTop(BorderStyle.THIN);
                titleCellFormat.setTopBorderColor(IndexedColors.BLACK.getIndex());
                titleCellFormat.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                titleCellFormat.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                titleCellFormat.setRightBorderColor(IndexedColors.BLACK.getIndex());
                titleCellFormat.setAlignment(HorizontalAlignment.CENTER);
                titleCellFormat.setVerticalAlignment(VerticalAlignment.CENTER);

                XSSFCellStyle CellFormat = wb.createCellStyle();
                CellFormat.setFont(cellFont);
                CellFormat.setBorderBottom(BorderStyle.THIN);
                CellFormat.setBorderLeft(BorderStyle.THIN);
                CellFormat.setBorderRight(BorderStyle.THIN);
                CellFormat.setBorderTop(BorderStyle.THIN);
                CellFormat.setTopBorderColor(IndexedColors.BLACK.getIndex());
                CellFormat.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                CellFormat.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                CellFormat.setRightBorderColor(IndexedColors.BLACK.getIndex());
                CellFormat.setAlignment(HorizontalAlignment.CENTER);
                CellFormat.setVerticalAlignment(VerticalAlignment.CENTER);

                SessionFactory sf = new Configuration().configure("/config/ProjectConfig.xml").buildSessionFactory();
                Session session = sf.openSession();
                Query query = session.createQuery("FROM Drug");
                drugs = query.list();
                XSSFRow row;

                int rowId = 0;
                int columnId = 0;
                row = sheet.createRow(rowId);

                XSSFCell cell = row.createCell(columnId);
                cell.setCellStyle(titleCellFormat);

                cell.setCellValue("کد دارو");
                columnId++;
                cell = row.createCell(columnId);
                cell.setCellStyle(titleCellFormat);
                cell.setCellValue("نام دارو");
                columnId++;
                cell = row.createCell(columnId);
                cell.setCellStyle(titleCellFormat);
                cell.setCellValue("قیمت دارو");
                columnId++;
                cell = row.createCell(columnId);
                cell.setCellStyle(titleCellFormat);
                cell.setCellValue("موارد مصرف ");


                rowId = 1;
                 columnId = 0;

                for (int i=0 ; i< drugs.size() ; i++) {

                    row = sheet.createRow(rowId);
                    columnId = 0 ; //start from beginning line
                    cell = row.createCell(columnId);
                    cell.setCellStyle(CellFormat);
                    cell.setCellValue(drugs.get(i).getId());
                    columnId++;

                    cell = row.createCell(columnId);
                    cell.setCellStyle(CellFormat);
                    cell.setCellValue(drugs.get(i).getName());
                    columnId++;

                    cell = row.createCell(columnId);
                    cell.setCellStyle(CellFormat);
                    cell.setCellValue(drugs.get(i).getPrice());
                    columnId++;

                    cell = row.createCell(columnId);
                    cell.setCellStyle(CellFormat);
                    cell.setCellValue(drugs.get(i).getUseCase());

                    rowId++; //go to the next row
                }

                FileOutputStream fileOut = new FileOutputStream(file);

                //write this workbook to an Outputstream.
                wb.write(fileOut);
                fileOut.flush();
                fileOut.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

}
}
