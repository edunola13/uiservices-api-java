package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="liLink", value="liLink")
public class LiLink extends UIComponentBase{
	private String label;
	private String href;
	private String badge;
	private Boolean active;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.type", "lista_a");
		valores.put("config.label", this.getLabel());
		valores.put("config.href", this.getHref());
		if(this.getBadge() != null){
			valores.put("config.badge", this.getBadge());
		}
		if(this.getActive() != null){
			if(this.getActive()){
				valores.put("config.active", "active");
			}
		}
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("li", valores));
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
