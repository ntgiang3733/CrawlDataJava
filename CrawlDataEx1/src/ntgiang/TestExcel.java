package ntgiang;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestExcel {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    public static String formatValue(String s) {
        s.replace(". - ", ".\n - ");
        return s;
    }

    public static void main(String[] args) throws IOException {
        String s = "- Có bằng chứng về việc họp giữa Tổ khảo sát sự hài lòng người bệnh với những khoa lâm sàng có tỷ lệ hài lòng thấp nhất. - Có xác định các giải pháp để cải tiến nâng cao tỷ lệ hài lòng.";
        s.replace(". - ", ".\n - ");
//        System.out.println(formatValue("- Có bằng chứng về việc họp giữa Tổ khảo sát sự hài lòng người bệnh với những khoa lâm sàng có tỷ lệ hài lòng thấp nhất. - Có xác định các giải pháp để cải tiến nâng cao tỷ lệ hài lòng."));
        System.out.println(s);
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Employees sheet");
//
//        List<Employee> list = new ArrayList<>();
//
//        Employee e1 = new Employee("E01", "Tom", 200.0, 1, null);
//        Employee e2 = new Employee("E02", "Jerry", 100.2, 2, null);
//        Employee e3 = new Employee("E03", "Donald", 150.0, 2, null);
//        list.add(e1);
//        list.add(e2);
//        list.add(e3);
//
//        int rownum = 0;
//        Cell cell;
//        Row row;
//        //
//        HSSFCellStyle style = createStyleForTitle(workbook);
//
//        row = sheet.createRow(rownum);
//
//        // EmpNo
//        cell = row.createCell(0, CellType.STRING);
//        cell.setCellValue("EmpNo");
//        cell.setCellStyle(style);
//        // EmpName
//        cell = row.createCell(1, CellType.STRING);
//        cell.setCellValue("EmpNo");
//        cell.setCellStyle(style);
//        // Salary
//        cell = row.createCell(2, CellType.STRING);
//        cell.setCellValue("Salary");
//        cell.setCellStyle(style);
//        // Grade
//        cell = row.createCell(3, CellType.STRING);
//        cell.setCellValue("Grade");
//        cell.setCellStyle(style);
//        // Bonus
//        cell = row.createCell(4, CellType.STRING);
//        cell.setCellValue("Bonus");
//        cell.setCellStyle(style);
//
//        // Data
//        for (Employee emp : list) {
//            rownum++;
//            row = sheet.createRow(rownum);
//
//            // EmpNo (A)
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue(emp.getEmpNo());
//            // EmpName (B)
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue(emp.getEmpName());
//            // Salary (C)
//            cell = row.createCell(2, CellType.NUMERIC);
//            cell.setCellValue(emp.getSalary());
//            // Grade (D)
//            cell = row.createCell(3, CellType.NUMERIC);
//            cell.setCellValue(emp.getGrade());
//            // Bonus (E)
//            String formula = "0.1*C" + (rownum + 1) + "*D" + (rownum + 1);
//            cell = row.createCell(4, CellType.FORMULA);
//            cell.setCellFormula(formula);
//        }
//        File file = new File("C:/Users/GNT/Desktop/employee.xls");
//        file.getParentFile().mkdirs();
//
//        FileOutputStream outFile = new FileOutputStream(file);
//        workbook.write(outFile);
//        System.out.println("Created file: " + file.getAbsolutePath());

    }
}
