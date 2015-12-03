package es.uc3m.tiw.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {

	
	private Integer edad;
	private String nombre;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(Integer edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Usuario [" + (edad != null ? "edad=" + edad + ", " : "")
				+ (nombre != null ? "nombre=" + nombre : "") + "]";
	}

}
