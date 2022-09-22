package com.tutMavenHibernate.tutMavenHibernate;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.cj.exceptions.MysqlErrorNumbers;

public class configuracionesHibernate {
	
	private int articuloSuperiorCuenta = 0;
	private int articuloInferiorCuenta = 0;
	private int numeroDeClientes = 0;
	public configuracionesHibernate() {
	}
	public configuracionesHibernate(int articuloSuperiorCuenta, int articuloInferiorCuenta, int numeroDeClientes) {
		super();
		this.articuloSuperiorCuenta = articuloSuperiorCuenta;
		this.articuloInferiorCuenta = articuloInferiorCuenta;
		this.numeroDeClientes = numeroDeClientes;
	}
	public int getArticuloSuperiorCuenta() {
		return articuloSuperiorCuenta;
	}
	public void setArticuloSuperiorCuenta(int articuloSuperiorCuenta) {
		this.articuloSuperiorCuenta = articuloSuperiorCuenta;
	}
	public int getArticuloInferiorCuenta() {
		return articuloInferiorCuenta;
	}
	public void setArticuloInferiorCuenta(int articuloInferiorCuenta) {
		this.articuloInferiorCuenta = articuloInferiorCuenta;
	}
	public int getNumeroDeClientes() {
		return numeroDeClientes;
	}
	public void setNumeroDeClientes(int numeroDeClientes) {
		this.numeroDeClientes = numeroDeClientes;
	}
	
	//classe para acceder cada tabla con su propia confi -- Insertar datos
	//Montar Configuracion a la tabla que quiero modificar
	//Montar el session factory con el configuracion
	//Hacer un session con el session factory y abrir session
	//Crear un objeto del classe usando el constructor, los argumentos seran los inputs del usuario
	//usar session.save para guardar el objeto (fila), el PK tiene un AUTO INCREMENT, por eso no lo puse en el constructor.
	//comiter el cambio.
	//cerrar session.
	public void confiArticuloSuperiorInsertar(String nombreProducto, String tipoProducto, String tallaProducto,
			int cantidadDisponible, int precioSuperior) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(parteSuperior.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        parteSuperior articuloNuevo = new parteSuperior(nombreProducto, tipoProducto,tallaProducto,cantidadDisponible, precioSuperior);
        session.save(articuloNuevo); // para guardar datos
        tx.commit();// commitir cambio
        session.detach(articuloNuevo);// para librar el cache
        if(session.find(parteSuperior.class, articuloSuperiorCuenta) != null) {
        	articuloSuperiorCuenta++;
        	JOptionPane.showMessageDialog(null, "Datos Insertado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        }
        session.close();// cerrar session
      
	}
	public void confiArticuloInferior(String nombreProducto, String tipoProducto, String tallaProducto,
			int cantidadDisponible, int precioSuperior) {
	
		Configuration con = new Configuration().configure().addAnnotatedClass(parteInferior.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        parteInferior articuloNuevo = new parteInferior(nombreProducto, tipoProducto,tallaProducto,cantidadDisponible, precioSuperior);
        session.save(articuloNuevo);
        tx.commit();
        session.detach(articuloNuevo);
        if(session.find(parteInferior.class, articuloInferiorCuenta) != null) {
        	JOptionPane.showMessageDialog(null, "Datos Insertado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        	articuloInferiorCuenta++;
        }
        session.close();// cerrar session
       
	}    
	public void confiClientes(String nombre, String email, int telefono, String fechaAlta) {

		Configuration con = new Configuration().configure().addAnnotatedClass(clientes.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        clientes nuevoCliente = new clientes(nombre, email, telefono, fechaAlta);
        session.save(nuevoCliente);
        tx.commit();
        session.detach(nuevoCliente);
        if(session.find(clientes.class, numeroDeClientes) != null) {
        	JOptionPane.showMessageDialog(null, "Datos Insertado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        	numeroDeClientes++;
        }
        session.close();
       
       	}   
	
	//Montar Configuracion a la tabla que quiero modificar
	//Montar el session factory con el configuracion
	//Hacer un session con el session factory y abrir session
	//Crear un transaccion , crear un objeto que pertenece a la misma class del config
	//Modificar el PK del dicho objeto usando el parametro que vendra desde el input del usuario
	//Usar el session.delete(), se va borrar el row con el mismo PK.
	//Commiter el transaccion y cerrar el session.
	
	public void articuloSuperiorBorrar(int idArticulo) {

		Configuration con = new Configuration().configure().addAnnotatedClass(parteSuperior.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //insertar codigo aqui
        parteSuperior articuloNuevo = new parteSuperior();
        articuloNuevo.setIdArticuloParteSuperior(idArticulo);
        session.delete(articuloNuevo);
        articuloSuperiorCuenta--;
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Dato Borrado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        
	}
	public void articuloInferiorBorrar(int idArticulo) {

		Configuration con = new Configuration().configure().addAnnotatedClass(parteInferior.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //insertar codigo aqui
        parteInferior articuloNuevo = new parteInferior();
        articuloNuevo.setIdArticuloParteInferior(idArticulo);
        session.delete(articuloNuevo);
        articuloInferiorCuenta--;
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Dato Borrado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        
	}
	public void clientesBorrar(int idCliente) {

		Configuration con = new Configuration().configure().addAnnotatedClass(clientes.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //insertar codigo aqui
        clientes cliente = new clientes();
        cliente.setIdCliente(idCliente);
        session.delete(cliente);
        numeroDeClientes--;
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Dato Borrado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        
	}
	//Montar Configuracion a la tabla que quiero modificar
	//Montar el session factory con el configuracion
	//Hacer un session con el session factory y abrir session
	//Crear un objeto query y usar HQL
	//Basicamente, recoger todo los datos que el PK vale más que 0, como tengo AI en mis tablas. Solo pueden tener un PK más que 0.
	//el Query.list, devuelve el toString() que tengo en cada class(tabla),
	public void articuloInferiorListado() {

		Configuration con = new Configuration().configure().addAnnotatedClass(parteInferior.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from parteInferior where idArticuloInferior>0");
        List<parteInferior> articulosInferior = q.list();
        for(parteInferior a : articulosInferior) {
        	System.out.println(a);       	
        }  
        tx.commit();
        session.close();
	}
	public void articuloSuperiorListado() {
		Configuration con = new Configuration().configure().addAnnotatedClass(parteSuperior.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from parteSuperior where idArticuloSuperior>0");
        List<parteSuperior> articulosSuperior= q.list();
        for(parteSuperior a : articulosSuperior) {
        	System.out.println(a);
        }  
        tx.commit();
        session.close();
	}
	public void clientesListado() {
		Configuration con = new Configuration().configure().addAnnotatedClass(clientes.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from clientes where idCliente>0");
        List<clientes> clientes = q.list();
        for(clientes a : clientes) {
        	System.out.println(a);
        }
        tx.commit();
        session.close();
	}
	//Configuraciones para modificar datos
	//Tuve pensado re-usar los metodos en forma de borrar el objeto y re-insertar lo de nuevo usando el mismo 
	//funcion para insertar objetos. Pero quiza no es lo que pide el ejercicio.
	//por eso hice estos funciones para modificar datos.
	//session.merge modifica el mismo objeto en el entidad que tiene el mismo ID(PK).
	public void articuloSuperiorModificar(int PKDato,String nombreProducto, String tipoProducto, String tallaProducto,
			int cantidadDisponible, int precioSuperior) {
		Configuration con = new Configuration().configure().addAnnotatedClass(parteSuperior.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        parteSuperior articuloModificar = new parteSuperior();
        articuloModificar.setIdArticuloParteSuperior(PKDato);
        articuloModificar.setNombreProducto(nombreProducto);
        articuloModificar.setTipoProducto(tipoProducto);
        articuloModificar.setTallaProducto(tallaProducto);
        articuloModificar.setCantidadDisponible(cantidadDisponible);
        articuloModificar.setPrecioSuperior(precioSuperior);
        try {
        session.merge(articuloModificar);
        }catch (SessionException | HibernateError e) {
        	JOptionPane.showMessageDialog(null, "Error,Mirar consola!","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
        	System.out.println(e);
		}
        JOptionPane.showMessageDialog(null, "Datos Modificado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        tx.commit();
        session.close(); 
	}
	public void articuloInferiorModificar(int PKDato,String nombreProducto, String tipoProducto, String tallaProducto,
			int cantidadDisponible, int precioSuperior) {
		Configuration con = new Configuration().configure().addAnnotatedClass(parteInferior.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        parteInferior articuloModificar = new parteInferior();
        articuloModificar.setIdArticuloParteInferior(PKDato);
        articuloModificar.setNombreProducto(nombreProducto);
        articuloModificar.setTipoProducto(tipoProducto);
        articuloModificar.setTallaProducto(tallaProducto);
        articuloModificar.setCantidadDisponible(cantidadDisponible);
        articuloModificar.setPrecioInferior(precioSuperior);
        try {
        session.merge(articuloModificar);
        }catch (SessionException | HibernateError e) {
        	JOptionPane.showMessageDialog(null, "Error,Mirar consola!","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
        	System.out.println(e);
		}
        JOptionPane.showMessageDialog(null, "Datos Modificado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        tx.commit();
        session.close(); 
	}
	public void clienteModificar(int PKDato,String nombre, String email, int telefono) {
		Configuration con = new Configuration().configure().addAnnotatedClass(clientes.class);
        SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        clientes clientesModificar = new clientes();
        clientesModificar.setIdCliente(PKDato);
        clientesModificar.setNombre(nombre);
        clientesModificar.setEmail(email);
        clientesModificar.setTelefono(telefono);
        try {
        session.merge(clientesModificar);
        }catch (SessionException | HibernateError e) {
        	JOptionPane.showMessageDialog(null, "Error,Mirar consola!","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
        	System.out.println(e);
		}
        JOptionPane.showMessageDialog(null, "Datos Modificado!","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
        tx.commit();
        session.close(); 
	}
	
	//Funciones de consultas especiales. Usando HQL y imprime por consola.
	public void mostrarPedidosConsulta() {
		Configuration con = new Configuration().configure().addAnnotatedClass(pedidos.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from pedidos where idPedido>0");
	    List<pedidos> listaPedidos = q.list();
	    for(pedidos a : listaPedidos) {
        	System.out.println(a);       	
        }  
        tx.commit();
        session.close();
	}
	public void articuloSuperiorConsulta() {
		Configuration con = new Configuration().configure().addAnnotatedClass(parteSuperior.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from parteSuperior order by precioSuperior desc");
	    List<parteSuperior> articuloSuperior= q.list();
	    for(parteSuperior a : articuloSuperior) {
        	System.out.println(a);       	
        }  
        tx.commit();
        session.close();
	}
	public void articuloInferiorConsulta() {

		Configuration con = new Configuration().configure().addAnnotatedClass(parteInferior.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from parteInferior order by precioInferior desc");
	    List<parteInferior> articuloInferior= q.list();
	    for(parteInferior a : articuloInferior) {
        	System.out.println(a);       	
        }  
        tx.commit();
        session.close();
	}
	public void pedidoClienteConsulta(int idPedido) {

		Configuration con = new Configuration().configure().addAnnotatedClass(pedidos.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("from pedidos where idCliente="+idPedido);
	    List<pedidos> pedidoCliente= q.list();
	    for(pedidos a : pedidoCliente) {
        	System.out.println(a);       	
        }  
        tx.commit();
        session.close();
	}
	public void cuentaInferiorConsulta() {

		Configuration con = new Configuration().configure().addAnnotatedClass(parteInferior.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("select  count(idArticuloInferior) as numeroArticulo from parteInferior");
	    Object articuloInferior= q.getSingleResult();
        System.out.println(articuloInferior);       	
        tx.commit();
        session.close();
	}
	public void cuentaSuperiorConsulta() {
		Configuration con = new Configuration().configure().addAnnotatedClass(parteSuperior.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createQuery("select  count(idArticuloSuperior) as numeroArticulo from parteSuperior");
	    Object articuloSuperior= q.getSingleResult();
        System.out.println(articuloSuperior);       	
        tx.commit();
        session.close();
	}
}	
