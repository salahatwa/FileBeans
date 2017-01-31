package com.salahatwa.filesBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.salahatwa.mapper.InsializeUnknownObject;

import com.salahatwa.beans.Person;

public class XLSBean implements FileUtils {

	private static Logger LOGGER = LoggerFactory.getLogger(XLSBean.class);

	private List<String> constructorArguments;

	private Class clazz;


	public <T> List<?> readFile(String filePath, Class<T> clazz) {
		List resultObjects = null;
		try {

			resultObjects = new ArrayList();

			File myFile = new File(filePath);
			FileInputStream fis = new FileInputStream(myFile);
			// Finds the workbook instance for XLSX file
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			// Return first sheet from the XLSX workbook
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = mySheet.iterator();
			// Traversing over each row of XLSX file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						constructorArguments.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						constructorArguments.add(String.valueOf(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						constructorArguments.add(String.valueOf(cell.getBooleanCellValue()));
						break;
					default:
					}
				}
				
				resultObjects.add(instantiate(constructorArguments));
				constructorArguments.clear();
			}

		} catch (Exception ex) {
			LOGGER.error("", ex);
		}
		return null;
	}




	public <T> List<?> readFile(String filePath, Class<T> clazz, boolean notDuplicateList) {
		// TODO Auto-generated method stub
		return null;
	}




	public <T> List<?> writeFile(String filePath, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}




	public <T> List<?> writeFile(String filePath, Class<T> clazz, boolean notDuplicateList) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
