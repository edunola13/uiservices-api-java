package com.tags.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.ui.ApiUi;

@SuppressWarnings("serial")
public class Login extends Form{
	private String title;
	private String userPlaceholder;
	private String userName;
	private Object userValue;
	private String passPlaceholder;
	private String passName;
	private String checkName;
	private Object checkValue;
	private String checkLabel;
	private String buttonLabel;

	
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.method", this.getMethod());
		valores.put("config.action", this.getAction());
		
		valores.put("config.title", this.getTitle());
		if(this.getUserPlaceholder() != null){
			valores.put("datos.user.placeholder", this.getUserPlaceholder());
		}
		valores.put("datos.user.name", this.getUserName());
		if(this.getUserValue() != null){
			valores.put("datos.user.value", this.getUserValue());
		}
		if(this.getPassPlaceholder() != null){
			valores.put("datos.pass.placeholder", this.getPassPlaceholder());
		}
		valores.put("datos.pass.name", this.getPassName());
		valores.put("datos.check.name", this.getCheckName());
		if(this.getCheckValue() != null){
			valores.put("datos.check.value", this.getCheckValue());
		}
		valores.put("datos.check.label", this.getCheckLabel());
		valores.put("config.labelButton", this.getButtonLabel());
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			out.println(api.imprimirComponente("login", valores));
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

	public String getUserPlaceholder() {
		return userPlaceholder;
	}

	public void setUserPlaceholder(String userPlaceholder) {
		this.userPlaceholder = userPlaceholder;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Object getUserValue() {
		return userValue;
	}

	public void setUserValue(Object userValue) {
		this.userValue = userValue;
	}

	public String getPassPlaceholder() {
		return passPlaceholder;
	}

	public void setPassPlaceholder(String passPlaceholder) {
		this.passPlaceholder = passPlaceholder;
	}

	public String getPassName() {
		return passName;
	}

	public void setPassName(String passName) {
		this.passName = passName;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Object getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(Object checkValue) {
		this.checkValue = checkValue;
	}

	public String getCheckLabel() {
		return checkLabel;
	}

	public void setCheckLabel(String checkLabel) {
		this.checkLabel = checkLabel;
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	
	
}
