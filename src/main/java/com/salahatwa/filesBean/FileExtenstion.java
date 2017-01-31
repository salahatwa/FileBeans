package com.salahatwa.filesBean;

public enum FileExtenstion {
	
	XLSX(0),XLS(1),TXT(2),CSV(3) ;
	
	private int typeNum;
	
	private FileExtenstion(int typeNum)
	{
	  this.typeNum=typeNum;
	}
	
	
}
