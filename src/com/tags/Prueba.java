package com.tags;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="prueba", value="prueba")
public class Prueba extends UIComponentBase {

    protected String value= "prueba";
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
 
        if (value != null) {        
            ResponseWriter writer = context.getResponseWriter();
            writer.write(this.getValue().toUpperCase());
        }
    }

    
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

    
}
