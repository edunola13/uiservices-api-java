package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="link", value="link")
public class Link extends UIComponentBase{
	private String id;
	private String href;
	private String label;
	private Boolean button= false;
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
		valores.put("config.id", this.getId());
		valores.put("config.href", this.getHref());
		valores.put("config.label", this.getLabel());
		valores.put("config.style", this.getStyle());
		valores.put("config.size", this.getSize());
		if(this.getButton()){
			valores.put("config.button", "si");
		}else{
			valores.put("config.button", "no");
		}
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("link", valores));
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getButton() {
		return button;
	}

	public void setButton(Boolean button) {
		this.button = button;
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
