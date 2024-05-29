package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pedido;
import com.curso.model.Producto;
import com.curso.service.PedidosService;
import com.curso.service.ProductosService;

@RestController
public class ProductoController {
	@Autowired
	ProductosService service;
	
	@Autowired
	PedidosService servicePedidos;
	
	//Actualizar el stock del producto mediante parámetros en URL
	@PutMapping(value="producto/{codigo}/{stockNuevo}")
	void updateStock(@PathVariable("codigo") int codigo, @PathVariable("stockNuevo") int stockNuevo){
		service.updateStock(codigo, stockNuevo);
	}
	
	//Lista de productos existentes en el almacen (return list)
	@GetMapping(value="almacen", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> almacen(){
		return service.almacen();
	}
	
	//Obtener el precio de un producto específico (return int)
	@GetMapping(value="producto/{codigo}", produces= MediaType.APPLICATION_JSON_VALUE)
	public int mostrarPvp(@PathVariable("codigo") int codigo){
		return service.mostrarPvp(codigo);
	}
	
	//Añadir producto nuevo desde body (JSON)
	@PostMapping(value="producto", consumes= MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> addProducto(@RequestBody Producto p){
		return service.addProducto(p);
	}
	
	//Lista de limites de precio según el tipo de producto (esquema)
	@GetMapping(value="almacen/precios", produces= MediaType.APPLICATION_JSON_VALUE)
	public String limitePrecios(){
		return service.limitePrecios();
	}
	
	
	//Lista de pedidos existentes (Si no hay, devuelve null)
	@GetMapping(value="pedidos", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos(){
		return servicePedidos.pedidos();
	}
	
	//Añadir pedido nuevo desde body (JSON)
	@PostMapping(value="pedido", consumes= MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> addPedido(@RequestBody Pedido p){
		return servicePedidos.addPedido(p);
	}
}
