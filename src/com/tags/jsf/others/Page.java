package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="page", value="page")
public class Page extends UIComponentBase{
	private String label;
	private String url;
	private String state;
	private Boolean first;
	private Boolean last;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		
		if(this.getLabel() != null){
			valores.put("config.label", this.getLabel());
		}
		valores.put("config.href", this.getUrl());
		if(this.getState() != null){
			valores.put("config.state", this.getState());
		}
		if(this.getFirst() != null){
			if(this.getFirst()){
				valores.put("config.first", "si");
			}
		}
		if(this.getLast() != null){
			if(this.getLast()){
				valores.put("config.last", "si");
			}
		}		
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("pagina", valores));
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getFirst() {
		return first;
	}

	public void setFirst(Boolean first) {
		this.first = first;
	}

	public Boolean getLast() {
		return last;
	}

	public void setLast(Boolean last) {
		this.last = last;
	}
}
