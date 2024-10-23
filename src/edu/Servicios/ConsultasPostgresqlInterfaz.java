package edu.Servicios;
import java.sql.Connection;
import java.util.ArrayList;

import edu.Dtos.ClubDto;
import edu.Dtos.UsuarioDto;

public interface ConsultasPostgresqlInterfaz {

	//public ArrayList<UsuarioDto> seleccionaTodosLosUsuarios(Connection conexionGenerada);
	
	//public ArrayList<ClubDto> seleccionaTodosLosClubs(Connection conexionGenerada);
	
	public boolean insertaUsuario(Connection conexionGenerada, UsuarioDto usuario);
	
	 public boolean eliminaUsuario(Connection conexionGenerada, String dni);
	 
	 public boolean insertaClub(Connection conexionGenerada, ClubDto club);
	 
	 //public boolean eliminaClub(Connection conexionGenerada, String codigo_acceso);
	 public void eliminarClub(Connection conexionGenerada, String clubAEliminar);
	 
	 public ArrayList<Long> seleccionIdUsuarios(Connection conexionGenerada);
	 
	 public ArrayList<Long> seleccionIdClubs(Connection conexionGenerada);
	 
	 public boolean actualizaUsuario(Connection conexionGenerada, UsuarioDto usuario);
	 
	 public UsuarioDto buscarUsuarioPorDni(Connection conexionGenerada, String dni);
	 
	 public boolean actualizaClub(Connection conexionGenerada, ClubDto club);
	 
	 public ClubDto buscarClubPorCodigo(Connection conexionGenerada, String codigo_acceso);
}
