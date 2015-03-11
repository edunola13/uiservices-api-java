package com.tags.jsf.nav_menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="navItem", value="navItem")
public class NavItem extends UIComponentBase{
	private String state;
	private String href;
	private String label;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();

		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		if(this.getState() != null){
			valores.put("config.state", this.getState());
		}
		if(this.getHref() != null){
			valores.put("config.href", this.getHref());
		}
		valores.put("config.label", this.getLabel());
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("nav_item", valores));
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
