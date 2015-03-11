package com.tags.jsf.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="booleanCheckbox", value="booleanCheckbox")
public class BooleanCheckbox extends UIComponentBase{
	private String label;
	private String id= "";
	private String name;
	private Boolean value;
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
		valores.put("config.label", this.getLabel());
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
		
		Map<String, Object> valoresOpcion= new HashMap<String, Object>();

		valoresOpcion.put("config.name", this.getName());
		valoresOpcion.put("config.inline", "si");
		valoresOpcion.put("config.id", this.getId());
		valoresOpcion.put("datos.value", 1);
		
		if(this.getValue()){
			valoresOpcion.put("config.checked", "si");
		}
		else{
			valoresOpcion.put("config.checked", "no");
		}
		
		valores.put("components", api.imprimirComponente("checkbox_option", valoresOpcion));
		
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

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
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
