package com.tags.jsf.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="checkbox", value="checkbox")
public class Checkbox extends UIComponentBase{
	private String label;
	private String id= "";
	private String name;
	private Object value;
	private boolean inline= false;
	private String typeError;
	private String size = "md";
	
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
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
		
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
}
