package com.ipartek.pojo;

public class Usuario {

//Declaracion de variables
	private String nombre;
	private String pass;
	
//Constructor Vacio	
	public Usuario() {
		super();
		this.nombre = "";
		this.pass = "";
	}
	
//Constructor
	public Usuario(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
	}

//Getter y Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "Usuario [ nombre=" + nombre + ", pass=" + pass + "]";
	}

	
}
