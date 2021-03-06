package com.tags.jsf.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="ulLink", value="ulLink")
public class UlLink extends UIComponentBase{
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
    	valores.put("config.type", "lista_a");
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("ul", valores));
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");
		valores.put("config.type", "lista_a");
    	
    	ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("ul", valores));
    }
}
