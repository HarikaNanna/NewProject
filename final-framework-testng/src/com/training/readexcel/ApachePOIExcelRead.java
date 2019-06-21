package com.training.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author naveen
 * @see this class will take the records from excel sheet, and return it as list
 *      of list of object, and can be generic, can given any records until it
 *      exists. Test it with main method provided, and the path is hard coded,
 *      participatns are asked to refractor this path in the property file and
 *      access.
 */
public class ApachePOIExcelRead {
	public static  List<List<Object>> getExcelContent(String fileName, String sheetName) {
		List<List<Object>> list = new ArrayList<List<Object>>();
		
		//int rowCount =0; 
		//String [][] list1 = null; 
		
		try {
			System.out.println("File Name Got " + fileName);
			FileInputStream file = new FileInputStream(new File(fileName));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int rowTotal = sheet.getLastRowNum();

			if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
			    rowTotal++;
			}
			
			
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			// list1 = new String[rowTotal][2];
			 
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				int cellCount = 0; 
				int noOfColumns = row.getLastCellNum(); 
				List<Object> tempList = new ArrayList<Object>();
				
				
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
						
						if(((Double) cell.getNumericCellValue()).toString()!=null){
							tempList.add(((Double) cell.getNumericCellValue()).toString()); 
						} 
						break;
					case Cell.CELL_TYPE_STRING:
						if(cell.getStringCellValue()!=null){
							tempList.add(cell.getStringCellValue());
						}
						break;
					}
					 
				}
				list.add(tempList);
				}
				file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		String fileName = "C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\project\\Testing.xlsx";
		String sheetName= "Sheet1";
		for(List<Object> temp : getExcelContent(fileName,sheetName)){
					System.out.println(temp.get(0)+", "+temp.get(1)+", "+temp.get(2));
			}
		}

	}
