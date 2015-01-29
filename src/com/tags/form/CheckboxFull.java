package com.tags.form;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

public class CheckboxFull extends TagSupport{
	private String label;
	private String id= "";
	private String name;
	private Object value;
	private boolean inline= false;
	private String typeError;
	private String size = "md";
	private Object options;
	private String methodValue;
	private String methodLabel;
	
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "cabecera");
		valores.put("config.label", this.getLabel());
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
				
		//Opciones del Checkbox
		String componentes= "";
		int numero= 0;
		Collection<Object> opciones= (Collection<Object>) this.getOptions();
		for(Object opcion: opciones){
			try{
				Method mLabel = opcion.getClass().getMethod(this.getMethodLabel(), null);
				Method mValue = opcion.getClass().getMethod(this.getMethodValue(), null);				
				Object optLabel= mLabel.invoke(opcion, null);
				Object optValue= mValue.invoke(opcion, null);
				
				Map<String, Object> valoresOpt= new HashMap<String, Object>();
				valoresOpt.put("config.label", optLabel);
				valoresOpt.put("config.name", name);
				valoresOpt.put("datos.value", optValue);
				if(this.isInline()){
					valoresOpt.put("config.inline", "si");
				}else{
					valoresOpt.put("config.inline", "no");
				}
				valoresOpt.put("config.id", this.getId() + Integer.toString(numero));
				numero++;

				//Consigo dato del select ui
				Collection<Object> values= (Collection<Object>) this.getValue();
				for(Object valueA: values){
					if(valueA.equals(optValue)){
						valoresOpt.put("config.checked", "si");
						break;
					}
					else{
						valoresOpt.put("config.checked", "no");
					}
				}
				
				componentes += api.imprimirComponente("checkbox_option", valoresOpt);				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		valores.put("components", componentes);
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("checkbox", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag(){
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("checkbox", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
		
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isInline() {
		return inline;
	}

	public void setInline(boolean inline) {
		this.inline = inline;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Object getOptions() {
		return options;
	}

	public void setOptions(Object options) {
		this.options = options;
	}

	public String getMethodValue() {
		return methodValue;
	}

	public void setMethodValue(String methodValue) {
		this.methodValue = methodValue;
	}

	public String getMethodLabel() {
		return methodLabel;
	}

	public void setMethodLabel(String methodLabel) {
		this.methodLabel = methodLabel;
	}
}
