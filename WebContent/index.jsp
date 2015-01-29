<%@page import="org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="com.classes.*" %>
<%@taglib prefix="ui" uri="http://www.edunola.com.ar/" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<ui:theme nombre="cerulean"></ui:theme>
	<ui:theme nombre="tablero"/>
	
	<title>Cliente UI</title>
	<ui:javaScript></ui:javaScript>
	<ui:javaScript nombre="tablero"></ui:javaScript>
	
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
		List<Integer> valuesInt= new ArrayList<Integer>();
		valuesInt.add(num3);
		valuesInt.add(num4);
		valuesInt.add(3);
		List<Prueba> pruebas= new ArrayList<Prueba>();
		Prueba prueba1= new Prueba();
		prueba1.setChau("1");prueba1.setHola("El 1");
		pruebas.add(prueba1);
		Prueba prueba2= new Prueba();
		prueba2.setChau("3");prueba2.setHola("El 3");
		pruebas.add(prueba2);
		Prueba prueba3= new Prueba();
		prueba3.setChau("2");prueba3.setHola("El 2");
		pruebas.add(prueba3);
		
	%>
<div class="container">
	<ui:columnParsed units="Horas" tableId="datatable" title="Tiempo por Procesos"></ui:columnParsed>
	<table id="datatable">
	<thead>
            <tr>
		<th></th>
		<th>Jane</th>
            </tr>
	</thead>
	<tbody>
            <tr>
                <th>Proceso</th>
		<td>0.23</td>
		</tr>
            <tr>
                <th>Proceso Pepe</th>
		<td>2</td>
            </tr>
            <tr>
                <th>Proceso pluma</th>
		<td>10</td>
            </tr>
	</tbody>
    </table>
	<ui:dateCountdown id="algo2" height="200" date="2014-05-05 00:00:00" width="500"></ui:dateCountdown>
	
	<ui:dateCountdown id="algo3" height="200" date="2014-05-09 00:00:00" width="500"></ui:dateCountdown>

	<ui:address address="523 n 3443" locality="La Plata, Buenos Aires" name="Prueba Adress" phone="${requestScope.algo} 234" />
	
	<ui:alertMessage strong="Esto es fuerte" type="danger" message="Esto es un Mensaje de alerta"></ui:alertMessage>
	
	<ui:badge badge="5" href="#" label="Label del Badge" />
	
	<ui:buttonBadge badge="3" label="Label a" id="1" onClick="as()"></ui:buttonBadge>
	
	<ui:blockquote source="Pepito Rodriguez" text="Esto es un texto que luego va a contener la fuente del mismo" />
	
	<ui:searchForm label="Formulario de busqueda" inputName="inputImpo" inputValue="<%=num3 %>" inputPlaceholder="asadasds" button_id="sd" onclick="23"/>
	
	<ui:iframe ratio="small" src="http://www.edunola.com.ar/"></ui:iframe>
	
	<ui:image alt="Esto es una linda imagen" src="" />
	
	<ui:jumbotron href="" titulo="Gran Jumbo" label="Ver Más" contenido="Esto es un jmbotron el cual es realizado con la API de UI para java."></ui:jumbotron>
	
	<ui:simplePaginator next_url="next" previous_url="previous" next_label="Proximo" previous_label="Anterior" previous_disabled="true"></ui:simplePaginator>
	
	<ui:progressBar porcentaje="50" striped="true"></ui:progressBar>
	
	<ui:simpleFooter><p>Pie de Pagina</p></ui:simpleFooter>
	
	<ui:simpleHeader primario="Titkulo porimario" secundario="Texto Secundario"></ui:simpleHeader>
	
	<ui:thumbnail href="" label="Ver Más" content="Este es el contenido en texto del Thyumbnailo. Aqui pone lo que quiere" alt="Esto es una imagen" title="Gran Thumbnail" src=""></ui:thumbnail>
	
	<ui:title title="Gran titulo" />
	
	<ui:well content="Este es todo el contenido del well. Ponga lo que desee aquí."></ui:well>
		
	<ui:login method="POST" passName="pass" action="#" buttonLabel="Ingresar" checkName="check" checkLabel="Mantener Sesion" title="Logueo" userName="user" passPlaceholder="Password" userPlaceholder="Usuario" checkValue="1" userValue="essss"></ui:login>
		
	<ui:form label="Esto es un form" action="urls" method="GET" enctype="text/plain">		
		<ui:input name="nombre" id="aaa" label="Nombre:" type="text" value="<%=num2 %>" placeholder="Nombre" message="asas" typeError="error"></ui:input>
				
		<ui:textarea name="descripcion" label="Descripcion:" placeholder="Escriba aqui la descripcion" rows="15" value="<%=num3 %>"></ui:textarea>
		
		<ui:select name="opciones" label="Select de un boton" value="<%= num2 %>" id="asas" message="puti" size="lg" typeError="error"  onChange="as()">
			<ui:selectOption value="<%=num %>" label="opcion1"></ui:selectOption>
			<ui:selectOption value="2" label="opcion2"></ui:selectOption>
			<ui:selectOption value="3" label="opcion3"></ui:selectOption>
		</ui:select>
		
		<ui:selectFull name="opciones2" simple="true" label="Multiple Select de un Boton" value="<%=num4%>" message="pepe" methodLabel="getHola" methodValue="getChau" options="<%=pruebas%>" defaultLabel="Gil Gil" defaultValue="0"></ui:selectFull>
		<ui:selectMultipleFull name="opciones2" label="Multiple Select de un Boton" value="<%=valuesInt%>" message="pepe" methodLabel="getHola" methodValue="getChau" options="<%=pruebas%>"></ui:selectMultipleFull>
		
		<ui:booleanCheckbox name="bool" label="Ejemplo Boolean" value='<%=num == "3" %>' size="sm" typeError="error" id="asadad"/>
		
		<ui:checkbox name="pedrito" label="Select de Checkbox" value="<%= values %>" inline="<%= true %>" size="lg" typeError="error" id="aaaa">
			<ui:checkboxOption label="Opcion 1" value="1"></ui:checkboxOption>
			<ui:checkboxOption label="Opcion 2" value="2"></ui:checkboxOption>
		</ui:checkbox>
		
		<ui:checkboxFull name="pedrito" label="Select de Checkbox" value="<%= valuesInt %>" inline="<%= true %>" size="lg" typeError="error" id="aaaa" options="<%=pruebas%>" methodLabel="getHola" methodValue="getChau">
		</ui:checkboxFull>
		
		<ui:radio name="pedron21" label="Radio de Formulario" value="<%=num %>" size="sm" typeError="success">
			<ui:radioOption label="Opcion radio 1" value="<%=num2 %>"></ui:radioOption>
			<ui:radioOption label="Opcion radio 2" value="3"></ui:radioOption>
		</ui:radio>
		
		<ui:radioFull name="pedr2on2" label="Radio de Formulario" value="<%=1 %>" size="sm" typeError="success" options="<%=pruebas%>" methodLabel="getHola" methodValue="getChau" id="asas">
		</ui:radioFull>
		
		<ui:boxButton>
			<ui:button label="Aceptar" type="submit"></ui:button>
			<ui:button label="Borrar Campos" type="reset" style="primary" id="12" onClick="asd"></ui:button>
		</ui:boxButton>
	</ui:form>
	
	<ui:form_inline action="" method="POST" id="formi">
		<ui:input_inline name="pepe" label="pepe" type="date" id="as" placeholder="asass" value="as" size="sm" typeError="error"></ui:input_inline>
		<ui:input_inline name="pepe" label="pepe" type="date" id="as" placeholder="asass" value="" size="sm" typeError="success"></ui:input_inline>
				
		<ui:select name="opciones" label="Select de un boton" value="<%= num2 %>" id="asas" size="sm" onChange="as()" simple="true">
			<ui:selectOption value="<%=num %>" label="opcion1"></ui:selectOption>
			<ui:selectOption value="2" label="opcion2"></ui:selectOption>
			<ui:selectOption value="3" label="opcion3"></ui:selectOption>
		</ui:select>
		
		<ui:selectMultiple name="opciones2" label="Multiple Select de un Boton" value="<%=values%>" message="pepe" simple="false">
			<ui:selectOption value="1" label="opcion1"></ui:selectOption>
			<ui:selectOption value="<%=num%>" label="opcion2"></ui:selectOption>
			<ui:selectOption value="<%=num2%>" label="opcion3"></ui:selectOption>
		</ui:selectMultiple>
	</ui:form_inline>

	<ui:button_group label="adadd">
		<ui:button label="Aceptar" type="submit"></ui:button>
		<ui:button label="Borrar Campos" type="reset" style="primary" id="12" onClick="asd"></ui:button>
	</ui:button_group>
	
	<ui:button_toolbar>
		<ui:button_group label="adadd" size="sm">
			<ui:button label="Aceptar" type="submit"></ui:button>
			<ui:button label="Borrar Campos" type="reset" style="primary" id="12" onClick="asd"></ui:button>
		</ui:button_group>
		<ui:button_group label="adadd" size="sm" vertical="true">
			<ui:button label="Aceptar" type="submit"></ui:button>
			<ui:button label="Borrar Campos" type="reset" style="primary" id="12" onClick="asd"></ui:button>
		</ui:button_group>
	</ui:button_toolbar>

	<ui:input_button name="asas" type="text" labelButton="Algo"></ui:input_button>

	<ui:navigationBar href="#" logo="Logo">
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
	
	<ui:dropDownMenu label="Menu Desplegable" right="true">
		<ui:menuItem type="item" href="#" label="Opcion 1" />
		<ui:menuItem type="item" disabled="true" href="#" label="Opcion Alguna" />
		<ui:menuItem type="divider" />
		<ui:menuItem type="label" label="Opcion2" />
	</ui:dropDownMenu>
	
	<ui:navigationMenu type="pills">
		<ui:navItem label="Opcion 1" href="#" state="active" />
		<ui:navItem label="Opcion 2" href="#" />
		<ui:navItemDropDown label="Mas Opciones" right="true">
			<ui:menuItem type="item" href="#" label="Una Opcion" />
			<ui:menuItem type="label" label="..."></ui:menuItem>
		</ui:navItemDropDown>
	</ui:navigationMenu>
	
	
	<ui:breadcrumb>
		<ui:navItem label="Opcion 1" href="#"/>
		<ui:navItem label="Opcion 2" href="#" state="disabled" />
	</ui:breadcrumb>
	
	<ui:ul_a>
		<ui:li_a href="sadas" label="Perro" badge="Siiii" active="true"></ui:li_a>
		<ui:li_a href="sadas" label="Gato" active="false"></ui:li_a>
		<ui:li_a href="sadas" label="Leon" badge="Hola"></ui:li_a>
	</ui:ul_a>
		
	<ui:ul>
		<ui:li label="Perro"></ui:li>
		<ui:li label="Gato" badge="2"></ui:li>
		<ui:li label="Leon" active="true"></ui:li>
		<ui:li label="Perro"></ui:li>
	</ui:ul>

	<ui:paginator>
		<ui:page url="#" first="true"></ui:page>
		<ui:page url="#" label="1"></ui:page>
		<ui:page url="#" label="..." state="disabled"></ui:page>
		<ui:page url="#" label="5" state="active"></ui:page>
		<ui:page url="#" last="true"></ui:page>
	</ui:paginator>
	
	<ui:paragraph>
		<ui:em value="Esto es un texto EM" /><ui:small value="Esto es un texto chico" /><ui:strong value="Este es un texto fuerte" />
		<ui:text value="Esto es un texto normal" />
	</ui:paragraph>
	
	<ui:mediaObject href="#" content="Este es el contenido escrito del media object. Ponga aqui lo que desee" alt="Esto es una imagen" title="Gran Media Object" src="">
		<ui:mediaObject href="#" content="Este es el contenido escrito del media object. Ponga aqui lo que desee" alt="Esto es una imagen" title="Gran Media Object" src=""></ui:mediaObject>
	</ui:mediaObject>
	<ui:mediaObject href="#" content="Este es el contenido escrito del media object. Ponga aqui lo que desee" alt="Esto es una imagen" title="Gran Media Object" src=""></ui:mediaObject>
	
	<ui:panel title="Titulo Panel" foot="Footer">
		Esto es lo que esta dentro del Panel
	</ui:panel>
	
	
	
	<ui:table>
		<ui:tableHead>
			<ui:tableHeadField value="Cabecera1"></ui:tableHeadField>
			<ui:tableHeadField value="Cabecera2"></ui:tableHeadField>
			<ui:tableHeadField>Cabecera 3</ui:tableHeadField>
		</ui:tableHead>
		
		<ui:tableRow>
			<ui:tableField>1</ui:tableField>
			<ui:tableField value="Eduardo Sebastian Nola"></ui:tableField>
			<ui:tableField>edunola13@hotmail.com</ui:tableField>
		</ui:tableRow>
		<ui:tableRow>
			<ui:tableField>2</ui:tableField>
			<ui:tableField value="Anabella Di Graia"></ui:tableField>
			<ui:tableField>anabella@hotmail.com</ui:tableField>
		</ui:tableRow>
		<ui:tableRow>
			<ui:tableField>3</ui:tableField>
			<ui:tableField value="Federico Archuby"></ui:tableField>
			<ui:tableField>chuby@hotmail.com</ui:tableField>
		</ui:tableRow>
	</ui:table>

</div>

<ui:fixedFooter>
	<ui:paragraph>
		<ui:text value="Pie de Pagina" />
	</ui:paragraph>
</ui:fixedFooter>

	
</body>
</html>