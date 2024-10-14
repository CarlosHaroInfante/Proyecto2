package edu.controladores;

import java.sql.Connection;
import java.util.ArrayList;

import edu.Dtos.ClubDto;
import edu.Dtos.UsuarioDto;
import edu.Servicios.ConexionPostgresqlImplementacion;
import edu.Servicios.ConexionPostgresqlInterfaz;
import edu.Servicios.ConsultasPostgrasqlInterfaz;
import edu.Servicios.ConsultasPostgresqlImplementacion;
	/**
	 * Clase principal de la aplicación
	 * 220923 - rfg
	 */
	public class Inicio {

		/**
		 * Método de acceso a la aplicación de consola
		 * @param args
		 */
		public static void main(String[] args) {
			
			ConexionPostgresqlInterfaz postgreConexion = new ConexionPostgresqlImplementacion();
			/*ConsultasPostgrasqlInterfaz consultas = new ConsultasPostgresqlImplementacion();
			ArrayList<ClubDto> listaClub = new ArrayList<>();
			ArrayList<UsuarioDto> listaUsuario = new ArrayList<>();
			
			try {
				Connection conexion = postgreConexion.generaConexion();
				
				if(conexion != null) {
					listaClub = consultas.seleccionaTodosLibros(conexion);
					for(int i=0;i<listaClub.size();i++) {
						System.out.println(listaClub.get(i).toString());
					}
				}
				
				if(conexion != null) {
					listaUsuario = consultas.seleccionaTodosLibros(conexion);
					for(int i=0;i<listaUsuario.size();i++) {
						System.out.println(listaUsuario.get(i).toString());
					}
				}
				
			} catch (Exception e) {
				System.err.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
			}
			
		
			
		}*/
		
		

	}
}
