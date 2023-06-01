import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.A;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CsvBD {

    public static ArrayList<String> list_enty = new ArrayList<String>();

    public CsvBD(ArrayList<Tool> tools) {
//        list_enty.clear();
//        StringBuilder stringBuilder = new StringBuilder();
//        String fileName = "C:\\1.csv";
//
//        File myFile = new File("C:\\#Спецификация актуальная новая.xlsm");
//        try {
//            FileInputStream fis = new FileInputStream(myFile);
//            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
//
//            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
//            Iterator<Row> rowIterator = mySheet.iterator();
//            int i = 0;
//
//
//            while (rowIterator.hasNext()) {
//                stringBuilder.delete(0,stringBuilder.length());
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                i++;
////                System.out.print(i +":: ");
////                System.out.println("        ::::: END");
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    //list_enty.add(cell.);
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                           // System.out.print(cell.getStringCellValue() + "\t");
//                            stringBuilder.append(cell.getStringCellValue());
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                           // System.out.print(cell.getNumericCellValue() + "\t");
//                            stringBuilder.append(cell.getNumericCellValue());
//                            break;
//                        case Cell.CELL_TYPE_BOOLEAN:
//                            //System.out.print(cell.getBooleanCellValue() + "\t");
//                            stringBuilder.append(cell.getBooleanCellValue());
//                            break;
//                        default:
//                    }
//                    stringBuilder.append(" || ");
//                  //  System.out.print("  type "+ cell.getCellType() + " | " );
//
//                   // stringBuilder.
//                }
//                list_enty.add(stringBuilder.toString());
//               // System.out.println("cooount  " + i +"-------------------");
//
//
//
//
//
//            }
//
//            //  Iterator<Row> rowIterator = mySheet.iterator();
//           // System.out.println(list_enty);
//            for (String element : list_enty) {
//                System.out.println();
//                System.out.println(element);
//            }
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//

    }

    private static boolean checkCall(Cell cell){



        return true;
    }
}
