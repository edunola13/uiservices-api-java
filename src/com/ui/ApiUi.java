package com.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.classes.EstructuraIf;

public class ApiUi {
	private Map<String, String> componentes= new HashMap<String, String>();								//Contiene la definicion del componente solicitada al servicio ui
	private Map<String, List<EstructuraIf>> cache= new HashMap<String, List<EstructuraIf>>();			//Contiene la estructura de if que es creada la primera vez. Seria como una cache
	
	private Map<String, String> themes= new HashMap<String, String>();						//Contiene las definiciones de los temas por nombre
	private Map<String, String> javaScripts= new HashMap<String, String>();               	//Contiene las definiciones de los javaScript por nombre
	
	private static ApiUi instance = null;
	private static String proyecto= "bootstrap3";
		
	protected ApiUi() {
		// Exists only to defeat instantiation.
	}
	   
	public static ApiUi getInstance() {
		if(instance == null) {
			instance = new ApiUi();
	    }
	    return instance;
	}
	
	
	
	public static String getProyecto() {
		return proyecto;
	}
	public static void setProyecto(String proyecto) {
		ApiUi.proyecto = proyecto;
	}

	/**
	 * Metodos de los Themes y JavaScripts
	 */	
	public String theme(String nombre){
		String nom_componente= ApiUi.getProyecto() +  "_" + nombre;
		try{
			URL url;
			HttpURLConnection conn;				
			if(nombre == null){
				nombre= "base";
			}
			
			if(! this.getThemes().containsKey(nom_componente)){
				url= new URL("http://www.edunola.com.ar/serviciosui/theme?nombre=" + nombre + "&proyecto=" + ApiUi.getProyecto());
				//url = new URL("http://localhost/uiservices/theme?nombre=" + nombre + "&proyecto=" + ApiUi.getProyecto());
				
				conn= (HttpURLConnection) url.openConnection();
				String theme= this.conexionGet(url, conn);
				this.getThemes().put(nom_componente, theme);
			}
			
			return this.getThemes().get(nom_componente);
		}
		catch(Exception e){
			this.getThemes().remove(nom_componente);
			System.out.println(e.getMessage());
			return "Ha sucedido un error en la carga del estilo " + nombre;
		}
	}
	
	public String javaScript(String nombre){
		String nom_componente= ApiUi.getProyecto() +  "_" + nombre;
		try{
			URL url;
			HttpURLConnection conn;
				
			if(nombre == null){
				nombre= "base";
			}
			
			if(! this.getJavaScripts().containsKey(nom_componente)){
				url= new URL("http://www.edunola.com.ar/serviciosui/javascript?nombre=" + nombre + "&proyecto=" + ApiUi.getProyecto());
				//url = new URL("http://localhost/uiservices/javascript?nombre=" + nombre + "&proyecto=" + ApiUi.getProyecto());
				
				conn= (HttpURLConnection) url.openConnection();
				String javaScript= this.conexionGet(url, conn);
				this.getJavaScripts().put(nom_componente, javaScript);
			}
			
			return this.getJavaScripts().get(nom_componente);
		}
		catch(Exception e){
			this.getJavaScripts().remove(nom_componente);
			System.out.println(e.getMessage());
			return "Ha sucedido un error en la carga del JavaScript " + nombre;
		}
	}
	
	private String conexionGet(URL url, HttpURLConnection conn) throws Exception{
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(10000);
							
		//Hacer la llamado y recibir el InputStream resultante, transformalo a string y devolverlo
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//Analizo la respuesta
		if(conn.getResponseCode() == 200){
			return response.toString();
		}
		else{
			throw new Exception();
		}
	}	
	/**
	 * Fin metodos de los Themes y JavaScripts
	 */
	
	/**
	 * Metodos de los Componentes
	 */	
	public String imprimirComponente(String nombre, Map<String, Object> valores){
		String nom_componente= ApiUi.getProyecto() +  "_" + nombre;
		try {
			//Veo si tengo que pedir el componente al servidor
			if(! this.getComponentes().containsKey(nom_componente)){			
				//Pido el componente al Servicio UI
				this.component(nombre);
				
				//Armo la estructura (CACHE) del componente
				String componente= this.getComponentes().get(nom_componente);
				List<EstructuraIf> bloques= new ArrayList<EstructuraIf>();
				
				int inicio= componente.indexOf("{%", 0);
				int fin= componente.indexOf("%}", 0);
				while(inicio >= 0 && fin >= 0){
					if(this.tipoIf(inicio, fin, componente) == "if"){
						List<EstructuraIf> res= this.armarEstructura(inicio, componente);
						bloques.addAll(res);
						
						EstructuraIf endif= res.get(res.size() - 1);
						inicio= componente.indexOf("{%", endif.getPosFin() + 1);
						fin= componente.indexOf("%}", endif.getPosFin() + 1);
						
					}
					else{
						throw new Exception("Error, el primero debe ser un if");
					}
				}
				//Guardo la estructura en CACHE
				this.getCache().put(nom_componente, bloques);			
			}
		
			String html= "";
			String componente= this.getComponentes().get(nom_componente);
			List<EstructuraIf> bloques= this.getCache().get(nom_componente);
			
			if(bloques.size() > 0){
				int posActual= 0;		
				html= this.htmlCorrectoIf(bloques, componente, posActual, valores, true);
				componente= html;	
				html= "";
			}
		
			//Cargo las Variables
			int inicio= componente.indexOf("{{");
			int fin= componente.indexOf("}}");		
			while(inicio >= 0 && fin >= 0){
				inicio= inicio + 2;
				
				String var= (componente.substring(inicio, fin));
				if(valores.containsKey(var)){
					html= html + componente.substring(0, inicio - 2) + valores.get(var);
				}
				else{
					html= html + componente.substring(0, inicio - 2) + "";
				}
				
				componente= componente.substring(fin + 2, componente.length());
				
				inicio= componente.indexOf("{{");
				fin= componente.indexOf("}}");
			}
			
			html= html + componente;		
			return html;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "Ha sucedido un error en la carga del Componente " + nombre;
		}
	}
		
	private String htmlCorrectoIf(List<EstructuraIf> bloques, String componente, int posActual, Map<String,Object> valores, boolean primerLlamado){
		String html= "";
		int cantIf= bloques.size();
		int i= 0;
		boolean ifCorrecto= false;
		while(i < cantIf){
			EstructuraIf estructura= bloques.get(i);
			
			if(estructura.getTipo() == "if"){
				html= html + componente.substring(posActual, estructura.getPosInicio());
			}
			
			if(estructura.getTipo().equals("endif")){
				posActual= estructura.getPosFin() + 1;
			}
			else{
				posActual= estructura.getPosFin() + 1;
				
				//Si el ID dio false y estamos con un ELSE o ELSEIF nos da correcto o si es un IF entra directamente
				if(! ifCorrecto || (ifCorrecto && estructura.getTipo() == "if")){
					//If y elseif evaluan
					//else devuelve true
					if(this.evaluateIf(estructura.getPosInicio(), componente, valores)){
						ifCorrecto= true;
						if(estructura.getHijos().size() > 1){
							html= html + this.htmlCorrectoIf(estructura.getHijos(), componente, posActual, valores, false);
							EstructuraIf ultimoHijo= estructura.getHijos().get(estructura.getHijos().size() - 1);
							html= html + componente.substring(ultimoHijo.getPosFin() + 1, bloques.get(i + 1).getPosInicio());
						}
						else{
							html= html + componente.substring(estructura.getPosFin() + 1, bloques.get(i + 1).getPosInicio());
						}
					}
					else{
						ifCorrecto= false;					
					}
				}
			}
			
			i++;
		}
		
		if(primerLlamado){
			//Consigo todo lo que esta despues de los bloques de los IFs
			html= html + componente.substring(posActual, componente.length());
		}
		
		return html;
	}
		
	private List<EstructuraIf> armarEstructura(int inicio, String componente){
		List<EstructuraIf> estructuras= new ArrayList<EstructuraIf>();
		
		inicio= componente.indexOf("{%", inicio);
		int fin= componente.indexOf("%}", inicio);
		String tipoIf= this.tipoIf(inicio, fin, componente);
		while(inicio >= 0 && fin >= 0){
			EstructuraIf estructura= null;
			if(tipoIf == "endif"){
				estructura= new EstructuraIf();
				estructura.setTipo(tipoIf);
				estructura.setPosInicio(inicio);
				estructura.setPosFin(fin + 1);
				
				estructuras.add(estructura);
				
				inicio= -1;
				break;
			}
			else{
				if(tipoIf == "if" || tipoIf == "elseif" || tipoIf == "else"){
					estructura= new EstructuraIf();
					estructura.setTipo(tipoIf);
					estructura.setPosInicio(inicio);
					estructura.setPosFin(fin + 1);
					
					inicio= componente.indexOf("{%", fin +2);
					fin= componente.indexOf("%}", fin + 2);
					tipoIf= this.tipoIf(inicio, fin, componente);
					while(this.tipoIf(inicio, fin, componente) == "if"){
						List<EstructuraIf> hijos= this.armarEstructura(inicio, componente);
						estructura.getHijos().addAll(hijos);
						
						EstructuraIf endif= hijos.get(hijos.size() - 1);
						inicio= componente.indexOf("{%", endif.getPosFin() + 1);
						fin= componente.indexOf("%}", endif.getPosFin() + 1);
						tipoIf= this.tipoIf(inicio, fin, componente);
					}
					
					estructuras.add(estructura);
				}
				else{
					System.out.println("Error, tipo If dio mal");
					break;
				}
			}
		}
		
		return estructuras;
	}
	
	private String tipoIf(int inicio, int fin, String componente){
		inicio= inicio + 2;
		while(componente.charAt(inicio) == ' '){
			inicio++;
		}
		if(componente.substring(inicio, inicio + 3).equals("if ")){
			return "if";
		}
		if(componente.substring(inicio, inicio + 7).equals("elseif ")){
			return "elseif";
		}
		if(componente.substring(inicio, inicio + 5).equals("else ") || componente.substring(inicio, inicio + 5).equals("else}")){
			return "else";
		}
		if(componente.substring(inicio, inicio + 6).equals("endif ") || componente.substring(inicio, inicio + 6).equals("endif}")){
			return "endif";
		}
		return "error";
	}
	
	private Boolean evaluateIf(int inicio, String componente, Map<String, Object> valores){
		boolean evaluacion= false;
		
		inicio= inicio + 2;
		String tipo= "";
		while(componente.charAt(inicio) == ' '){
			inicio++;
		}
		if(componente.substring(inicio, inicio + 3).equals("if ")){
			tipo= "if";
			inicio= inicio + 3;
		}
		if(componente.substring(inicio, inicio + 7).equals("elseif ")){
			tipo= "elseif";
			inicio= inicio + 7;
		}
		if(componente.substring(inicio, inicio + 5).equals("else ") || componente.substring(inicio, inicio + 5).equals("else}")){
			tipo= "else";
			inicio= inicio + 5;
		}
		
		if(tipo == "else"){
			return true;
		}
		
		String op2= "";
		boolean continuar= true;
		while(continuar){
			//Busco la variable de la condicion
			while(componente.charAt(inicio) == ' '){
				inicio++;
			}
			int posVar= inicio;
			while(componente.charAt(inicio) != ' '){
				inicio++;
			}
			String var= componente.substring(posVar, inicio);
			//Busco el comparador
			while(componente.charAt(inicio) == ' '){
				inicio++;
			}
			
			String operacion= "";
			switch (componente.charAt(inicio)) {
			case '=':
				inicio++;
				if(componente.charAt(inicio) == '='){
					operacion= "==";
				}
				break;					
			case '!':
				inicio++;
				if(componente.charAt(inicio) == '='){
					operacion= "!=";
				}
				break;
			case '<':
				inicio++;
				if(componente.charAt(inicio) == '='){
					operacion= "<=";
				}
				else{
					operacion= "<";
				}
				break;
			case '>':
				inicio++;
				if(componente.charAt(inicio) == '='){
					operacion= ">=";
				}
				else{
					operacion= ">";
				}
				break;
			default:
				break;
			}
			
			inicio++;
			while(componente.charAt(inicio) == ' '){
				inicio++;
			}
			int posVar2= inicio;
			while(componente.charAt(inicio) != ' ' && componente.charAt(inicio) != '}'){
				inicio++;
			}
			String var2;
			if((componente.charAt(posVar2) == '"' && componente.charAt(inicio - 1) == '"')){
				var2= componente.substring(posVar2 + 1, inicio - 1);
			}
			else{
				var2= componente.substring(posVar2, inicio);
			}
			
			evaluacion= this.operacion(var, operacion, var2, op2, evaluacion, valores);
			
			continuar= false;
			op2= "";
			if(componente.charAt(inicio) != '}'){
				while(componente.charAt(inicio) == ' '){
					inicio++;
				}
				if(componente.substring(inicio, inicio + 3).equals("and")){
					op2= "&&";
					continuar= true;
					inicio= inicio + 3;
				}
				if(componente.substring(inicio, inicio + 2).equals("or")){
					op2= "||";
					continuar= true;
					inicio= inicio + 2;
				}
			}
		}
		
		return evaluacion;
	}
	
	private boolean operacion(String var, String op, String var2, String op2, boolean rtaAnterior, Map<String,Object> valores){
		boolean rta= false;
		switch (op) {
		case "==":
			if(var2.equals("null")){
				rta= valores.get(var) == null;
			}
			else{				
				if(valores.get(var) == null){
					rta= false;
				}
				else{
					rta= (valores.get(var).equals(var2));
				}
			}
			break;					
		case "!=":
			if(var2.equals("null")){
				rta= valores.get(var) != null;
			}
			else{
				if(valores.get(var) == null){
					rta= false;
				}
				else{
					rta= ! (valores.get(var).equals(var2));
				}
			}
			break;
//		case "<":
//			rta= ((String)valores.get(var) < var2);
//			break;
//		case "<=":
//			
//			break;
//		case ">":
//			
//			break;
//		case ">=":
//			
//			break;
		default:
			System.out.println(op + "La operacion no es correcta");
			break;
		}
		
		switch (op2) {
		case "&&":
			rta= rta && rtaAnterior;
			break;					
		case "||":
			rta= rta || rtaAnterior;
			break;
		default:
			break;
		}
		
		return rta;
	}
	
	private void component(String nombre) throws Exception{
		String nom_componente= ApiUi.getProyecto() +  "_" + nombre;
		try{
			URL url;
			HttpURLConnection conn;			
					
			//url= new URL("http://www.edunola.com.ar/serviciosui/componenteDefinition?nombre=" + nombre + "&proyecto=" + ApiUi.getProyecto());
			url = new URL("http://localhost/uiservices/componenteDefinition?nombre=" + nombre + "&proyecto=" + ApiUi.getProyecto());
						
			conn= (HttpURLConnection) url.openConnection();
			String componente= this.conexionComponente(url, conn);
				
			this.getComponentes().put(nom_componente, componente);
		}catch(Exception e){
			this.getComponentes().remove(nom_componente);
			throw e;
		}
	}
	
	private String conexionComponente(URL url, HttpURLConnection conn) throws Exception{
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(10000);
							
		//Hacer la llamado y recibir el InputStream resultante, transformalo a string y devolverlo
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//Analizo la respuesta
		if(conn.getResponseCode() == 200){
			return response.toString();
		}
		else{
			throw new Exception();
		}
	}

	/**
	 * Fin metodo de los componentes
	 */
	
	@SuppressWarnings({ "unused"})
	@Deprecated
	private String conexion(URL url, HttpURLConnection conn, JSONObject json) throws Exception{
		conn.setRequestMethod("POST");
		conn.setConnectTimeout(10000);
		//mando las cookies
		//conn.setRequestProperty("Cookie", cookieHeader);
		
		//Seteo el tipo del contenido
		conn.setRequestProperty("Content-Type", "application/json");

		//Analizo si hay datos y los agrego
		//if(datos != null){
			//especificamos que vamos a escribir
			conn.setDoOutput(true);
			//Obtenemos el flujo de escritura
			OutputStreamWriter wr= new OutputStreamWriter(conn.getOutputStream());
			//escribimos los datos
			wr.write(json.toString());
			//Cerramos la conexion
			wr.close();
		//}
							
		//Hacer la llamado y recibir el InputStream resultante, transformalo a string y devolverlo
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//Analizo la respuesta
		if(conn.getResponseCode() == 200){
			return response.toString();
		}
		else{
			return "error";
		}
	}
	
	private Map<String, String> getComponentes() {
		return componentes;
	}

	private Map<String, List<EstructuraIf>> getCache() {
		return cache;
	}

	public Map<String, String> getThemes() {
		return themes;
	}

	public Map<String, String> getJavaScripts() {
		return javaScripts;
	}

}
