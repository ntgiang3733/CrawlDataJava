package ntgiang.crawldata;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static String formatValue(String s) {
        s.replace(". - ", ".xuongdong - ");
        return s;
    }

    public static void main(String[] args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");

        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // idTieuMuc
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("idTieuMuc");
        cell.setCellStyle(style);
        // tenTieuMuc
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("tenTieuMuc");
        cell.setCellStyle(style);
        // phuongPhapKiemTra
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("phuongPhapKiemTra");
        cell.setCellStyle(style);
        // bangChungKetQua
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("bangChungKetQua");
        cell.setCellStyle(style);
        // muc
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("muc");
        cell.setCellStyle(style);
        // diemToiDa
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("diemToiDa");
        cell.setCellStyle(style);

        for(int i=1700 ; i<1749; i++) {
            rownum++;
            row = sheet.createRow(rownum);

            String url = "https://tieuchi.chatluongbenhvien.vn/node/" + i;
            Document document = Jsoup.connect(url).get();
            Elements allElm = document.getElementsByClass("field-item even");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(allElm.get(0).child(0).child(0).child(0).text());

            for(Element elm: allElm) {
                if(elm.parent().firstElementSibling() != null) {
                    String key = elm.parent().firstElementSibling().text();
                    if(key.equals("Mã số đầy đủ:")) {
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(elm.text());
                    } else if(key.equals("Phương pháp kiểm tra, đánh giá:")) {
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue("'" + elm.text());
                    } else if(key.equals("Bằng chứng, kết quả:")) {
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue("'" + elm.text());
                    } else if(key.equals("Mức điểm:")) {
                        cell = row.createCell(4, CellType.STRING);
                        cell.setCellValue(elm.text());
                    } else if(key.equals("Điểm tối đa:")) {
                        cell = row.createCell(5, CellType.STRING);
                        cell.setCellValue(elm.text());
                    }
                }
            }
        }
        File file = new File("C:/Users/GNT/Desktop/data.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }
}
