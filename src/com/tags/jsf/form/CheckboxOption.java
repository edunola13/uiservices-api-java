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

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="checkboxOption", value="checkboxOption")
public class CheckboxOption extends UIComponentBase{
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
		
		//Name Checkbox
		String name= (String) this.getParent().getAttributes().get("name");		
		valores.put("config.name", name);
		
		//Inline Checkbox
		boolean inline= (boolean) this.getParent().getAttributes().get("inline");
		if(inline){
			valores.put("config.inline", "si");
		}
		else{
			valores.put("config.inline", "no");
		}
		
		//Id Checkbox
		int numero= 0;
		if(this.getParent().getAttributes().containsKey("num")){
			numero= (int) this.getParent().getAttributes().get("num");
		}
		//Aumento en uno el numero
		this.getParent().getAttributes().put("num", numero + 1);
		String id= (String) this.getParent().getAttributes().get("id");
		valores.put("config.id", id + Integer.toString(numero));		
		
		//Consigo dato del select ui
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
			
		if(this.getValue() != null){
			valores.put("datos.value", this.getValue());
		}
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("checkbox_option", valores));
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
