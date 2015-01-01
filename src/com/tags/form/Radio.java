package com.tags.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Radio extends TagSupport{
	private String label;
	private String name;
	private Object value;
	private boolean inline= false;
	
	
	@SuppressWarnings({"static-access" })
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "cabecera");
		valores.put("config.label", this.getLabel());
		
		if(this.isInline()){
			valores.put("config.inline", "si");
		}
		else{
			valores.put("config.inline", "no");
		}		
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("radio", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Almaceno el name del checkbox para que lo consulten los option
		pageContext.setAttribute("nameRadio", this.getName(), pageContext.PAGE_SCOPE);
		//Almaceno el valor del cehckbox para que lo consulten los option
		pageContext.setAttribute("valueRadio", this.getValue(), pageContext.PAGE_SCOPE);
		//Inicializo el contador de Checkbox
		pageContext.setAttribute("numRadio", 0, pageContext.PAGE_SCOPE);
		//Alamaceno si los checkbox se deben acomodar inline o no
		pageContext.setAttribute("inlineRadio", this.isInline(), pageContext.PAGE_SCOPE);
		
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
			out.println(api.imprimirComponente("radio", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Elimino el name del checkbox para que lo consulten los option
		pageContext.setAttribute("nameRadio", null, pageContext.PAGE_SCOPE);
		//Elimino el valor del checkbox una vez que ya se ejecuto el cuerpo
		pageContext.setAttribute("valueRadio", null, pageContext.PAGE_SCOPE);
		//Elimino el contador de Checkbox
		pageContext.setAttribute("numRadio", null, pageContext.PAGE_SCOPE);
		//Elimino si los checkbox se deben acomodar inline o no
		pageContext.setAttribute("inlineRadio", null, pageContext.PAGE_SCOPE);
		
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

	public boolean isInline() {
		return inline;
	}

	public void setInline(boolean inline) {
		this.inline = inline;
	}
	

}
