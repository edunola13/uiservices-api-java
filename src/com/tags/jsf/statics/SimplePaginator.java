package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="simplePaginator", value="simplePaginator")
public class SimplePaginator extends UIComponentBase{
	private Boolean previous_disabled;
	private String previous_url;
	private String previous_label;
	private Boolean next_disabled;
	private String next_url;
	private String next_label;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		//Para el boton Previous
		if(this.getPrevious_disabled() != null){
			if(this.getPrevious_disabled()){
				valores.put("config.previous.state", "disabled");
			}
		}
		valores.put("config.previous.href", this.getPrevious_url());
		valores.put("config.previous.label", this.getPrevious_label());
		
		//Para el boton next
		if(this.getNext_disabled() != null){
			if(this.getNext_disabled()){
				valores.put("config.next.state", "disabled");
			}
		}
		valores.put("config.next.href", this.getNext_url());
		valores.put("config.next.label", this.getNext_label());
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("paginador_simple", valores));
    }

	public Boolean getPrevious_disabled() {
		return previous_disabled;
	}

	public void setPrevious_disabled(Boolean previous_disabled) {
		this.previous_disabled = previous_disabled;
	}

	public String getPrevious_url() {
		return previous_url;
	}

	public void setPrevious_url(String previous_url) {
		this.previous_url = previous_url;
	}

	public String getPrevious_label() {
		return previous_label;
	}

	public void setPrevious_label(String previous_label) {
		this.previous_label = previous_label;
	}

	public Boolean getNext_disabled() {
		return next_disabled;
	}

	public void setNext_disabled(Boolean next_disabled) {
		this.next_disabled = next_disabled;
	}

	public String getNext_url() {
		return next_url;
	}

	public void setNext_url(String next_url) {
		this.next_url = next_url;
	}

	public String getNext_label() {
		return next_label;
	}

	public void setNext_label(String next_label) {
		this.next_label = next_label;
	}
}
