package com.tags.jsf;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="setProject", value="setProject")
public class Project extends UIComponentBase{
	private String name= "bootstrap3";

	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi.setProject(this.getName());
    }

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
