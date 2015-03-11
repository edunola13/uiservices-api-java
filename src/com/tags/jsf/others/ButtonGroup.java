package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="buttonGroup", value="buttonGroup")
public class ButtonGroup extends UIComponentBase{
	private String label;
	private Boolean vertical= false;
	private String size= "md";

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
		valores.put("config.size", this.getSize());
		if(this.getVertical()){
			valores.put("config.vertical", "si");
		}else{
			valores.put("config.vertical", "no");
		}
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("button_group", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("button_group", valores));
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getVertical() {
		return vertical;
	}

	public void setVertical(Boolean vertical) {
		this.vertical = vertical;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
