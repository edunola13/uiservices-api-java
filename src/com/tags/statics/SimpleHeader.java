package com.tags.statics;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class SimpleHeader extends TagSupport{
	private String primario;
	private String secundario;
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.primario", this.getPrimario());
		if(this.getSecundario() != null){
			valores.put("config.secundario", this.getSecundario());
		}
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("simple_header", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	
	public String getPrimario() {
		return primario;
	}
	public void setPrimario(String primario) {
		this.primario = primario;
	}
	public String getSecundario() {
		return secundario;
	}
	public void setSecundario(String secundario) {
		this.secundario = secundario;
	}
	
	
}
