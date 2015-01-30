package com.tags.form;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.classes.BeanImplementation;
import com.ui.ApiUi;

@SuppressWarnings("serial")
public class SelectFull extends TagSupport{
	private Boolean simple= false;
	private String label;
	private String id= "";
	private String name;
	private Object value;
	private String message;
	private String typeError;
	private String size = "md";
	private String onChange= "";
	private Object options;
	private String methodValue;
	private String methodLabel;
	private String defaultValue= "0";
	private String defaultLabel;
	
	@SuppressWarnings({"unchecked" })
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "cabecera");
		valores.put("config.label", this.getLabel());
		valores.put("config.id", this.getId());
		valores.put("config.name", this.getName());
		valores.put("config.multiple", "no");
		if(this.getMessage() != null){valores.put("config.message", this.getMessage());}
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
		valores.put("config.onchange", this.getOnChange());
		
		//Opciones del Select
		String componentes="";
		
		if(this.getDefaultLabel() != null){
			Map<String, Object> valoresOpt= new HashMap<String, Object>();
			valoresOpt.put("config.label", this.getDefaultLabel());
			valoresOpt.put("datos.value", this.getDefaultValue());
			valoresOpt.put("config.checked", "no");
			componentes += api.imprimirComponente("select_option", valoresOpt);
		}
		
		Collection<Object> opciones= (Collection<Object>) this.getOptions();
		for(Object opcion: opciones){
			Object optLabel= BeanImplementation.executeMethodGet(opcion, this.getMethodLabel());
			Object optValue= BeanImplementation.executeMethodGet(opcion, this.getMethodValue());
				
			Map<String, Object> valoresOpt= new HashMap<String, Object>();
			valoresOpt.put("config.label", optLabel);
			valoresOpt.put("datos.value", optValue);				
			if(this.getValue().equals(optValue)){
				valoresOpt.put("config.checked", "si");
			}
			else{
				valoresOpt.put("config.checked", "no");
			}
			componentes += api.imprimirComponente("select_option", valoresOpt);
		}
		valores.put("components", componentes);
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			if(this.getSimple()){
				out.println(api.imprimirComponente("select_simple", valores));
			} else{
				out.println(api.imprimirComponente("select", valores));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return EVAL_BODY_INCLUDE;
	}
	
	@SuppressWarnings({ })
	@Override
	public int doEndTag(){
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");
		if(this.getMessage() != null){valores.put("config.message", this.getMessage());}
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			if(this.getSimple()){
				out.println(api.imprimirComponente("select_simple", valores));
			} else{
				out.println(api.imprimirComponente("select", valores));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
		
	
	public Boolean getSimple() {
		return simple;
	}

	public void setSimple(Boolean simple) {
		this.simple = simple;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDefaultLabel() {
		return defaultLabel;
	}

	public void setDefaultLabel(String defaultLabel) {
		this.defaultLabel = defaultLabel;
	}
}
