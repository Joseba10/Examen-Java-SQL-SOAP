package com.ipartek.pojo;

import java.util.Date;

public class Consulta {

//Declaracion de variables
	private String nombre;
	private Usuario usuario;
	
	
//Constructor Vacio		
	public Consulta() {
		super();
		
		this.nombre = "";
		this.usuario= new Usuario();
	}
	
//Constructor
	public Consulta(String nombre, Usuario usuario) {
		super();
		this.nombre = nombre;
		
		this.usuario = usuario;
	}

//Getter y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Consulta [nombre=" + nombre + ", usuario=" + usuario + "]";
	}
	
}
