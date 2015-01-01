package com.tags.form;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class CheckboxOption extends TagSupport{
	private Object value;
	private String label;
		
	
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.label", this.getLabel());
		
		//Name Checkbox
		String name= (String) pageContext.getAttribute("nameCheckbox", pageContext.PAGE_SCOPE);
		valores.put("config.name", name);
		
		//Inline Checkbox
		boolean inline= (boolean) pageContext.getAttribute("inlineCheckbox", pageContext.PAGE_SCOPE);
		if(inline){
			valores.put("config.inline", "si");
		}
		else{
			valores.put("config.inline", "no");
		}
		
		//Numero Checkbox
		int numero= (int) pageContext.getAttribute("numCheckbox", pageContext.PAGE_SCOPE);
		valores.put("config.num", numero);
		
		//Aumento en uno el numero
		pageContext.setAttribute("numCheckbox", numero + 1, pageContext.PAGE_SCOPE);
		
		//Consigo dato del select ui
		Collection<Object> actuales= (Collection<Object>) pageContext.getAttribute("valueCheckbox", pageContext.PAGE_SCOPE);
		for(Object actual: actuales){
			if(actual.equals(this.getValue())){
				valores.put("config.checked", "si");
				break;
			}
			else{
				valores.put("config.checked", "no");
			}
		}
			
		if(this.getValue() != null){
			valores.put("datos.value", this.getValue());
		}		
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("checkbox_option", valores));
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
