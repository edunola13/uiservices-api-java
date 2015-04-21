package com.tags.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class InputButton extends TagSupport{
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
	public int doStartTag() throws JspException {
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
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("input_button", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLabelButton() {
		return labelButton;
	}

	public void setLabelButton(String labelButton) {
		this.labelButton = labelButton;
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

	public Boolean getButtonAfter() {
		return buttonAfter;
	}

	public void setButtonAfter(Boolean buttonAfter) {
		this.buttonAfter = buttonAfter;
	}

}
