package com.tags.jsf;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="setProyecto", value="setProyecto")
public class Proyecto extends UIComponentBase{
	private String nombre= "bootstrap3";

	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi.setProyecto(this.getNombre());
    }

    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
