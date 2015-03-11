package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="simpleHeader", value="simpleHeader")
public class SimpleHeader extends UIComponentBase{
	private String primario;
	private String secundario;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.primario", this.getPrimario());
		if(this.getSecundario() != null){
			valores.put("config.secundario", this.getSecundario());
		}
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("simple_header", valores));
    }

	public String getPrimario() {
		return primario;
	}

	public void setPrimario(String primario) {
		this.primario = primario;
	}

	public String getSecundario() {
		return secundario;
	}

	public void setSecundario(String secundario) {
		this.secundario = secundario;
	}
}
