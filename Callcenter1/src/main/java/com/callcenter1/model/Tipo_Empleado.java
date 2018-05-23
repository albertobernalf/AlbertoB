package com.callcenter1.model;


// Clase donde se define el tipo de Empleado (Director/Supervisor/Operario) . Estado(L=Libre / O = Ocupado)
// Prioridad : 3 = Operario / 2 = Supervisor / 1= Directos

public class Tipo_Empleado {
	
	String Tipo;
	String Estado;
	Integer Prioridad;
	
	public Tipo_Empleado(String tipo, String estado, Integer prioridad) {
		super();
		Tipo = tipo;
		Estado = estado;
		Prioridad = prioridad;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Integer getPrioridad() {
		return Prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		Prioridad = prioridad;
	}
	
	public int compareTo(Tipo_Empleado ob) {
		return Tipo.compareTo(ob.getTipo());
	}
	
}
