package com.tags.jsf.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="selectMultiple", value="selectMultiple")
public class SelectMultiple extends UIComponentBase{
	private Boolean simple= false;
	private String label;
	private String id= "";
	private String name;
	private Object value;
	private String message;
	private String typeError;
	private String size = "md";
	private String onChange= "";
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
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
		
		this.getAttributes().put("typeSelect", "multiple");
		
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
}
