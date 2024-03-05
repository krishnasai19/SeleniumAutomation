package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public File file;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public Sheet sheet;
	
	public ExcelUtility(String filePath, int sheetIndex) throws Exception {
		file = new File(filePath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(sheetIndex);
	}
	
	public ExcelUtility(String filePath, String sheetName) throws Exception {
		file = new File(filePath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
	}
	
	public int getRowsCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColsCount(int rowNo) {
		return sheet.getRow(rowNo).getPhysicalNumberOfCells();
	}
	
	public String getCellValue(int rowNo, int colNo) {
		CellType cellType=sheet.getRow(rowNo).getCell(colNo).getCellType();
		  Cell cell= sheet.getRow(rowNo).getCell(colNo);
		String value=null;
		switch (cellType) {
		case NUMERIC:
			value = String.valueOf(cell.getNumericCellValue());
			break;
		case STRING:
			value = cell.getStringCellValue();
			break;
		case BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case ERROR:
			value = String.valueOf(cell.getErrorCellValue());
			break;
		
		}
			
		return value;
	}
	
	public List<HashMap<String, String>> readExcelSheetData(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
			
		for (int i = 1; i < getRowsCount(); i++) {
			
			HashMap<String, String> map = new HashMap<String, String>();
			for (int j = 0; j <getColsCount(0); j++) {
				map.put(getCellValue(0, j), getCellValue(i, j));
			}
			
			list.add(map);
		}
	return list;
			
		
	}
	
	public void quitExcel() throws Exception {
		wb.close();
		fis.close();
	}

}
