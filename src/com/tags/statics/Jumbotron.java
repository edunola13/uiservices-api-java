package com.tags.statics;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Jumbotron extends TagSupport{
	private String title;
	private String content;
	private String href;
	private String label;
	private String buttonStyle= "default";
	private String buttonSize= "md";
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.titulo", this.getTitle());
		valores.put("config.contenido", this.getContent());
		valores.put("config.href", this.getHref());
		valores.put("config.label", this.getLabel());
		valores.put("config.buttonStyle", this.getButtonStyle());
		valores.put("config.buttonSize", this.getButtonSize());
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("jumbotron", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}


	public String getButtonStyle() {
		return buttonStyle;
	}


	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}


	public String getButtonSize() {
		return buttonSize;
	}


	public void setButtonSize(String buttonSize) {
		this.buttonSize = buttonSize;
	}	
	
}
