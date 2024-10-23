package edu.Servicios;

import java.sql.Connection;
import java.util.List;

import edu.Dtos.ClubDto;

public interface ClubInterfaz {

	public void crearClub(List<ClubDto> listaClub);
	
	public void borrarClub(List<ClubDto> listaClub, Connection conexiones);
	
	//public void modificarClub(List<ClubDto> listaClub);
	
	public void clubModificar();
}
