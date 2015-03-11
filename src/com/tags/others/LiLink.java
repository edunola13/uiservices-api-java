package com.tags.others;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class LiLink extends TagSupport{
	private String label;
	private String href;
	private String badge;
	private Boolean active;
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.type", "lista_a");
		valores.put("config.label", this.getLabel());
		valores.put("config.href", this.getHref());
		if(this.getBadge() != null){
			valores.put("config.badge", this.getBadge());
		}
		if(this.getActive() != null){
			if(this.getActive()){
				valores.put("config.active", "active");
			}
		}
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("li", valores));
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
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}




}
