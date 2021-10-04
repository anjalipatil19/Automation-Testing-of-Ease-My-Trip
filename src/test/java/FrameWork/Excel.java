package FrameWork;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class Excel {
	Workbook wb;
	public Excel(String pathWithFileName) throws Exception{
		try{
		if (pathWithFileName.endsWith(".xls")){
			wb = new HSSFWorkbook (new FileInputStream(pathWithFileName));
		}else if  (pathWithFileName.endsWith(".xlsx"))
		{	wb = new XSSFWorkbook (new FileInputStream(pathWithFileName));}

		}catch(Exception E){
		System.out.println("Error with File Connection with Message" + E.getMessage());
		}
	}
	public String getData(String sheetName, int row, int col){
		String data= wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	
	public long getNumericData(String sheetName, int row, int col){
		long data= (long)wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return data;
	}


	public int getRowNum(String sheetName){
		int row=wb.getSheet(sheetName).getLastRowNum()+1;
		return row;
	}
	public int getColNum(String sheetName){
		int row=wb.getSheet(sheetName).getRow(0).getLastCellNum();
		return row;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
