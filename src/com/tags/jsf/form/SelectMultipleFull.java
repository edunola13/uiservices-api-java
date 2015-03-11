package com.tags.jsf.form;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.classes.BeanImplementation;
import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="selectMultipleFull", value="selectMultipleFull")
public class SelectMultipleFull extends UIComponentBase{
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
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "cabecera");
		valores.put("config.label", this.getLabel());
		valores.put("config.id", this.getId());
		valores.put("config.name", this.getName());
		valores.put("config.multiple", "si");
		if(this.getMessage() != null){valores.put("config.message", this.getMessage());}
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
		valores.put("config.onchange", this.getOnChange());
		
		//Opciones del Select
		String componentes="";	
		
		Collection<Object> opciones= (Collection<Object>) this.getOptions();
		for(Object opcion: opciones){
			Object optLabel= BeanImplementation.executeMethodGet(opcion, this.getMethodLabel());
			Object optValue= BeanImplementation.executeMethodGet(opcion, this.getMethodValue());
				
			Map<String, Object> valoresOpt= new HashMap<String, Object>();
			valoresOpt.put("config.label", optLabel);
			valoresOpt.put("datos.value", optValue);	
				
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
			componentes += api.imprimirComponente("select_option", valoresOpt);
		}
		valores.put("components", componentes);
		
        ResponseWriter writer = context.getResponseWriter();
        if(this.getSimple()){
        	writer.write(api.imprimirComponente("select_simple", valores));
		} else{
			writer.write(api.imprimirComponente("select", valores));
		}  
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");
		if(this.getMessage() != null){valores.put("config.message", this.getMessage());}
    	
    	ResponseWriter writer = context.getResponseWriter();
    	if(this.getSimple()){
        	writer.write(api.imprimirComponente("select_simple", valores));
		} else{
			writer.write(api.imprimirComponente("select", valores));
		}  
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
}
