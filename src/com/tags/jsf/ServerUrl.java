package com.tags.jsf;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="setServerUrl", value="setServerUrl")
public class ServerUrl extends UIComponentBase{
	private String url= "";

	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi.setServerUrl(this.getUrl());
    }

    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}