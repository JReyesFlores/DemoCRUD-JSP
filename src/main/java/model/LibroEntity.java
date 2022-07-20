package model;

import java.util.Date; 

public class LibroEntity {
	private int Id;
	private String NombreLibro;
	private String Autor;
	private int AnioPublicacion;
	private Date Fecha;

	public LibroEntity(int id, String nombreLibro, String autor, int anioPublicacion, Date fecha) {
		this.Id = id;
		this.NombreLibro = nombreLibro;
		this.Autor = autor;
		this.AnioPublicacion = anioPublicacion;
		this.Fecha = fecha;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getNombreLibro() {
		return NombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		NombreLibro = nombreLibro;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public int getAnioPublicacion() {
		return AnioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		AnioPublicacion = anioPublicacion;
	}

	public int getId() {
		return Id;
	}
}
