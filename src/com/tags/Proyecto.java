package com.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Proyecto extends TagSupport{
	private String name= "bootstrap3";
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi.setProyecto(this.getName());
		return SKIP_BODY;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
