package edu.Servicios;

import java.util.List;
import java.util.Scanner;

import edu.Dtos.UsuarioDto;

public class UsuarioImplementacion implements UsuariosInterfaz{

	Scanner sc = new Scanner(System.in);
	public void usuarioNuevo(List<UsuarioDto> listaUsuarios) {
		UsuarioDto usuarioNuevo = new UsuarioDto();
		
		System.out.println("Nombre del usuario");
		usuarioNuevo.setNombre(sc.next());
		
		System.out.println("Apellidos del usuario");
		usuarioNuevo.setApellidos(sc.next());
		
		System.out.println("Dni del usuario");
		usuarioNuevo.setDni(sc.next());
		
		System.out.println("Telefono del usuario");
		usuarioNuevo.setTelefono(sc.next());
		
		System.out.println("Email del usuario");
		usuarioNuevo.setEmail(sc.next());
		
		
	}
}
