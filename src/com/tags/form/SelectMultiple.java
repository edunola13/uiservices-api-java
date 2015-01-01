package com.tags.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class SelectMultiple extends TagSupport{
	private String label;
	private String name;
	private Object value;
	private Boolean multiple= false;
	
	
	@SuppressWarnings({"static-access" })
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "cabecera");
		valores.put("config.label", this.getLabel());
		valores.put("config.name", this.getName());
		valores.put("config.multiple", "si");
		
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("select", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Almaceno el valor del select para que lo consulten los option
		pageContext.setAttribute("valueSelect", this.getValue(), pageContext.PAGE_SCOPE);
		//Alamacena que el select es simple. Para que la opcion compare contra un unico valor
		pageContext.setAttribute("typeSelect", "multiple", pageContext.PAGE_SCOPE);
		
		return EVAL_BODY_INCLUDE;
	}
	
	@SuppressWarnings({"static-access" })
	@Override
	public int doEndTag(){
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("select", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Elimino el valor del select una vez que ya se ejecuto el cuerpo
		pageContext.setAttribute("valueSelect", null, pageContext.PAGE_SCOPE);
		//Elimino que el select es simple. Para que la opcion compare contra un unico valor
		pageContext.setAttribute("typeSelect", "simple", pageContext.PAGE_SCOPE);
		
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
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Boolean getMultiple() {
		return multiple;
	}
	
	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}
	

}
