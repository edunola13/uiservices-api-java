package com.tags.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class RadioOption extends TagSupport{
	private Object value;
	private String label;
		
	
	@SuppressWarnings({"static-access" })
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		
		//Name Checkbox
		String name= (String) pageContext.getAttribute("nameRadio", pageContext.PAGE_SCOPE);
		valores.put("config.name", name);
		
		//Inline Checkbox
		boolean inline= (boolean) pageContext.getAttribute("inlineRadio", pageContext.PAGE_SCOPE);
		if(inline){
			valores.put("config.inline", "si");
		}
		else{
			valores.put("config.inline", "no");
		}
		
		//Numero Checkbox
		int numero= (int) pageContext.getAttribute("numRadio", pageContext.PAGE_SCOPE);
		String id= (String) pageContext.getAttribute("idRadio", pageContext.PAGE_SCOPE);
		valores.put("config.id", id + Integer.toString(numero));	
		//Aumento en uno el numero
		pageContext.setAttribute("numRadio", numero + 1, pageContext.PAGE_SCOPE);
		
		//Consigo dato del select ui
		Object actual= pageContext.getAttribute("valueRadio", pageContext.PAGE_SCOPE);
				
		if(actual.equals(this.getValue())){
			valores.put("config.checked", "si");
		}
		else{
			valores.put("config.checked", "no");
		}
				
		if(this.getValue() != null){
			valores.put("datos.value", this.getValue());
		}
						
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("radio_option", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	

}
