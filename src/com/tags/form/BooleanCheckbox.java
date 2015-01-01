package com.tags.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class BooleanCheckbox extends TagSupport{
	private String label;
	private String name;
	private Boolean value;
	
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		valores.put("config.inline", "si");
		
		Map<String, Object> valoresOpcion= new HashMap<String, Object>();

		valoresOpcion.put("config.name", this.getName());
		valoresOpcion.put("config.inline", "si");
		valoresOpcion.put("config.num", 0);
		
		if(this.getValue()){
			valoresOpcion.put("config.checked", "si");
		}
		else{
			valoresOpcion.put("config.checked", "no");
		}
		
		valores.put("components", api.imprimirComponente("checkbox_option", valoresOpcion));		
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("checkbox", valores));
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

}
