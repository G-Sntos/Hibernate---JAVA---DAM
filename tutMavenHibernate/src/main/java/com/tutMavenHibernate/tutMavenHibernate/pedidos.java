package com.tutMavenHibernate.tutMavenHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pedidos {
	@Id
	private int idPedido;
	private int idCliente;
	private int articuloSuperior;
	private int articuloInferior;
	private int precioTotal;
	private int fechaCompra;
	
	public pedidos() {
		// TODO Auto-generated constructor stub
	}
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(int fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	@Override
	public String toString() {
		return "pedidos [idPedido=" + idPedido + ", idCliente=" + idCliente + ", articuloSuperior=" + articuloSuperior
				+ ", articuloInferior=" + articuloInferior + ", precioTotal=" + precioTotal + ", fechaCompra="
				+ fechaCompra + "]";
	}
	
	
}
