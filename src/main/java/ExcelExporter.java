import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
/*
* COPYRIGHT SMNSHUVO
* THIS IS A SUB PROJECT
* UNDER THE MAIN PROJECT
* CLASS RESERVATION SYSTEM
* THIS PROJECT IS USED TO
* GET EMPTY ROOMS FROM THE
* EXCEL FILE, FOLLOWING MY PYTHON PROJECT
* WHICH I MYSELF DON'T UNDERSTAND NOW.
* WHILE CODING THAT PROJECT ONLY GOD
* AND I KNEW WHAT I WAS CODING,
* NOW MONTHS AFTER COMPLETING THAT
* PROJECT ONLY GOD KNOWS
* WHAT I HAVE HAD CODED
* xD
 */
public class ExcelExporter {
    public static final String ROUTINE_XL = "G://xl.project/src/main/files/routine.xlsx";
    private static int startingCell, sundayStartRow,
                                mondayStartRow , tuesdayStartRow,
                                    wednesdayStartRow, thursdayStartRow;


    public static void main(String[] args) {
        Sheet routine_sheet=null; // declared it outside of block to access it in a function

        try{
            FileInputStream routine_excel = new FileInputStream(new File(ROUTINE_XL));
            Workbook workbook = new XSSFWorkbook(routine_excel); // Workbook is excel sheet holder
            routine_sheet = workbook.getSheetAt(0); // get the first sheet
            Iterator<Row> cellIterator = routine_sheet.iterator();

            while (cellIterator.hasNext()){

                Row currentRow = cellIterator.next();
                Iterator <Cell> iterator = currentRow.iterator();
                    while (iterator.hasNext()){
                        Cell currentCell = iterator.next();

                        if ( currentCell.getStringCellValue().toUpperCase().contains("SATURDAY")) { // if that cell has the value Saturday
                            // If you get saturday you must find sunday to know your limit
                            startingCell = currentCell.getRowIndex();
                            System.out.println(startingCell);
                            // everything above sunday is your limit
                        }

                        if (currentCell.getStringCellValue().toUpperCase().contains("SUNDAY")){
                            sundayStartRow = currentCell.getRowIndex();
                            System.out.println(sundayStartRow);
                        }

                        if (currentCell.getStringCellValue().toUpperCase().contains("MONDAY")){
                            mondayStartRow = currentCell.getRowIndex();
                            System.out.println(mondayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("TUESDAY")){
                            tuesdayStartRow = currentCell.getRowIndex();
                            System.out.println(tuesdayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("WEDNESDAY")){
                            wednesdayStartRow = currentCell.getRowIndex();
                            System.out.println(wednesdayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("THURSDAY")){
                            thursdayStartRow = currentCell.getRowIndex();
                            System.out.println(thursdayStartRow);
                        }


                    }
                System.out.println("");

            }
        } catch (Exception e){
            System.err.print("FILE NOT FOUND");
        } finally {
            getEmptyRooms(routine_sheet);
        }


    }

    // TO DO: NEED A FUNCTION TO GET THE STARTING AND ENDING POINT

    public static ArrayList<String> getEmptyRooms(Sheet routine){
        ArrayList<String> emptyRooms = new ArrayList<String>();

            Iterator<Row> RowIterator = routine.iterator(); // iterate my row
            for (int row = 0; row < 21 ; row++) {
                Row currentRow = RowIterator.next(); // get a row by moving the iterator to next index
                Cell currentCourseCell = currentRow.getCell(1); // get a cell by pointing the cell index of a row
                Cell currentRoomCell = currentRow.getCell(0);
                if (currentCourseCell.getStringCellValue().isEmpty()) { // these are the empty rooms
                    System.out.println(currentRoomCell.getStringCellValue()); // print the element of current row
                }
            }

        return emptyRooms;

    }
}
