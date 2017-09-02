package com.mamportal.seleium;

import java.io.FileInputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {


	//ArrayList<String> readExcelHelp() throws Exception {


//public static void main (String args[]) throws BiffException, IOException{
ArrayList<String> readExcelHelp() throws Exception {

	String excelFilePath = "C:/8_Selenium/Excel data/credentials.xls";
	String workSheetName = "Registration";


			ArrayList<String> dataList = new ArrayList<String>();


			//read excel file creating an input stream, workbook and sheet name
			FileInputStream fs = new FileInputStream(excelFilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(workSheetName);


			// get the rows and columns in the worksheet
			int totalNoRows = sh.getRows();

			int totalNoCols = sh.getColumns();


			//read the rows and columns into an array of array list
			for (int row = 1; row < totalNoRows; row++) {

				// read the first row into an array
				ArrayList<String> tmpData = new ArrayList<String>();

				// read the columns in the first row
				for (int col = 0; col < totalNoCols; col++) {


					if(sh.getCell(col, row).getContents()!=""){
					// add the columns thus read into the array created for the row above.
					tmpData.add(sh.getCell(col, row).getContents());
					System.out.println(sh.getCell(col, row).getContents());
					}

				}

					dataList.addAll(tmpData);


			}
			// System.out.println("dataList "+dataList);

			// close the workbook and input stream
			wb.close();
			fs.close();


			// return the collection which has the info from excel reg the users
			return dataList;

		}
} 