package edu.Servicios;

import java.util.List;
import java.util.Scanner;

import edu.Dtos.UsuarioDto;

public class UsuarioImplementacion implements UsuariosInterfaz{

	Scanner sc = new Scanner(System.in);
	public void usuarioNuevo(List<UsuarioDto> listaUsuarios) {
		UsuarioDto usuarioNuevo = new UsuarioDto();
		
		usuarioNuevo.setNombre(sc.next());
		
		usuarioNuevo.setApellidos(sc.next());
		
		usuarioNuevo.setDni(sc.next());
		
		usuarioNuevo.setTelefono(sc.next());
		
		usuarioNuevo.setEmail(sc.next());
		
		
	}
}
