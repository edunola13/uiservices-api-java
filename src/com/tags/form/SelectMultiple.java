package com.tags.form;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.classes.Prueba;
import com.ui.ApiUi;

@SuppressWarnings("serial")
public class SelectMultiple extends TagSupport{
	private Boolean simple= false;
	private String label;
	private String id= "";
	private String name;
	private Object value;
	private String message;
	private String typeError;
	private String size = "md";
	private String onChange= "";
	private Object options;
	private String method;
	
	@SuppressWarnings({"static-access" })
	@Override
	public int doStartTag() throws JspException {
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "cabecera");
		valores.put("config.label", this.getLabel());
		valores.put("config.id", this.getId());
		valores.put("config.name", this.getName());
		valores.put("config.multiple", "si");
		if(this.getMessage() != null){valores.put("config.message", this.getMessage());}
		if(this.getTypeError() != null){valores.put("config.typeError", this.getTypeError());}
		valores.put("config.size", this.getSize());
		valores.put("config.onchange", this.getOnChange());
		
		if(this.getOptions() != null){
			try {
				Method m = this.getOptions().getClass().getMethod(this.getMethod(), null);
				try {
					System.out.print(m.invoke(this.getOptions(), null));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			if(this.getSimple()){
				out.println(api.imprimirComponente("select_simple", valores));
			} else{
				out.println(api.imprimirComponente("select", valores));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//Almaceno el valor del select para que lo consulten los option
		pageContext.setAttribute("valueSelect", this.getValue(), pageContext.PAGE_SCOPE);
		//Alamacena que el select es simple. Para que la opcion compare contra un unico valor
		pageContext.setAttribute("typeSelect", "multiple", pageContext.PAGE_SCOPE);
		
		return EVAL_BODY_INCLUDE;
	}
	
	@SuppressWarnings({"static-access" })
	@Override
	public int doEndTag(){
		ApiUi api= ApiUi.getInstance();
		
		//Armo un mapa con los valores de configuracion del Componente
		Map<String, Object> valores= new HashMap<String, Object>();
		valores.put("config.seccion", "pie");
		if(this.getMessage() != null){valores.put("config.message", this.getMessage());}
				
		//Perform substr operation on string.
		try {
			//Get the writer object for output.
			JspWriter out = pageContext.getOut();
			//Imprimo el resultado en la JSP
			if(this.getSimple()){
				out.println(api.imprimirComponente("select_simple", valores));
			} else{
				out.println(api.imprimirComponente("select", valores));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Elimino el valor del select una vez que ya se ejecuto el cuerpo
		pageContext.setAttribute("valueSelect", null, pageContext.PAGE_SCOPE);
		//Elimino que el select es simple. Para que la opcion compare contra un unico valor
		pageContext.setAttribute("typeSelect", "simple", pageContext.PAGE_SCOPE);
		
		return SKIP_BODY;
	}
		
	
	public Boolean getSimple() {
		return simple;
	}

	public void setSimple(Boolean simple) {
		this.simple = simple;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public Object getOptions() {
		return options;
	}

	public void setOptions(Object options) {
		this.options = options;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	

}
