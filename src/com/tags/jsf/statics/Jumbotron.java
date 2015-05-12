package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="jumbotron", value="jumbotron")
public class Jumbotron extends UIComponentBase{
	private String title;
	private String content;
	private String href;
	private String label;
	private String buttonStyle= "default";
	private String buttonSize= "md";
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.titulo", this.getTitle());
		valores.put("config.contenido", this.getContent());
		valores.put("config.href", this.getHref());
		valores.put("config.label", this.getLabel());
		valores.put("config.buttonStyle", this.getButtonStyle());
		valores.put("config.buttonSize", this.getButtonSize());
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("jumbotron", valores));
    }

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}

	public String getButtonSize() {
		return buttonSize;
	}

	public void setButtonSize(String buttonSize) {
		this.buttonSize = buttonSize;
	}
}
