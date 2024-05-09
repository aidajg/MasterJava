package com.curso.servicio;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.Producto;

public class TiendaOnline {
	
	private ArrayList<Producto> productos = new ArrayList<>();
	
	public TiendaOnline(){
		this.productos = new ArrayList<>();
		
		this.productos.add(new Producto("Magdalenas", "alimentacion", 3.99, 5));
		this.productos.add(new Producto("Agua sin Gas", "alimentacion", 2.50, 2));
		this.productos.add(new Producto("iPhone", "electronica", 1200.99, 7));
		this.productos.add(new Producto("Guitarra", "musica", 650.20, 2));
		this.productos.add(new Producto("Saxofon", "musica", 464.65, 4));
		this.productos.add(new Producto("Bicicleta", "deporte", 320.13, 15));
		this.productos.add(new Producto("Pesas", "deporte", 70.50, 20));
		this.productos.add(new Producto("Cinta elastica", "deporte", 25.40, 12));
		
	}
	
	//Añadir producto
	public String agregarProducto(List<Producto> nuevos){
		try {
			if(nuevos != null) {
			this.productos.addAll(nuevos);
			return "<p>[Producto agregado]</p>";
			}else {
				return "<p>Error en agregarProducto(nuevos es nulo)</p>";
			}
		}catch(Exception e ) {
			e.printStackTrace();
			return "<p>[No se pudo agregar el producto]</p>";
		}
	}
	
	//Método para listar todos los productos
	public List<Producto> listarTodos(){
		return this.productos;
	}
	
}//clase