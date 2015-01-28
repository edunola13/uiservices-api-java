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
	private String id= "";
	private String name;
	private Boolean value;
	private String typeError;
	private String size = "md";
	
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
		
		Map<String, Object> valoresOpcion= new HashMap<String, Object>();

		valoresOpcion.put("config.name", this.getName());
		valoresOpcion.put("config.inline", "si");
		valoresOpcion.put("config.id", this.getId());
		valoresOpcion.put("datos.value", 1);
		
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

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
