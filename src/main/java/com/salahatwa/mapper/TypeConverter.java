package com.salahatwa.mapper;

import java.lang.reflect.Field;

public class TypeConverter {
	

	/**
	 * Convert Data Type
	 * @param target
	 * @param s
	 * @return
	 */
	public static Object convert(Field declaredField, Object objectValue) {
//		System.out.println(declaredField.getType().getName());
		if (declaredField.getType() == String.class ) {
//			System.out.println("##1"+declaredField.getType());
			return objectValue;
		}
		if (declaredField.getType() == Character.class || declaredField.getType() == char.class) {
//			System.out.println("##2"+declaredField.getType());
			return (Character) objectValue;
		}
		if (declaredField.getType() == Byte.class || declaredField.getType() == byte.class) {
//			System.out.println("##3"+declaredField.getType());
			return (Byte) objectValue;
		}
		if (declaredField.getType() == Short.class || declaredField.getType() == short.class) {
//			System.out.println("##4"+declaredField.getType());
			return (Short) objectValue;
		}
		if (declaredField.getType() == Integer.class || declaredField.getType() == int.class) {
//			System.out.println("##5"+declaredField.getType());
			Double num=Double.parseDouble(objectValue+"");
			
			return num.intValue();
		}
		if (declaredField.getType() == Long.class || declaredField.getType() == long.class) {
//			System.out.println("##6"+declaredField.getType());
			return (Long) objectValue;
		}
		if (declaredField.getType() == Float.class || declaredField.getType() == float.class) {
//			System.out.println("##7"+declaredField.getType());
			return (Float) objectValue;
		}
		if (declaredField.getType() == Double.class || declaredField.getType() == double.class) {
//			System.out.println("##8"+declaredField.getType());
			return (Double) objectValue;
		}
		if (declaredField.getType() == Boolean.class || declaredField.getType() == boolean.class) {
//			System.out.println("##9"+declaredField.getType());
			return (Boolean) objectValue;
		}
		throw new IllegalArgumentException("Don't know how to convert to " + declaredField.getType());
	}

}
