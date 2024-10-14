package edu.Dtos;

public class ClubDto {

	private long idClub;
	private String nombre;
	private String colores;
	private String codigo_acceso;
	
	
	public long getIdClub() {
		return idClub;
	}
	public void setIdClub(long idClub) {
		this.idClub = idClub;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColores() {
		return colores;
	}
	public void setColores(String colores) {
		this.colores = colores;
	}
	public String getCodigo_acceso() {
		return codigo_acceso;
	}
	public void setCodigo_acceso(String codigo_acceso) {
		this.codigo_acceso = codigo_acceso;
	}
	
	public ClubDto(long idClub, String nombre, String colores, String codigo_acceso) {
		super();
		this.idClub = idClub;
		this.nombre = nombre;
		this.colores = colores;
		this.codigo_acceso = codigo_acceso;
	}
	
	public ClubDto() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String toString() {
		return "ClubDto [idClub=" + idClub + ", nombre=" + nombre + ", colores=" + colores + ", codigo_acceso="
				+ codigo_acceso + "]";
	}
	
}
