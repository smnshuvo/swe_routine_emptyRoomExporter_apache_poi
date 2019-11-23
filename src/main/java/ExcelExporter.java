import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelExporter {
    public static final String ROUTINE_XL = "G://xl.project/src/main/files/routine.xlsx";
    private static int startingCell, sundayStartRow,
                                mondayStartRow , tuesdayStartRow,
                                    wednesdayStartRow, thursdayStartRow;


    public static void main(String[] args) {
        try{
            FileInputStream routine_excel = new FileInputStream(new File(ROUTINE_XL));
            Workbook workbook = new XSSFWorkbook(routine_excel); // Workbook is excel sheet holder
            Sheet routine_sheet = workbook.getSheetAt(0); // get the first sheet
            Iterator<Row> cellIterator = routine_sheet.iterator();

            while (cellIterator.hasNext()){
                Row currentRow = cellIterator.next();
                Iterator <Cell> iterator = currentRow.iterator();
                    while (iterator.hasNext()){
                        Cell currentCell = iterator.next();
                        if ( currentCell.getStringCellValue().contains("SATURDAY")) { // if that cell has the value Saturday
                            // If you get saturday you must find sunday to know your limit
                            final int startingCell = currentCell.getRowIndex();
                            System.out.println(startingCell);
                            // everything above sunday is your limit
                        }

                        if (currentCell.getStringCellValue().toUpperCase().contains("SUNDAY")){
                            final int sundayStartRow = currentCell.getRowIndex();
                            System.out.println(sundayStartRow);
                        }

                        if (currentCell.getStringCellValue().toUpperCase().contains("MONDAY")){
                            final int mondayStartRow = currentCell.getRowIndex();
                            System.out.println(mondayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("TUESDAY")){
                            final int tuesdayStartRow = currentCell.getRowIndex();
                            System.out.println(tuesdayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("WEDNESDAY")){
                            final int wednesdayStartRow = currentCell.getRowIndex();
                            System.out.println(wednesdayStartRow);
                        }
                        if (currentCell.getStringCellValue().toUpperCase().contains("THURSDAY")){
                            final int thursdayStartRow = currentCell.getRowIndex();
                            System.out.println(thursdayStartRow);
                        }


                    }
                System.out.println("");

            }
        } catch (Exception e){
            System.err.print("FILE NOT FOUND");
        }
    }

    // TO DO: NEED A FUNCTION TO GET THE STARTING AND ENDING POINT

    public ArrayList<String> getEmptyRooms(){
        ArrayList<String> emptyRooms = new ArrayList<String>();

        return emptyRooms;

    }
}
