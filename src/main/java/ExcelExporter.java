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
import java.util.List;


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
                            /* This +1 is added as the row it finds the text Saturday
                             * The day actually starts from the next row
                             * NO NEED !!!!
                             */
                            System.err.println(startingCell);
                            // everything above sunday is your limit
                        }

                        if (currentCell.getStringCellValue().toUpperCase().contains("SUNDAY")){
                            sundayStartRow = currentCell.getRowIndex()+1;
                            System.out.println(sundayStartRow);
                        }

                        if (currentCell.getStringCellValue().toUpperCase().contains("MONDAY")){
                            mondayStartRow = currentCell.getRowIndex()+1;
                            System.out.println(mondayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("TUESDAY")){
                            tuesdayStartRow = currentCell.getRowIndex()+1;
                            System.out.println(tuesdayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("WEDNESDAY")){
                            wednesdayStartRow = currentCell.getRowIndex()+1;
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
            getEmptyRooms(routine_sheet, startingCell, sundayStartRow, "Saturday");


        }


    }

    // TO DO: NEED A FUNCTION TO GET THE STARTING AND ENDING POINT

    public static ArrayList<String> getEmptyRooms(Sheet routine, int startingCell, int endingCell, String dayOfWeek){
        ArrayList<String> emptyRooms = new ArrayList<String>();

            Iterator<Row> RowIterator = routine.iterator(); // iterate my row

            ArrayList<EmptyRoom> emptyRoomOfSaturday = new ArrayList<EmptyRoom>();

            for (int row = startingCell; row < endingCell ; row++) {
                //currentRow = RowIterator.next(); // get a row by moving the iterator to next index
                Row currentRow = routine.getRow(row);

                Cell currentCourseCell_p1 = currentRow.getCell(1); // get a cell by pointing the cell index of a row
                Cell currentRoomCell_p1 = currentRow.getCell(0);

                Cell currentCourseCell_p2 = currentRow.getCell(4); // get a cell by pointing the cell index of a row
                Cell currentRoomCell_p2 = currentRow.getCell(3);

                Cell currentCourseCell_p3 = currentRow.getCell(7); // get a cell by pointing the cell index of a row
                Cell currentRoomCell_p3 = currentRow.getCell(6);

                Cell currentCourseCell_p4 = currentRow.getCell(10); // get a cell by pointing the cell index of a row
                Cell currentRoomCell_p4 = currentRow.getCell(9);

                Cell currentCourseCell_p5 = currentRow.getCell(13); // get a cell by pointing the cell index of a row
                Cell currentRoomCell_p5 = currentRow.getCell(12);

                Cell currentCourseCell_p6 = currentRow.getCell(16); // get a cell by pointing the cell index of a row
                Cell currentRoomCell_p6 = currentRow.getCell(15);


                if (currentCourseCell_p1 != null && currentRoomCell_p1 != null) { // to fix the null pointer exception
                    if (currentCourseCell_p1.getStringCellValue().isEmpty()  ) { // these are the empty rooms
                            // IF NOT NULL CHECK, IF EMPTY
                        try {
                            if(Character.isDigit(currentRoomCell_p1.getStringCellValue().charAt(0))){
                                System.out.println(currentRoomCell_p1.getStringCellValue()); // print the element of current row
                                emptyRooms.add(currentRoomCell_p1.getStringCellValue());
                            }

                        } catch (StringIndexOutOfBoundsException e){
                            System.err.println("INDEX OUT OF BOUND");
                        }
                        /* Character.isDigit(currentCourseCell.getStringCellValue().charAt(0)))
                    is a double checking, we are being sure as the room number starts with a digit
                     */

                    }
                }

                // +> PERIOD 2

                if (currentCourseCell_p2 != null && currentRoomCell_p2 != null) { // to fix the null pointer exception
                    if (currentCourseCell_p2.getStringCellValue().isEmpty()  ) { // these are the empty rooms
                        // IF NOT NULL CHECK, IF EMPTY
                        try {
                            if(Character.isDigit(currentRoomCell_p2.getStringCellValue().charAt(0))){
                                System.out.println(currentRoomCell_p2.getStringCellValue()); // print the element of current row
                                emptyRooms.add(currentRoomCell_p2.getStringCellValue());
                            }

                        } catch (StringIndexOutOfBoundsException e){
                            System.err.println("INDEX OUT OF BOUND");
                        }
                        /* Character.isDigit(currentCourseCell.getStringCellValue().charAt(0)))
                    is a double checking, we are being sure as the room number starts with a digit
                     */

                    }
                }


            }
            EmptyRoom period_1 = new EmptyRoom(dayOfWeek,"1", emptyRooms);

        return emptyRooms;

    }
}
