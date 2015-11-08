<%@page import="org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="com.classes.Prueba" %>
<%@taglib prefix="ui" uri="http://www.edunola.com.ar/" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UI Services - Java</title>	
	
	<ui:setProject name="bootstrap3"/>
	<ui:theme ></ui:theme>	
	<ui:javaScript></ui:javaScript>	
</head>
<body>
	<%
		request.setAttribute("algo", "siu");
		String num= "3";
		String num2= "3";
		Integer num3= 4;
		Integer num4= 2;
		List<String> values= new ArrayList<String>();
		values.add("1");
		values.add("3");
		List<Prueba> pruebas= new ArrayList<Prueba>();
		Prueba prueba1= new Prueba();
		prueba1.setValue("1");prueba1.setLabel("El 1");
		pruebas.add(prueba1);
		Prueba prueba2= new Prueba();
		prueba2.setValue("3");prueba2.setLabel("El 3");
		pruebas.add(prueba2);
		Prueba prueba3= new Prueba();
		prueba3.setValue("2");prueba3.setLabel("El 2");
		pruebas.add(prueba3);
		
	%>
<div class="container">
	<ui:navigationBar href="#" logo="Logo" containerFluid="true" inverse="false">
		<ui:navBarLeft>
			<ui:navItem label="Opcion 1" href="#"  />
			<ui:navItem label="Opcion 2" href="#" state="active"/>
			<ui:navItemDropDown label="Mas Opciones">
				<ui:menuItem type="item" href="#" label="Una Opcion" />
				<ui:menuItem type="label" label="..."></ui:menuItem>
			</ui:navItemDropDown>
		</ui:navBarLeft>
		<ui:navBarForm label="Aceptare" inputName="nombre" action="#" placeholder="Algo" method="POST" />
		<ui:navBarRight>
			<ui:navItem label="Opcion 1" href="#"  />
			<ui:navItem label="Opcion 2" href="#" state="active"/>
		</ui:navBarRight>
	</ui:navigationBar>	
			
	<ui:form label="Esto es un form" action="urls" method="GET" enctype="text/plain">		
		<ui:input name="nombre" id="nombre" label="Nombre:" type="text" value="<%=num2 %>" placeholder="Nombre" message="asas" typeError="error"></ui:input>
				
		<ui:textarea name="descripcion" label="Descripcion:" placeholder="Escriba aqui la descripcion" rows="15" value="<%=num3 %>"></ui:textarea>
		
		<ui:select name="nameSelect" label="Select de un boton" value="<%= num2 %>" id="idSelect" message="Mensaje" size="lg" typeError="error"  onChange="metodo()">
			<ui:selectOption value="<%=num %>" label="opcion1"></ui:selectOption>
			<ui:selectOption value="2" label="opcion2"></ui:selectOption>
			<ui:selectOption value="3" label="opcion3"></ui:selectOption>
		</ui:select>
		
		<ui:selectFull name="opciones2" simple="false" label="Simple Select de un Boton" value="<%=num2%>" message="Mensaje" methodLabel="label" methodValue="value" options="<%=pruebas%>" defaultLabel="Elija una Opcion" defaultValue="0"></ui:selectFull>
		<ui:selectMultipleFull name="opciones2Multiple" label="Multiple Select de un Boton" value="<%=values%>" methodLabel="label" methodValue="value" options="<%=pruebas%>"></ui:selectMultipleFull>
		
		<ui:booleanCheckbox name="bool" label="Ejemplo Boolean" value='<%=num == "3" %>' size="sm" typeError="error" id="idCheckBool"/>
		
		<ui:checkbox name="checkMul" label="Select de Checkbox" value="<%= values %>" inline="<%= true %>" size="lg" typeError="error" id="checkMul">
			<ui:checkboxOption label="Opcion 1" value="1"></ui:checkboxOption>
			<ui:checkboxOption label="Opcion 2" value="2"></ui:checkboxOption>
		</ui:checkbox>
		
		<ui:checkboxFull name="checkMul2" label="Select de Checkbox" value="<%= values %>" inline="<%= true %>" size="lg" typeError="error" id="checkMul2" options="<%=pruebas%>" methodLabel="label" methodValue="value">
		</ui:checkboxFull>
		
		<ui:radio name="radio" label="Radio de Formulario" value="<%=num %>" size="sm" typeError="success">
			<ui:radioOption label="Opcion radio 1" value="<%=num2 %>"></ui:radioOption>
			<ui:radioOption label="Opcion radio 2" value="3"></ui:radioOption>
		</ui:radio>
		
		<ui:radioFull name="radio2" label="Radio de Formulario" value="1" size="sm" typeError="success" options="<%=pruebas%>" methodLabel="label" methodValue="value" id="radio2">
		</ui:radioFull>
		
		<ui:boxButton>
			<ui:button label="Aceptar" type="submit"></ui:button>
			<ui:button label="Borrar Campos" type="reset" style="primary" id="Boton" onClick=""></ui:button>
		</ui:boxButton>
	</ui:form>	
</div>	
</body>
</html>