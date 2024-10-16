package edu.Servicios;

import java.util.List;

import edu.Dtos.UsuarioDto;

public interface UsuariosInterfaz {

	public void usuarioNuevo(List<UsuarioDto> listaUsuarios);
	
	public void usuarioBaja(List<UsuarioDto> listaUsuarios);
	
	public void usuarioModificar(List<UsuarioDto> listaUsuarios);
}
