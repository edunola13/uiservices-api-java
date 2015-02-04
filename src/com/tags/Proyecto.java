package com.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Proyecto extends TagSupport{
	private String nombre= "bootstrap3";
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi.setProyecto(this.getNombre());
		return SKIP_BODY;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
