package com.salahatwa.filesBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.salahatwa.mapper.Mapper;
import com.salahatwa.mapper.TypeMapper;

public class XLSBean implements FileUtils {

	private static Logger LOGGER = LoggerFactory.getLogger(XLSBean.class);
	
	private FileSourceTemplate fileSourceTemplate=FileSourceTemplate.getInstance();


	/**
	 * read xlsx file in any bean defined by user
	 */
	public <T extends Object> List readFile(String filePath, Class<T> clazz, boolean notDuplicateList)
			throws Exception {

		LOGGER.info("Read XLS File in bean:" + clazz.getName());

		List<Object> inputArguments = new ArrayList<>();

		List<Object> resultObjects = new ArrayList<>();

		try {
		
			Iterator<Row> rowIterator = fileSourceTemplate.initReadXLSX(filePath);
			// Traversing over each row of XLSX file
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						inputArguments.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						inputArguments.add(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						inputArguments.add(cell.getBooleanCellValue());
						break;
					default:
					}
				}

				Mapper mapper = new TypeMapper(clazz);
				Object convertedObject = mapper.mapToObject(inputArguments);
				resultObjects.add(convertedObject);

				inputArguments.clear();
			}

		} catch (Exception ex) {
			LOGGER.error("", ex);
		} finally {
			FileSourceTemplate.closeInputStream();
		}
		return resultObjects;
	}

	/**
	 * Write XLSX File
	 */
	public <T> void writeFile(String filePath, List list, boolean notDuplicateList) {

	    Sheet sheet=fileSourceTemplate.initWriteXLS(filePath);

		int rownum = sheet.getLastRowNum();

		Mapper mapper = new TypeMapper();

		try {
			list = mapper.mapToObjectArray(list);

			for (Object key : list) {

				Object[] objArr = (Object[]) key;

				// Creating a new Row in existing XLSX sheet
				Row row = sheet.createRow(rownum++);

				int cellnum = 0;
				for (Object obj : objArr) {
					Cell cell = row.createCell(cellnum++);
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					} else if (obj instanceof Boolean) {
						cell.setCellValue((Boolean) obj);
					} else if (obj instanceof Date) {
						cell.setCellValue((Date) obj);
					} else if (obj instanceof Double) {
						cell.setCellValue((Double) obj);
					} else if (obj instanceof Integer) {
						cell.setCellValue((Integer) obj);
					}
				}

			}

			fileSourceTemplate.getWorkBook().write(FileSourceTemplate.writeFileOutPutStream());
			LOGGER.info("Writing XLSX File Success");

		} catch (Exception e) {
			LOGGER.info("", e);
		} finally {
			FileSourceTemplate.closeOutputStream();
		}

	}

	
	
}
