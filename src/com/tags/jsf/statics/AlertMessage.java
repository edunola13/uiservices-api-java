package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="alertMessage", value="alertMessage")
public class AlertMessage extends UIComponentBase{
	private String type;
	private String strong="";
	private String message;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.type", this.getType());
		valores.put("config.strong", this.getStrong());
		valores.put("config.message", this.getMessage());
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("alert_message", valores));
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStrong() {
		return strong;
	}

	public void setStrong(String strong) {
		this.strong = strong;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
