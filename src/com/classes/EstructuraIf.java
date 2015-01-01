package com.classes;

import java.util.ArrayList;
import java.util.List;

public class EstructuraIf {
	private String tipo;
	private int posInicio;
	private int posFin;
	private List<EstructuraIf> hijos= new ArrayList<EstructuraIf>();
	
	public EstructuraIf(){
		
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPosInicio() {
		return posInicio;
	}

	public void setPosInicio(int posInicio) {
		this.posInicio = posInicio;
	}

	public int getPosFin() {
		return posFin;
	}

	public void setPosFin(int posFin) {
		this.posFin = posFin;
	}

	public List<EstructuraIf> getHijos() {
		return hijos;
	}

	public void setHijos(List<EstructuraIf> hijos) {
		this.hijos = hijos;
	}
	
	
}
