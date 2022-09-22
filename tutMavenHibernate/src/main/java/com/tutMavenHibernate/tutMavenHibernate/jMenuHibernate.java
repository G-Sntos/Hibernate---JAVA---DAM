package com.tutMavenHibernate.tutMavenHibernate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("serial")
public class jMenuHibernate extends JFrame {
	configuracionesHibernate x = new configuracionesHibernate(); //declarar un objeto de mi class configuraciones en global, es mi 
	//intento  de buscar maneras para cortas más mis codigos.
		//Tambien he usado JoptionPane para coger inputs en vez de textfield.
		//con esto no tenia que crear otras JFrame por tarea.
	
	//variables para productos y cliente
	int cantidadDisponible,precioSuperior,telefonoCliente,idArticulo=0;
	String nombreProducto,
	tipoProducto,
	tallaProducto,
	nombreCliente,
	emailCliente;
	
	JButton button1= new JButton();
	JButton button2= new JButton();
	JButton button3= new JButton();
	JButton button4= new JButton();
	JButton button5= new JButton();
	JButton button6= new JButton();
	JButton button7= new JButton();
	
	JButton insertar= new JButton();
	JButton eliminar= new JButton();
	JButton listado= new JButton();
	JButton modificarDatos= new JButton();
	JButton consultaEspeciales= new JButton();
	JButton salirPrograma= new JButton();
	
	JMenu menu;
	JMenuBar menuBar;
	JMenuItem menuItem1,menuItem2;
	
	public jMenuHibernate(){
		//Base frame del menu
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		this.setSize(500, 300);
		this.setTitle("Tienda de Ropas -Machote S.L - HIBERNATE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(167, 175, 200)); // Colombia blue
		//set text buttones
	
		insertar.setText("Insertar Datos");
		eliminar.setText("Eliminar Datos");
		listado.setText("Listado Datos");
		modificarDatos.setText("Modificar Datos");
		consultaEspeciales.setText("Consultas");
		salirPrograma.setText("SALIR");
	
		
		//quitar border
		insertar.setFocusable(false);
		eliminar.setFocusable(false);
		listado.setFocusable(false);
		modificarDatos.setFocusable(false);
		consultaEspeciales.setFocusable(false);
		salirPrograma.setFocusable(false);
	
		//Tamaño butones
	
		insertar.setPreferredSize(new Dimension(200,50));
		eliminar.setPreferredSize(new Dimension(200,50));
		listado.setPreferredSize(new Dimension(200,50));
		modificarDatos.setPreferredSize(new Dimension(200,50));
		consultaEspeciales.setPreferredSize(new Dimension(200,50));
		salirPrograma.setPreferredSize(new Dimension(200,50));
	
		//Menu
		menuBar = new JMenuBar();// iniciar barra de menu
		menu = new JMenu("Informacion");
		menuItem2 = new JMenuItem("INFO");
	
		menu.add(menuItem2);
		menuBar.add(menu);//añadir menu al la barra
		
		//añadir al frame
		
		this.add(insertar);
		this.add(eliminar);
		this.add(listado);
		this.add(modificarDatos);
		this.add(consultaEspeciales);
		this.add(salirPrograma);
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
		
		//acciones
		insertar.addActionListener(e->{
			 insertar();
			 this.dispose();
			
		});
		eliminar.addActionListener(e->{
			eliminarDatos();
			this.dispose();
			
		});
		listado.addActionListener(e->{
			listadoDatos();		
			this.dispose();
		});
		modificarDatos.addActionListener(e->{
			modificarDatos();
			this.dispose();
		});
		consultaEspeciales.addActionListener(e->{
			consultaEspeciales();
			this.dispose();
		
		});
		salirPrograma.addActionListener(e->{
			System.exit(0);
		});
		
		//acciones menuNav
		
		menuItem2.addActionListener(e->{
			JOptionPane.showMessageDialog(null, "Programa para gestionar datos via HIBERNATE","Ropas Machote S.L", JOptionPane.INFORMATION_MESSAGE);
		});
		}

	private void consultaEspeciales() {
		JFrame consultasEspeciales = new JFrame();
		consultasEspeciales.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		consultasEspeciales.setSize(400, 400);
		consultasEspeciales.setTitle("Tienda de Ropas -Machote S.L -HIBERNATE");
		consultasEspeciales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultasEspeciales.setResizable(false);
		consultasEspeciales.getContentPane().setBackground(new Color(105, 182, 188));
		//montar buttones
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		button5.setFocusable(false);
		button6.setFocusable(false);
		button7.setFocusable(false);
		//tamaño buttones
		button1.setPreferredSize(new Dimension(240,30));
		button2.setPreferredSize(new Dimension(240,30));
		button3.setPreferredSize(new Dimension(240,30));
		button4.setPreferredSize(new Dimension(240,30));
		button5.setPreferredSize(new Dimension(240,30));
		button6.setPreferredSize(new Dimension(240,30));
		button7.setPreferredSize(new Dimension(240,30));
		//texto buttones
		button1.setText("MOSTRAR PEDIDOS");
		button2.setText("ARTICULO SUPERIOR ORDEN DE PRECIO");
		button3.setText("ARTICULO INFERIOR ORDEN DE PRECIO");
		button4.setText("PEDIDOS DE UN CLIENTE");
		button5.setText("ARTICULO SUPERIOR EN TOTAL");
		button6.setText("ARTICULO INFERIOR EN TOTAL");
		button7.setText("VOLVER AL MENU");
		//añadir al frame
		consultasEspeciales.add(button1);
		consultasEspeciales.add(button2);
		consultasEspeciales.add(button3);
		consultasEspeciales.add(button4);
		consultasEspeciales.add(button5);
		consultasEspeciales.add(button6);
		consultasEspeciales.add(button7);
		
		button1.addActionListener(h->{
			x.mostrarPedidosConsulta();
		});
		button2.addActionListener(h->{
			x.articuloSuperiorConsulta();
			
		});
		button3.addActionListener(h->{
			x.articuloInferiorConsulta();
		});
		button4.addActionListener(h->{
			try {
			idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
			}catch (InputMismatchException | NumberFormatException | NullPointerException b ) {
				System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
				//va añadir los datos y tendran que empezar de nuevo
				consultasEspeciales.dispose();	
			}
			if(idArticulo != 0)x.pedidoClienteConsulta(idArticulo);
		});
		button5.addActionListener(h->{
			x.cuentaSuperiorConsulta();
		});
		button6.addActionListener(h->{
			x.cuentaInferiorConsulta();
		});
		button7.addActionListener(h->{
			consultasEspeciales.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		consultasEspeciales.setVisible(true);
	}

	private void modificarDatos() {
		JFrame modificar = new JFrame();
		modificar.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		modificar.setSize(400, 250);
		modificar.setTitle("Tienda de Ropas -Machote S.L -HIBERNATE");
		modificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modificar.setResizable(false);
		modificar.getContentPane().setBackground(new Color(105, 182, 188));
		//montar buttones
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		//tamaño buttones
		button1.setPreferredSize(new Dimension(240,30));
		button2.setPreferredSize(new Dimension(240,30));
		button3.setPreferredSize(new Dimension(240,30));
		button4.setPreferredSize(new Dimension(240,30));
		//texto buttones
		button1.setText("Modificar Articulo Superior");
		button2.setText("Modificar Articulo Inferior");
		button3.setText("Modificar Cliente");
		button4.setText("Volver");
		//añadir al frame
		modificar.add(button1);
		modificar.add(button2);
		modificar.add(button3);
		modificar.add(button4);
		//acciones
		button1.addActionListener(h->{
			try {
				idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
				nombreProducto = JOptionPane.showInputDialog("Nombre Articulo: ");
				tipoProducto = JOptionPane.showInputDialog("Tipo Articulo: ");
				tallaProducto = JOptionPane.showInputDialog("Talla Articulo: (S-M-L) ");
				cantidadDisponible =Integer.valueOf( JOptionPane.showInputDialog("Cantidad#: "));
				precioSuperior = Integer.valueOf(JOptionPane.showInputDialog("Precio#: "));
				
				}catch (InputMismatchException | NumberFormatException | NullPointerException b ) {
					System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
					//va añadir los datos y tendran que empezar de nuevo
					modificar.dispose();	
				}
				if(idArticulo != 0) {
					x.articuloSuperiorModificar(idArticulo, nombreProducto, tipoProducto, tallaProducto, cantidadDisponible, precioSuperior);
					
				}else {
					JOptionPane.showMessageDialog(null, "Error","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
				}
			modificar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		button2.addActionListener(h->{
			try {
				idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
				nombreProducto = JOptionPane.showInputDialog("Nombre Articulo: ");
				tipoProducto = JOptionPane.showInputDialog("Tipo Articulo: ");
				tallaProducto = JOptionPane.showInputDialog("Talla Articulo: (S-M-L) ");
				cantidadDisponible =Integer.valueOf( JOptionPane.showInputDialog("Cantidad#: "));
				precioSuperior = Integer.valueOf(JOptionPane.showInputDialog("Precio#: "));
				
				}catch (InputMismatchException | NumberFormatException | NullPointerException b ) {
					System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
					//va añadir los datos y tendran que empezar de nuevo
					modificar.dispose();	
				}
				if(idArticulo != 0) {
					x.articuloInferiorModificar(idArticulo, nombreProducto, tipoProducto, tallaProducto, cantidadDisponible, precioSuperior);
					
				}else {
					JOptionPane.showMessageDialog(null, "Error","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
				}
			modificar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		button3.addActionListener(h->{
			try {
				idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
				nombreCliente = JOptionPane.showInputDialog("Nombre Cliente: ");
				emailCliente= JOptionPane.showInputDialog("Email Cliente: ");
				telefonoCliente =Integer.valueOf( JOptionPane.showInputDialog("Telefono#: "));	
				
				}catch (InputMismatchException | NumberFormatException | NullPointerException b ) {
					System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
					//va añadir los datos y tendran que empezar de nuevo
					modificar.dispose();	
				}
				if(idArticulo != 0) {
					x.clienteModificar(idArticulo, nombreCliente, emailCliente, telefonoCliente);
					
				}else {
					JOptionPane.showMessageDialog(null, "Error","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
				}
			modificar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		
		button4.addActionListener(h->{
			modificar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		modificar.setVisible(true);
	}

	private void listadoDatos() {// menu para ver listado de Base de detos, a traves de consola
		JFrame listado = new JFrame();
		listado.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		listado.setSize(400, 250);
		listado.setTitle("Tienda de Ropas -Machote S.L -HIBERNATE");
		listado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listado.setResizable(false);
		listado.getContentPane().setBackground(new Color(105, 182, 188));
		//montar buttones
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		//tamaño buttones
		button1.setPreferredSize(new Dimension(240,30));
		button2.setPreferredSize(new Dimension(240,30));
		button3.setPreferredSize(new Dimension(240,30));
		button4.setPreferredSize(new Dimension(240,30));
		//texto buttones
		button1.setText("Mostrar Listado Articulo Superior");
		button2.setText("Mostrar Listado Articulo Inferior");
		button3.setText("Mostrar Listado Cliente");
		button4.setText("Volver");
		//añadir al frame
		listado.add(button1);
		listado.add(button2);
		listado.add(button3);
		listado.add(button4);
		
		button1.addActionListener(g->{
			x.articuloSuperiorListado();
		
		});
		button2.addActionListener(g->{
			x.articuloInferiorListado();
		});
		button3.addActionListener(g->{
			x.clientesListado();
		});
		button4.addActionListener(g->{
	
			listado.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		
		listado.setVisible(true);
	}

	private void eliminarDatos() {// menu para borrar datos
		JFrame borrar = new JFrame();
		borrar.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		borrar.setSize(400, 250);
		borrar.setTitle("Tienda de Ropas -Machote S.L -HIBERNATE");
		borrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borrar.setResizable(false);
		borrar.getContentPane().setBackground(new Color(105, 182, 188));
		//montar buttones
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		//tamaño buttones
		button1.setPreferredSize(new Dimension(240,30));
		button2.setPreferredSize(new Dimension(240,30));
		button3.setPreferredSize(new Dimension(240,30));
		button4.setPreferredSize(new Dimension(240,30));
		//texto buttones
		button1.setText("Borrar Articulo Superior");
		button2.setText("Borrar Articulo Inferior");
		button3.setText("Borrar Cliente");
		button4.setText("Volver");
		//añadir al frame
		borrar.add(button1);
		borrar.add(button2);
		borrar.add(button3);
		borrar.add(button4);
		//acciones
		button1.addActionListener(f->{
			try {
				idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
			System.out.println(idArticulo);
			}catch (InputMismatchException | NumberFormatException | NullPointerException b ) {
				System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
				//va añadir los datos y tendran que empezar de nuevo
				borrar.dispose();	
			}
			if(idArticulo != 0) {
				x.articuloSuperiorBorrar(idArticulo);
			}else {
				JOptionPane.showMessageDialog(null, "Error","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
			}
			
			borrar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		button2.addActionListener(f->{
			try {
				idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
				}catch (InputMismatchException | NumberFormatException | NullPointerException b) {
					System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
					//va añadir los datos y tendran que empezar de nuevo
					borrar.dispose();	
				}
			if(idArticulo != 0) {
				x.articuloInferiorBorrar(idArticulo);
			}else {
				JOptionPane.showMessageDialog(null, "Error","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
			}
				
			borrar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		button3.addActionListener(f->{
			try {
				idArticulo = Integer.valueOf(JOptionPane.showInputDialog("ID#: "));
				}catch (InputMismatchException | NumberFormatException | NullPointerException b) {
					System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
					//va añadir los datos y tendran que empezar de nuevo
					borrar.dispose();	
				}
			if(idArticulo != 0) {
				x.clientesBorrar(idArticulo);
			}else {
				JOptionPane.showMessageDialog(null, "Error","Ropas Machote S.L", JOptionPane.WARNING_MESSAGE);
			}
			
			borrar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		button4.addActionListener(f->{
			borrar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		borrar.setVisible(true);
		
	}

	private void insertar() { //menu de insertar datos
		JFrame insertar = new JFrame();
		insertar.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		insertar.setSize(400, 250);
		insertar.setTitle("Tienda de Ropas -Machote S.L -HIBERNATE");
		insertar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertar.setResizable(false);
		insertar.getContentPane().setBackground(new Color(105, 182, 188));
		//montar buttones
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		button4.setFocusable(false);
		//tamaño buttones
		button1.setPreferredSize(new Dimension(240,30));
		button2.setPreferredSize(new Dimension(240,30));
		button3.setPreferredSize(new Dimension(240,30));
		button4.setPreferredSize(new Dimension(240,30));
		//texto buttones
		button1.setText("Insertar Articulo Superior");
		button2.setText("Insertar Articulo Inferior");
		button3.setText("Insertar Cliente");
		button4.setText("Volver");
		//añadir al frame
		insertar.add(button1);
		insertar.add(button2);
		insertar.add(button3);
		insertar.add(button4);
		
		button1.addActionListener(e->{ //insertar articuloSuperior
			try {
						nombreProducto = JOptionPane.showInputDialog("Nombre Articulo: ");
						tipoProducto = JOptionPane.showInputDialog("Tipo Articulo: ");
						tallaProducto = JOptionPane.showInputDialog("Talla Articulo: (S-M-L) ");
						cantidadDisponible =Integer.valueOf( JOptionPane.showInputDialog("Cantidad#: "));
						precioSuperior = Integer.valueOf(JOptionPane.showInputDialog("Precio#: "));
					
			}catch (InputMismatchException | NumberFormatException | NullPointerException b) {
				System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
				//va añadir los datos y tendran que empezar de nuevo
				insertar.dispose();
				
				}
			
			x.confiArticuloSuperiorInsertar(nombreProducto, tipoProducto, tallaProducto, cantidadDisponible, precioSuperior);
			insertar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
			
		});
		button2.addActionListener(e->{ // insertar articuloInferior
			try {
				nombreProducto = JOptionPane.showInputDialog("Nombre Articulo: ");
				tipoProducto = JOptionPane.showInputDialog("Tipo Articulo: ");
				tallaProducto = JOptionPane.showInputDialog("Talla Articulo: (S-M-L) ");
				cantidadDisponible =Integer.valueOf( JOptionPane.showInputDialog("Cantidad#: "));
				precioSuperior = Integer.valueOf(JOptionPane.showInputDialog("Precio#: "));
			
	}catch (InputMismatchException | NumberFormatException | NullPointerException b) {
		System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
		//va añadir los datos y tendran que empezar de nuevo
		insertar.dispose();
		
		}
	
			x.confiArticuloInferior(nombreProducto, tipoProducto, tallaProducto, cantidadDisponible, precioSuperior);
			insertar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		
		button3.addActionListener(e->{//insertar cliente
			String fAlta = String.valueOf(java.time.LocalDate.now());
			try {
				nombreCliente = JOptionPane.showInputDialog("Nombre Cliente: ");
				emailCliente= JOptionPane.showInputDialog("Email Cliente: ");
				telefonoCliente =Integer.valueOf( JOptionPane.showInputDialog("Telefono#: "));			
			}catch (InputMismatchException | NumberFormatException | NullPointerException b) {
		System.out.println(b);//acaso que ponen algo mas que un numero o dejar un variable vacio no se 
		//va añadir los datos y tendran que empezar de nuevo
		insertar.dispose();
		
		}
			x.confiClientes(nombreCliente, emailCliente, telefonoCliente, fAlta);
			insertar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		button4.addActionListener(e->{//volver menu principal
			insertar.dispose();
			jMenuHibernate menuPrincipal = new jMenuHibernate();
		});
		insertar.setVisible(true);
		//set text buttones
		
	}
	
	
}

