package com.tags.statics;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;


@SuppressWarnings("serial")
public class SearchForm extends TagSupport{
	private String label;
	private String inputName;
	private String button_id;
	private String onclick;
	private String inputPlaceholder;
	private Object inputValue;
	

	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		valores.put("config.input.name", this.getInputName());
		if(this.getButton_id() != null){
			valores.put("config.id", this.getButton_id());
		}
		if(this.getOnclick() != null){
			valores.put("config.onclick", this.getOnclick());
		}
		if(this.getInputPlaceholder() != null){
			valores.put("config.input.placeholder", this.getInputPlaceholder());
		}
		valores.put("datos.value_input", this.getInputValue());
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("form_search", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
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

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
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
