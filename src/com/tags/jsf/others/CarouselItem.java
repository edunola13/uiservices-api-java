package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="carouselItem", value="carouselItem")
public class CarouselItem extends UIComponentBase{
	private String src;
	private String alt;
	private String state="";
	
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
    	valores.put("config.src", this.getSrc());
    	valores.put("config.alt", this.getAlt());
    	valores.put("config.state", this.getState());
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("carousel_item", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("carousel_item", valores));
    }

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
