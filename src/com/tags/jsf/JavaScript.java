package com.tags.jsf;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="javaScript", value="javaScript")
public class JavaScript extends UIComponentBase{
	private String name= "base";

	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.javaScript(this.getName()));
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
