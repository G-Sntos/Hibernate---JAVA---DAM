package com.tutMavenHibernate.tutMavenHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class clientes {
	@Id
	private int idCliente;
	private String nombre;
	private String email;
	private int telefono;
	private String fechaAlta;

	public clientes() {
		// TODO Auto-generated constructor stub
	}
	
	
	public clientes( String nombre, String email, int telefono, String fechaAlta) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaAlta = fechaAlta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	@Override
	public String toString() {
		return "clientes [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", fechaAlta=" + fechaAlta + "]";
	}
	
}
