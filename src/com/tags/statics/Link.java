package com.tags.statics;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Link extends TagSupport{
	private String id;
	private String href;
	private String label;
	private Boolean button= false;
	private String style= "default";
	private String size= "md";
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.id", this.getId());
		valores.put("config.href", this.getHref());
		valores.put("config.label", this.getLabel());
		valores.put("config.style", this.getStyle());
		valores.put("config.size", this.getSize());
		if(this.getButton()){
			valores.put("config.button", "si");
		}else{
			valores.put("config.button", "no");
		}
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("link", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getButton() {
		return button;
	}

	public void setButton(Boolean button) {
		this.button = button;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
}
