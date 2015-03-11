package com.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.classes.Prueba;

@ManagedBean(name= "prueba")
@RequestScoped
public class HelloBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String name= "as";
	private List<String> values= new ArrayList<String>();
	private List<Integer> valuesInt= new ArrayList<Integer>();
	private List<Prueba> pruebas= new ArrayList<Prueba>();
 
	public HelloBean(){
		values.add("1");
		values.add("3");
		valuesInt.add(4);
		valuesInt.add(2);
		valuesInt.add(3);
		Prueba prueba1= new Prueba();
		prueba1.setChau("1");prueba1.setHola("El 1");
		pruebas.add(prueba1);
		Prueba prueba2= new Prueba();
		prueba2.setChau("3");prueba2.setHola("El 3");
		pruebas.add(prueba2);
		Prueba prueba3= new Prueba();
		prueba3.setChau("2");prueba3.setHola("El 2");
		pruebas.add(prueba3);
	}
	
	public String getName() {
		name= "asdadad";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getValues() {
		values.add("1");
		values.add("3");
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public List<Integer> getValuesInt() {
		valuesInt.add(4);
		valuesInt.add(2);
		valuesInt.add(3);
		return valuesInt;
	}
	public void setValuesInt(List<Integer> valuesInt) {
		this.valuesInt = valuesInt;
	}
	public List<Prueba> getPruebas() {
		Prueba prueba1= new Prueba();
		prueba1.setChau("1");prueba1.setHola("El 1");
		pruebas.add(prueba1);
		Prueba prueba2= new Prueba();
		prueba2.setChau("3");prueba2.setHola("El 3");
		pruebas.add(prueba2);
		Prueba prueba3= new Prueba();
		prueba3.setChau("2");prueba3.setHola("El 2");
		pruebas.add(prueba3);
		return pruebas;
	}
	public void setPruebas(List<Prueba> pruebas) {
		this.pruebas = pruebas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
