package com.curso.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String texto;
	private String autor;
	
	/**
	 * Establecer la cardinalidad
	 * Establecer forma de obtener resultados en fetch 
	 * Carga LAZY
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="noticia_titulo")
	private Noticia noticia;
	
	
	//constructor con clave primaria
	public Comentario(int id) {
		super();
		this.id = id;
	}


	//constructor vacío
	public Comentario() {
		super();
	}
	
	
	public Comentario(String texto, String autor, Noticia noticia) {
		super();
		this.texto = texto;
		this.autor = autor;
		this.noticia = noticia;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, id, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(autor, other.autor) && id == other.id && Objects.equals(texto, other.texto);
	}
	

	
}
