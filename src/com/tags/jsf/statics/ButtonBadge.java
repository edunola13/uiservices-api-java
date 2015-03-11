package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="buttonBadge", value="buttonBadge")
public class ButtonBadge extends UIComponentBase{
	private String label;
	private String badge;
	private String id;
	private String onClick;
	private String type= "button";	
	private String style= "default";
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
		valores.put("config.label", this.getLabel());	
		valores.put("config.badge", this.getBadge());	
		if(this.getId() != null){
			valores.put("config.id", this.getId());
		}
		if(this.getOnClick() != null){
			valores.put("config.onclick", this.getOnClick());
		}
		valores.put("config.type", this.getType());
		valores.put("config.style", this.getStyle());
		valores.put("config.size", this.getSize());
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("button_badge", valores));
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
