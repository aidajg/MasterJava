package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidosService {

	List<Pedido> pedidos(); //GET
	List<Pedido> addPedido(Pedido p); //POST (RequestBody)
	
}
