package com.curso.service;

import java.util.List;


import com.curso.model.Producto;

public interface ProductosService {
	
	List<Producto> almacen(); //GET
	List<Producto> addProducto(Producto p); //POST (RequestBody)
	void updateStock(int codigo, int stockNuevo); //PUT
	int mostrarPvp(int codigo); //GET
	String limitePrecios();

}
