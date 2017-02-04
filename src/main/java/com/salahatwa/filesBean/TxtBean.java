package com.salahatwa.filesBean;

import java.util.List;

public class TxtBean implements FileUtils{

	@Override
	public <T> List<Object> readFile(String filePath,Class<T> clazz, boolean notDuplicateList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	

	@Override
	public <T> void writeFile(String filePath,List list, boolean notDuplicateList) {
		// TODO Auto-generated method stub
	
	}


	
}
