package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LIBROS database table.
 * 
 */
@Entity
@Table(name="LIBROS")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;
	private String titulo;
	private String autor;

	@Column(name="PRECIO_UNITARIO")
	private BigDecimal precioUnitario;

	private int stock;

	

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="ID_TEMA")
	private Tema tema;

	public Libro() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal d) {
		this.precioUnitario = d;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int i) {
		this.stock = i;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema2) {
		this.tema = tema2;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", precioUnitario=" + precioUnitario
				+ ", stock=" + stock + ", tema=" + tema + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	
}