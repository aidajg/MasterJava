package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Pedido;
import com.curso.model.Producto;
import com.curso.model.Tipo;

@Service
public class ProductosServiceImpl implements ProductosService, PedidosService {

	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8000/"; // url para el primer microservicio (productos)

	// mi lista de productos
	List<Producto> almacen;

	// mi lista de pedidos
	List<Pedido> pedidos;

	public ProductosServiceImpl() {
		almacen = new ArrayList<>();
		// Crear el almacen con los productos (prescindir uso de bd)
		almacen.add(new Producto(1, "mesa", 15, false, Tipo.MUEBLE, 250));
		almacen.add(new Producto(2, "sofá", 10, false, Tipo.MUEBLE, 450));
		almacen.add(new Producto(3, "lavadora", 8, true, Tipo.ELECTRODOMÉSTICO, 1200));
		almacen.add(new Producto(4, "cafetera", 4, true, Tipo.ELECTRODOMÉSTICO, 900));
		almacen.add(new Producto(5, "portátil", 30, true, Tipo.TECNOLÓGICO, 1900));
		almacen.add(new Producto(6, "auriculares", 22, false, Tipo.TECNOLÓGICO, 20));
		almacen.add(new Producto(7, "vestido", 12, false, Tipo.TÉXTIL, 50));
		almacen.add(new Producto(8, "bolso de diseñador", 6, false, Tipo.TÉXTIL, 80));
		almacen.add(new Producto(9, "Máquina press banca", 12, false, Tipo.DEPORTE, 1890));
		almacen.add(new Producto(10, "Rack para sentadilla", 23, false, Tipo.DEPORTE, 1780));
	
		pedidos = new ArrayList<>();
		pedidos.add(new Pedido("mesa", 5, Tipo.MUEBLE, 250));
	}

	// Agregar un nuevo producto (sin REST - url)
	@Override
	public List<Producto> addProducto(Producto p) {
		Tipo t = p.getTipo(); // tipo del producto

		// Comprobar que el pvp establecido en el nuevo producto entre dentro de los
		// límites
		try {
			if (p.getPvp() > t.getPvpMinimo() & p.getPvp() < t.getPvpMaximo()) {
				almacen.add(p);
				return almacen;
			}
			// Si no cumple los límites, simplemente no se añade
		} catch (Exception e) {
			e.printStackTrace();
		}

		return almacen;
	}

	// Lista de productos existentes
	@Override
	public List<Producto> almacen() {
		return almacen;
	}

	// Actualizar el stock del producto
	@Override
	public void updateStock(int codigo, int stockNuevo) {
		for (Producto p : almacen) {
			if (p.getCodigo() == codigo) {
				p.setStock(stockNuevo);
				break;
			}
		}
	}

	// Obtener el precio de un producto por su ID
	@Override
	public int mostrarPvp(int codigo) {
		for (Producto p : almacen) {
			if (p.getCodigo() == codigo) {
				return p.getPvp();
			}
		}

		return codigo;
	}

	// Obtener el toString() de Productos donde se esquematiza los límites de precio según el Tipo
	@Override
	public String limitePrecios() {
		return almacen.toString();
	}

	// Obtener una lista de pedidos realizados
	@Override
	public List<Pedido> pedidos() {
		return pedidos;
	}

	/**
	 * Hacer un pedido de un producto existente
	 * - El producto debe existir en el almacén
	 * - Debe tener suficiente stock para hacer el pedido
	 * + Restar el stock del producto cuando se haga un pedido
	 */
	@Override
	public List<Pedido> addPedido(Pedido p) {
		for (Producto producto : almacen) {
			//Si el producto existe (nombre) y su stock es suficiente, se puede comprar
				if (producto.getNombre().equals(p.getNombre()) && producto.getStock() > p.getStock()) {
					int stockActualizado = producto.getStock() - p.getStock();
					//llamada al servicio de productos para actualizar el stock
					updateStock(producto.getCodigo(), stockActualizado);
					pedidos.add(p);
					break;
					
					//Si el stock del producto llega a cero, se quita del almacen
				}else if(producto.getNombre().equals(p.getNombre()) && producto.getStock() == p.getStock() ) {
					almacen.remove(producto);
					pedidos.add(p);
					break;
				}
		}
		return pedidos;
	}

}
