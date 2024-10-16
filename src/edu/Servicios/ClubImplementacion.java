package edu.Servicios;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.Dtos.ClubDto;

public class ClubImplementacion implements ClubInterfaz{

	Scanner sc = new Scanner(System.in);
	public void crearClub(List<ClubDto> listaClub) {
		ClubDto nuevoClub = new ClubDto();
		
		System.out.println("Nombre del club [Junto]");
		nuevoClub.setNombre(sc.next());
		
		System.out.println("Colores del club [Junto]");
		nuevoClub.setColores(sc.next());
		
		System.out.println("Código de acceso");
		nuevoClub.setCodigo_acceso(generarCodigoAcceso());
		
		nuevoClub.setIdClub(idAutoGenerado(listaClub));
		
		listaClub.add(nuevoClub);
		
		for (ClubDto club : listaClub) {
			System.out.println(club.toString());
		}
		
	}

	public void borrarClub(List<ClubDto> listaClub) {
		
		System.out.println("Dame el código de acceso del club que quieras eliminar");
        String codigoAccesoAEliminar = sc.next();

        // Eliminamos al usuario con el DNI dado
        boolean eliminado = listaClub.removeIf(club -> club.getCodigo_acceso().equals(codigoAccesoAEliminar));

        if (eliminado) {
            System.out.println("Club con el código de acceso " + codigoAccesoAEliminar + " eliminado.");
        } else {
            System.out.println("Club no encontrado por el código de acceso.");
        }
        for (ClubDto club : listaClub) {
        	System.out.println(club.toString());
		}
	}
	
	public void modificarClub(List<ClubDto> listaClub) {
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
	}


private long idAutoGenerado(List<ClubDto> listaClub) {
	
	long idAuto;
	
	int tamanioLista = listaClub.size();
	
	
	if(tamanioLista > 0) {
		idAuto = listaClub.get(tamanioLista - 1).getIdClub() + 1;
	}
	else {
		idAuto = 1;
	}
	
	return idAuto;
	
}

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