package com.classes;

import java.lang.reflect.Method;

public class BeanImplementation {

	public static Object executeMethodGet(Object objeto, String attr){
		try{
			attr= "get" + Character.toUpperCase(attr.charAt(0)) + attr.substring(1);
			Method get = objeto.getClass().getMethod(attr, null);
			Object rta= get.invoke(objeto, null);
			return rta;
		}catch(Exception e){
			e.printStackTrace();
			return null;			
		}
	}
	
	public static Object executeMethodSet(Object objeto, String attr, Class[] typeParams, Object[] values){
		try{
			attr= "set" + Character.toUpperCase(attr.charAt(0)) + attr.substring(1);
			Method set = objeto.getClass().getMethod(attr, typeParams);
			Object rta= set.invoke(objeto, values);
			return rta;
		}catch(Exception e){
			e.printStackTrace();
			return null;			
		}
	}
}
