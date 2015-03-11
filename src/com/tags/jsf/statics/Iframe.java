package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="iframe", value="iframe")
public class Iframe extends UIComponentBase{
	private String ratio;
	private String src;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		if(this.getRatio().equals("small")){
			valores.put("config.ratio", "4:3");
		}
		else{
			//Ver si esta bien
			valores.put("config.ratio", "16:9");
		}
		valores.put("config.src", this.getSrc());	
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("iframe", valores));
    }

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}
