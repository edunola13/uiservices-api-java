package com.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class ServerUrl extends TagSupport{
	private String url= "";
	
	@Override
	public int doStartTag() throws JspException {
		ApiUi.setServerUrl(this.getUrl());
		return SKIP_BODY;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
