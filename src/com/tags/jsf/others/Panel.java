package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="panel", value="panel")
public class Panel extends UIComponentBase{
	private String title;
	private String foot;
	
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
		if(this.getTitle() != null){
			valores.put("config.titulo", this.getTitle());
		}		
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("carousel_item", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
		if(this.getFoot() != null){
			valores.put("config.pie", this.getFoot());
		}	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("carousel_item", valores));
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}
}
