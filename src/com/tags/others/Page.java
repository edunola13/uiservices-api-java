package com.tags.others;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Page extends TagSupport{
	private String label;
	private String url;
	private String state;
	private Boolean first;
	private Boolean last;
	
	
	@Override
	public int doStartTag() throws JspException {
ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		
		if(this.getLabel() != null){
			valores.put("config.label", this.getLabel());
		}
		valores.put("config.href", this.getUrl());
		if(this.getState() != null){
			valores.put("config.state", this.getState());
		}
		if(this.getFirst() != null){
			if(this.getFirst()){
				valores.put("config.first", "si");
			}
		}
		if(this.getLast() != null){
			if(this.getLast()){
				valores.put("config.last", "si");
			}
		}		
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("pagina", valores));
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getFirst() {
		return first;
	}
	public void setFirst(Boolean first) {
		this.first = first;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	
}
