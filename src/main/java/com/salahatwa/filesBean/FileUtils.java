package com.salahatwa.filesBean;

import java.util.List;

public interface FileUtils {
	
	/**
	 * write File
	 * @return list of objects with duplicate rows
	 */
	public <T extends Object> List<?> readFile(String filePath,Class<T> clazz);
	
	
	/**
	 * write File
	 * @param filePath
	 * @param notDuplicateList
	 * @return list of object without duplicate rows
	 */
	public <T extends Object> List<?> readFile(String filePath,Class<T> clazz,boolean notDuplicateList);
	
	/**
	 * write File
	 * @return list of objects with duplicate rows
	 */
	public <T extends Object> List<?> writeFile(String filePath,Class<T> clazz);
	
	
	/**
	 * write File
	 * @param filePath
	 * @param notDuplicateList
	 * @return list of object without duplicate rows
	 */
	public <T extends Object> List<?> writeFile(String filePath,Class<T> clazz,boolean notDuplicateList);
	
	
	

}
