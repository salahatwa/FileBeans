package com.salahatwa.filesBean;

import java.util.List;

public interface FileUtils {
	
    public static final String XLS="xls";
	
	public static final String XLSX="xlsx";
	
	
	/**
	 * write File
	 * @return list of objects with duplicate rows
	 */
	public <T> List<Object> readFile(String filePath,Class<T> clazz, boolean notDuplicateList) throws Exception;
	
	
	/**
	 * write File
	 * @param filePath
	 * @param notDuplicateList
	 * @return list of object without duplicate rows
	 */
	public <T>  void writeFile(String filePath,List list,boolean notDuplicateList) throws Exception;
	
	
	

}
