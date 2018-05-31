package com.ipartek.pojo;

public class Usuario {

//Declaracion de variables
	private String nombre;
	private String pass;
	private int id;
	
//Constructor Vacio	
	public Usuario() {
		super();
		this.nombre = "";
		this.pass = "";
		this.id=-1;
	}

	
	
//Constructor
	public Usuario(String nombre, String pass, int id) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.id = id;
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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + ", id=" + id + "]";
	}


	
}
