package com.salahatwa.filesBean;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVBean implements FileUtils{
	
	private static Logger LOGGER=LoggerFactory.getLogger(CSVBean.class);
	

	public <T extends Object> List<Object> readFile(String filePath,Class<T> clazz,boolean notDuplicateList) throws Exception{
		
//		throw new Exception("Generic Error");
		return null;
	}



	@Override
	public <T> void writeFile(String filePath,List list, boolean notDuplicateList) {
		
	}

	
	

}
