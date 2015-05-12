package com.tags.jsf.statics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="searchForm", value="searchForm")
public class SearchForm extends UIComponentBase{
	private String label;
	private String inputName;
	private String button_id;
	private String onClick;
	private String inputPlaceholder;
	private Object inputValue;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		valores.put("config.input.name", this.getInputName());
		if(this.getButton_id() != null){
			valores.put("config.id", this.getButton_id());
		}
		if(this.getOnClick() != null){
			valores.put("config.onclick", this.getOnClick());
		}
		if(this.getInputPlaceholder() != null){
			valores.put("config.input.placeholder", this.getInputPlaceholder());
		}
		valores.put("datos.value_input", this.getInputValue());
    	
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("form_search", valores));
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getButton_id() {
		return button_id;
	}

	public void setButton_id(String button_id) {
		this.button_id = button_id;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getInputPlaceholder() {
		return inputPlaceholder;
	}

	public void setInputPlaceholder(String inputPlaceholder) {
		this.inputPlaceholder = inputPlaceholder;
	}

	public Object getInputValue() {
		return inputValue;
	}

	public void setInputValue(Object inputValue) {
		this.inputValue = inputValue;
	}
}
