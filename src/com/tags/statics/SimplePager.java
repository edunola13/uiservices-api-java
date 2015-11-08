package com.tags.statics;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class SimplePager extends TagSupport{
	private Boolean previous_disabled;
	private String previous_url;
	private String previous_label;
	private Boolean next_disabled;
	private String next_url;
	private String next_label;
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		//Para el boton Previous
		if(this.getPrevious_disabled() != null){
			if(this.getPrevious_disabled()){
				valores.put("config.previous.state", "disabled");
			}
		}
		valores.put("config.previous.href", this.getPrevious_url());
		valores.put("config.previous.label", this.getPrevious_label());
		
		//Para el boton next
		if(this.getNext_disabled() != null){
			if(this.getNext_disabled()){
				valores.put("config.next.state", "disabled");
			}
		}
		valores.put("config.next.href", this.getNext_url());
		valores.put("config.next.label", this.getNext_label());
		
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("simple_pager", valores));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	
	public Boolean getPrevious_disabled() {
		return previous_disabled;
	}

	public void setPrevious_disabled(Boolean previous_disabled) {
		this.previous_disabled = previous_disabled;
	}

	public String getPrevious_url() {
		return previous_url;
	}

	public void setPrevious_url(String previous_url) {
		this.previous_url = previous_url;
	}

	public String getPrevious_label() {
		return previous_label;
	}

	public void setPrevious_label(String previous_label) {
		this.previous_label = previous_label;
	}

	public Boolean getNext_disabled() {
		return next_disabled;
	}

	public void setNext_disabled(Boolean next_disabled) {
		this.next_disabled = next_disabled;
	}

	public String getNext_url() {
		return next_url;
	}

	public void setNext_url(String next_url) {
		this.next_url = next_url;
	}

	public String getNext_label() {
		return next_label;
	}

	public void setNext_label(String next_label) {
		this.next_label = next_label;
	}

	



}
