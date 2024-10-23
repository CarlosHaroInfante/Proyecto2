package edu.Servicios;

import java.sql.Connection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.Dtos.ClubDto;
import edu.Dtos.UsuarioDto;

public class ClubImplementacion implements ClubInterfaz{

	ConsultasPostgresqlInterfaz consultas = new ConsultasPostgresqlImplementacion();
	ConexionPostgresqlInterfaz conexionPostgresql = new ConexionPostgresqlImplementacion();
	
	Scanner sc = new Scanner(System.in);
	public void crearClub(List<ClubDto> listaClub) {
		ClubDto nuevoClub = new ClubDto();
		
		System.out.println("Nombre del club [Junto]");
		nuevoClub.setNombre(sc.next());
		
		System.out.println("Colores del club [Junto]");
		nuevoClub.setColores(sc.next());
		
		System.out.println("Código de acceso");
		nuevoClub.setCodigo_acceso(generarCodigoAcceso());
		
		Connection conexion = conexionPostgresql.generaConexion();
	    //nuevoClub.setIdClub(generarIdAutonumerico(conexion));
		
		consultas.insertaClub(conexion, nuevoClub);
		
		listaClub.add(nuevoClub);
		
		for (ClubDto club : listaClub) {
			System.out.println(club.toString());
		}
		
	}

	public void borrarClub(List<ClubDto> listaClub, Connection conexiones) {
		
		System.out.println("Dame el código de acceso del club que quieras eliminar");
        String codigoAccesoAEliminar = sc.next();

        consultas.eliminarClub(conexiones, codigoAccesoAEliminar);
        
	}
	
	/**public void modificarClub(List<ClubDto> listaClub) {
		System.out.println("Dame el código de acceso del club que quieras eliminar");
        String codigoAccesoAModificar = sc.next();
        
        for (ClubDto club : listaClub) {
			if(club.getCodigo_acceso().equals(codigoAccesoAModificar)) {
				
				System.out.println("¿Que campos quieres modificar? [1] - Nombre, [2] - Colores");
				byte opcionModificarClub = sc.nextByte();
				
				switch (opcionModificarClub) {
				case 0:
					System.out.println("Volver");
					break;
				case 1:
					System.out.println("Nombre nuevo para el club [Junto]");
					club.setNombre(sc.next());
					break;
				case 2:
					System.out.println("Colores del Club [Junto]");
					club.setColores(sc.next());
					break;
				default:
					System.out.println("Opcion no válida");
					break;
				}
				
			}
		}
        for (ClubDto club : listaClub) {
        	System.out.println(club.toString());
		}
	}*/
	public void clubModificar() {
	    System.out.println("Dame el DNI del usuario que quieras modificar:");
	    String codigoClubModificar = sc.next();

	    // Conectar a la base de datos
	    Connection conexion = conexionPostgresql.generaConexion();
	    ClubDto clubEncontrado = consultas.buscarClubPorCodigo(conexion, codigoClubModificar);

	    if (clubEncontrado == null) {
	        System.out.println("No se encontró ningún club con el codigo " + codigoClubModificar + ".");
	        return;
	    }

	    // Preguntar qué campo quiere modificar
	    System.out.println("¿Que campos quieres modificar? [1] - Nombre, [2] - Colores");
	    byte opcion = sc.nextByte();

	    switch (opcion) {
	        case 1:
	            System.out.println("Introduce el nuevo nombre:");
	            clubEncontrado.setNombre(sc.next());
	            break;
	        case 2:
	            System.out.println("Introduce los nuevos apellidos:");
	            clubEncontrado.setColores(sc.next());
	            break;
	        default:
	            System.out.println("Opción no válida.");
	            return;
	    }

	    // Aquí llamarás a un método para actualizar en la base de datos
	    boolean resultado = consultas.actualizaClub(conexion, clubEncontrado); // Implementar este método
	    if (resultado) {
	        System.out.println("El club ha sido actualizado con éxito.");
	    } else {
	        System.out.println("Error al actualizar el club.");
	    }

	    // Mostrar la lista actualizada de usuarios (opcional)
	    // Puedes volver a buscar los usuarios desde la base de datos si lo deseas
	}


/**private long idAutoGenerado(List<ClubDto> listaClub) {
	
	long idAuto;
	
	int tamanioLista = listaClub.size();
	
	
	if(tamanioLista > 0) {
		idAuto = listaClub.get(tamanioLista - 1).getIdClub() + 1;
	}
	else {
		idAuto = 1;
	}
	
	return idAuto;
	
}*/
	


	private String generarCodigoAcceso() {
    // Conjunto de caracteres que se utilizarán (mayúsculas, minúsculas y números)
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder codigo = new StringBuilder();
    Random random = new Random();

    // Generar 5 caracteres aleatorios
    for (int i = 0; i < 5; i++) {
        int indice = random.nextInt(caracteres.length());
        codigo.append(caracteres.charAt(indice));
    }

    return codigo.toString();
}

}