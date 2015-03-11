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

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="checkboxFull", value="checkboxFull")
public class CheckboxFull extends UIComponentBase{
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
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
				
		//Opciones del Checkbox
		String componentes= "";
		int numero= 0;
		Collection<Object> opciones= (Collection<Object>) this.getOptions();
		for(Object opcion: opciones){
			Object optLabel= BeanImplementation.executeMethodGet(opcion, this.getMethodLabel());
			Object optValue= BeanImplementation.executeMethodGet(opcion, this.getMethodValue());
				
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
		}
		valores.put("components", componentes);
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("checkbox", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("checkbox", valores));
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
