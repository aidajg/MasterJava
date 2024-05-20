package com.cursojava.service;

import java.util.List;

import com.cursojava.model.Perfil;

public class ValidacionService {
	List<Perfil> perfiles = List.of(new Perfil("admin", "1234", "admin@gmail.com", 25),
			new Perfil("user",  "4321", "user@gmail.com", 48), new Perfil("user",  "1234", "user@gmail.com", 22),new Perfil("operador",  "1234", "oper@gmail.com", 31),
			new Perfil("main",  "1234","main@gmail.com", 41));

	public Perfil autenticar(String nombre, String pass) {
		return perfiles.stream()
				.filter(x -> x.getNombre().equals(nombre) && x.getPassword().equals(pass)).findFirst().orElse(null);
}

}