package com.curso.dominio;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario implements Serializable{
	private static final long serialVersionUID = 1L;
	//Señalar a la clave primaria --> id
	@Id
	public String id;
	public String texto;
	public String autor;
	
	@ManyToOne
	@JoinColumn(name="titulo_noticia")
	//Carnalidad --> Una noticia tiene muchos comentarios, un comentario solo pertenece a una noticia.
	private Noticia noticia;
	
	
	//constructor vacío
	public Comentario() {
	}
	
	
	//constructor
	public Comentario(String id, String texto, String autor) {
		super();
		this.id = id;
		this.texto = texto;
		this.autor = autor;
	}
	
	
	//get&set	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
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
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", autor=" + autor + ", noticia=" + noticia + "]";
	}


}
