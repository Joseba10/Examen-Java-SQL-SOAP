package com.ipartek.pojo;

public class Consulta {

//Declaracion de variables
	private String nombre;
	private Usuario usuario;
	private int id;
	
	
//Constructor Vacio		
	public Consulta() {
		super();
		
		this.nombre = "";
		this.usuario= new Usuario();
		this.id=-1;
	}
	
//Constructor
	public Consulta(String nombre, Usuario usuario,int id) {
		super();
		this.nombre = nombre;
		this.id=id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Consulta [nombre=" + nombre + ", usuario=" + usuario + ", id=" + id + "]";
	}

	
	
	
}
