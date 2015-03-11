package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="mediaObject", value="mediaObject")
public class MediaObject extends UIComponentBase{
	private String href;
	private String alt;
	private String src;
	private String title;
	private String content;
	
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
		valores.put("config.alt", this.getAlt());
		valores.put("config.titulo", this.getTitle());
		valores.put("config.contenido", this.getContent());
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("media_object", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");	
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("media_object", valores));
    }

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
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
}
