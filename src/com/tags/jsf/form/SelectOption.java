package com.tags.jsf.form;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="selectOption", value="selectOption")
public class SelectOption extends UIComponentBase{
	private Object value;
	private String label;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		
		/**
		 * Segun el tipo de select se compara de diferentes maneras
		 */
		String tipo= (String) this.getParent().getAttributes().get("typeSelect");	
		
		if(tipo == "simple"){
			//Consigo dato del select ui
			Object actual= this.getParent().getAttributes().get("value");
			
			if(actual.equals(this.getValue())){
				valores.put("config.checked", "si");
			}
			else{
				valores.put("config.checked", "no");
			}
		}
		else{
			Collection<Object> actuales= (Collection<Object>) this.getParent().getAttributes().get("value");
			for(Object actual: actuales){
				if(actual.equals(this.getValue())){
					valores.put("config.checked", "si");
					break;
				}
				else{
					valores.put("config.checked", "no");
				}
			}
		}		

		valores.put("config.value", this.getValue());
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("select_option", valores));
    }

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
