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
		
		String dni;
        do {
            System.out.println("Dni del usuario (8 números seguidos de una letra)");
            dni = sc.next();
            if (!validarDniReal(dni)) {
                System.out.println("DNI inválido, por favor ingrese un DNI válido.");
            }
        } while (!validarDniReal(dni));
        usuarioNuevo.setDni(dni);
		
		System.out.println("Telefono del usuario");
		usuarioNuevo.setTelefono(sc.next());
		
		System.out.println("Email del usuario");
		usuarioNuevo.setEmail(sc.next());
		
		usuarioNuevo.setIdUsuario(idAutoGenerado(listaUsuarios));
		
		listaUsuarios.add(usuarioNuevo);
		
		for (UsuarioDto usuario : listaUsuarios) {
			System.out.println(usuario.toString());
		}
		
	}
	
	public void usuarioBaja(List<UsuarioDto> listaUsuarios) {
		
		 	System.out.println("Dame el dni del usuario que quieras eliminar");
	        String dniAEliminar = sc.next();

	        // Eliminamos al usuario con el DNI dado
	        boolean eliminado = listaUsuarios.removeIf(usuario -> usuario.getDni().equals(dniAEliminar));

	        if (eliminado) {
	            System.out.println("Usuario con DNI " + dniAEliminar + " eliminado.");
	        } else {
	            System.out.println("Usuario no encontrado por DNI.");
	        }
	        for (UsuarioDto usuario : listaUsuarios) {
	        	System.out.println(usuario.toString());
			}
		
	}
	
	public void usuarioModificar(List<UsuarioDto> listaUsuarios){
		
		System.out.println("Dame el dni del usuario que quieras modificar");
        String dniClienteModificar = sc.next();
        
        for (UsuarioDto usuario : listaUsuarios) {
			
        	if(usuario.getDni().equals(dniClienteModificar)) {
        		
		        System.out.println("¿Que campos quieres modificar? [1] - Nombre, [2] - Apellidos, [3] - DNI, [4] - Telefono, [5] - email");
				byte opcion = sc.nextByte();
				
				switch (opcion) {
				case 0:
					System.out.println("Volver");
					break;
				case 1:
					System.out.println("Cambio de nombre");
					usuario.setNombre(sc.next());
					break;
				case 2:
					System.out.println("Cambio de apellidos");
					usuario.setApellidos(sc.next());
					break;
				case 3:
					System.out.println("Cambio de DNI");
					String dni;
			        do {
			            System.out.println("Dni del usuario (8 números seguidos de una letra)");
			            dni = sc.next();
			            if (!validarDniReal(dni)) {
			                System.out.println("DNI inválido, por favor ingrese un DNI válido.");
			            }
			        } while (!validarDniReal(dni));
			        usuario.setDni(dni);
			        break;
				case 4:
					System.out.println("Cambio de teléfono");
					usuario.setTelefono(sc.next());
					break;
				case 5:
					System.out.println("Cambio de email");
					usuario.setEmail(sc.next());
					break;
				default:
					System.out.println("Opcion no válida");
					break;
				}
					
        	}
        	
        	
		}
        		for (UsuarioDto usuario : listaUsuarios) {
		        	System.out.println(usuario.toString());
				}
        
		
	}
	
	
	private long idAutoGenerado(List<UsuarioDto> listaUsuarios) {
		
		long idAuto;
		
		int tamanioLista = listaUsuarios.size();
		
		
		if(tamanioLista > 0) {
			idAuto = listaUsuarios.get(tamanioLista - 1).getIdUsuario() + 1;
		}
		else {
			idAuto = 1;
		}
		
		return idAuto;
		
	}
	
	// Método privado para validar el formato del DNI y la letra
    private boolean validarDniReal(String dni) {
        // Validar si tiene exactamente 8 números y una letra al final
        if (!dni.matches("\\d{8}[A-Za-z]")) {
            return false;
        }

        // Separar los números y la letra
        String numerosDni = dni.substring(0, 8);
        char letraDni = dni.toUpperCase().charAt(8);

        // Convertir los números a entero
        int numeros = Integer.parseInt(numerosDni);

        // Array de letras válidas según el algoritmo
        char[] letrasValidas = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 
                                'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        // Calcular la letra correcta según el número
        int indiceLetra = numeros % 23;
        char letraCorrecta = letrasValidas[indiceLetra];

        // Verificar si la letra ingresada coincide con la letra calculada
        return letraDni == letraCorrecta;
    }
}
