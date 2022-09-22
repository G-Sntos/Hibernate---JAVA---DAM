package com.tutMavenHibernate.tutMavenHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
//@Entity (name="nombre_tabla") - acaso que quiero usar otra nombre en vez de lo que es el class
//@Table(name="nombre_tabla") - otra forma
@Entity
public class parteSuperior {
	@Id //especificar el primaryKey
	private int idArticuloSuperior;
//	@Column(name="nombre_columna") para customizar el nombre de la col
//	@Transient - para esconder nombre de columna
	private String nombreProducto;
	private String tipoProducto;
	private String tallaProducto;
	private int cantidadDisponible;
	private int precioSuperior;
	public parteSuperior() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public parteSuperior(String nombreProducto, String tipoProducto, String tallaProducto,
			int cantidadDisponible, int precioSuperior) {
		super();
		
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.tallaProducto = tallaProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.precioSuperior = precioSuperior;
	}



	public int getIdArticuloParteSuperior() {
		return idArticuloSuperior;
	}
	public void setIdArticuloParteSuperior(int idArticuloSuperior) {
		this.idArticuloSuperior = idArticuloSuperior;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getTallaProducto() {
		return tallaProducto;
	}
	public void setTallaProducto(String tallaProducto) {
		this.tallaProducto = tallaProducto;
	}
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	public int getPrecioSuperior() {
		return precioSuperior;
	}
	public void setPrecioSuperior(int precioSuperior) {
		this.precioSuperior = precioSuperior;
	}



	@Override
	public String toString() {
		return "parteSuperior [idArticuloSuperior=" + idArticuloSuperior + ", nombreProducto=" + nombreProducto
				+ ", tipoProducto=" + tipoProducto + ", tallaProducto=" + tallaProducto + ", cantidadDisponible="
				+ cantidadDisponible + ", precioSuperior=" + precioSuperior + "]";
	}
	
	

}
