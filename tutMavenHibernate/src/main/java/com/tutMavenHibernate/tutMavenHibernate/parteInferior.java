package com.tutMavenHibernate.tutMavenHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class parteInferior {
	@Id
	private int idArticuloInferior;
	private String nombreProducto;
	private String tipoProducto;
	private String tallaProducto;
	private int cantidadDisponible;
	private int precioInferior;
	
	public parteInferior() {
		// TODO Auto-generated constructor stub
	}
	
	public parteInferior(String nombreProducto, String tipoProducto,
			String tallaProducto, int cantidadDisponible, int precioInferior) {
		super();
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.tallaProducto = tallaProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.precioInferior = precioInferior;
	}
	public int getIdArticuloParteInferior() {
		return idArticuloInferior;
	}
	public void setIdArticuloParteInferior(int idArticuloParteInferior) {
		this.idArticuloInferior = idArticuloParteInferior;
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
	public int getPrecioInferior() {
		return precioInferior;
	}
	public void setPrecioInferior(int precioInferior) {
		this.precioInferior = precioInferior;
	}

	@Override
	public String toString() {
		return "parteInferior [idArticuloInferior=" + idArticuloInferior + ", nombreProducto=" + nombreProducto
				+ ", tipoProducto=" + tipoProducto + ", tallaProducto=" + tallaProducto + ", cantidadDisponible="
				+ cantidadDisponible + ", precioInferior=" + precioInferior + "]";
	}
	

}
