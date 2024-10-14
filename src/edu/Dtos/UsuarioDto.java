package edu.Dtos;

public class UsuarioDto {

	private long idUsuario;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	private String email;
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UsuarioDto(long idUsuario, String nombre, String apellidos, String dni, String telefono, String email) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
	}
	
	public UsuarioDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "UsuarioDto [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", telefono=" + telefono + ", email=" + email + "]";
	}
	
}
