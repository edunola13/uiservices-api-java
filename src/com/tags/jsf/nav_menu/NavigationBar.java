package com.tags.jsf.nav_menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="navigationBar", value="navigationBar")
public class NavigationBar extends UIComponentBase{
	private String href;
	private String logo;
	private Boolean containerFluid;
	private String position;
	private Boolean inverse= false;
	
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
		valores.put("config.href", this.getHref());
		valores.put("config.logo", this.getLogo());
		if(this.getContainerFluid()){
			valores.put("config.containerFluid", "si");
		}else{
			valores.put("config.containerFluid", "no");
		}
		valores.put("config.position", this.getPosition());
		if(this.getInverse()){
			valores.put("config.inverse", "navbar-inverse");
		}else{
			valores.put("config.inverse", "");
		}
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("navigation_bar", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("navigation_bar", valores));
    }

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Boolean getContainerFluid() {
		return containerFluid;
	}

	public void setContainerFluid(Boolean containerFluid) {
		this.containerFluid = containerFluid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getInverse() {
		return inverse;
	}

	public void setInverse(Boolean inverse) {
		this.inverse = inverse;
	}
}
