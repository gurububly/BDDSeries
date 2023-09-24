package utilities;

import constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    private ExcelUtils() {
    }

    static FileInputStream fis;
    static Workbook wb;
    static List<Map<String, String>> list = null;

    public static List<Map<String, String>> getTestData(String sheetName) {

        try {
            fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
            wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum();
            int columnNum = sheet.getRow(0).getLastCellNum();
            Map<String, String> hmap;
            list = new ArrayList<>();
            for (int i = 1; i <= rowNum; i++) {
                hmap = new HashMap<>();
                for (int j = 0; j < columnNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    hmap.put(key, value);
                }
                list.add(hmap);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return list;
    }
}
