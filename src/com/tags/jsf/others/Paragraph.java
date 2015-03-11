package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="paragraph", value="paragraph")
public class Paragraph extends UIComponentBase{
	private String lead;
	private String align;
	
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
		if(this.getLead() != null){
			valores.put("config.lead", this.getLead());
		}
		if(this.getAlign() != null){
			valores.put("config.align", this.getAlign());
		}
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("parrafo", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("parrafo", valores));
    }

	public String getLead() {
		return lead;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}
}
