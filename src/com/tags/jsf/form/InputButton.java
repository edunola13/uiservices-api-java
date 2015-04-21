package com.tags.jsf.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.ui.ApiUi;

@FacesComponent(createTag = true, namespace="http://www.edunola.com.ar/uicomponents", tagName="inputButton", value="inputButton")
public class InputButton extends UIComponentBase{
	private String labelButton;
	private String type;
	private String id= "";
	private String name;
	private String placeholder;
	private Object value;
	private String onClick= "";
	private String buttonId= "";
	private String buttonStyle= "default";	
	private String size = "md";
	private Boolean buttonAfter= true;
	
	@Override
    public String getFamily() {        
        return "EnolaUIServices";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.labelButton", this.getLabelButton());
		valores.put("config.inputType", this.getType());
		valores.put("config.inputId", this.getId());
		valores.put("config.name", this.getName());		
		if(this.getPlaceholder() != null){valores.put("config.placeholder", this.getPlaceholder());}
		valores.put("config.onclick", this.getOnClick());
		valores.put("config.buttonId", this.getButtonId());	
		valores.put("config.buttonStyle", this.getButtonStyle());	
		if(this.getButtonAfter()){
			valores.put("config.buttonAfter", "si");
		}else{
			valores.put("config.buttonAfter", "no");
		}
		valores.put("config.size", this.getSize());
				
		if(this.getValue() != null){
			valores.put("config.value", this.getValue());
		}		
		
        ResponseWriter writer = context.getResponseWriter();
        writer.write(api.imprimirComponente("input_button", valores));
    }

	public String getLabelButton() {
		return labelButton;
	}

	public void setLabelButton(String labelButton) {
		this.labelButton = labelButton;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getButtonAfter() {
		return buttonAfter;
	}

	public void setButtonAfter(Boolean buttonAfter) {
		this.buttonAfter = buttonAfter;
	}
}
