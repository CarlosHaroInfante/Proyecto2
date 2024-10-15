package edu.controladores;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.Dtos.UsuarioDto;
import edu.Servicios.ConexionPostgresqlImplementacion;
import edu.Servicios.ConexionPostgresqlInterfaz;
import edu.Servicios.FicheroLogImplementacion;
import edu.Servicios.FicheroLogInterfaz;
import edu.Servicios.MenuImplementacion;
import edu.Servicios.MenuInterfaz;
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
			MenuInterfaz menu = new MenuImplementacion();
			FicheroLogInterfaz ficheroLog = new FicheroLogImplementacion();
			List<UsuarioDto> listaUsuarios = new ArrayList<UsuarioDto>();
			boolean cerrarMenu = false;
			String mensaje;
			
			try {
				Connection conexion = postgreConexion.generaConexion();
				
				if(conexion != null) {
					System.out.println("CONEXION ESTABLECIDA");
					}	
			} catch (Exception e) {
				System.err.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
			}
			
			try {
				
				while (!cerrarMenu) {
					byte opcionMenu = menu.menuPrincipal();
					mensaje = "Entra en el menú principal";
					ficheroLog.ficheroLog(mensaje);
					
					switch (opcionMenu) {
					case 0:
						System.out.println("Cerrar Menú");
						mensaje = "Se cierra el menú";
						ficheroLog.ficheroLog(mensaje);
						cerrarMenu = true;
						break;
						
					case 1:
						System.out.println("Iniciar sesión como usuario");
						mensaje = "Inicia sesión como usuario";
						ficheroLog.ficheroLog(mensaje);
						break;
						
					case 2:
						System.out.println("Iniciar Sesión como club");
						mensaje = "Inicia sesión como club";
						ficheroLog.ficheroLog(mensaje);
						break;
					case 3:
						System.out.println("Crear una nueva cuenta");
						mensaje = "Se va a crear una nueva cuenta";
						ficheroLog.ficheroLog(mensaje);
						byte opcionNuevaCuenta = menu.menuNuevaCuenta();
						switch (opcionNuevaCuenta) {
							case 0:
								System.out.println("Volver al menú principal");
								mensaje = "Vuelve al menú principal";
								ficheroLog.ficheroLog(mensaje);
								break;
							case 1:
								System.out.println("Crear cuenta como usuario");
								mensaje = "Se crea una cuenta como usuario";
								ficheroLog.ficheroLog(mensaje);
								break;
							case 2:
								System.out.println("Crear cuenta como club");
								mensaje = "Se crea una cuenta como club";
								ficheroLog.ficheroLog(mensaje);
								break;
							default:
								System.out.println("Opción no válida, vuelva a intentarlo");
								mensaje = "Opción no válida, El usuario vuelve a intentarlo";
								ficheroLog.ficheroLog(mensaje);
								break;
							}
						
					case 4:
						System.out.println("Crear una nueva cuenta");
						mensaje = "Se va a crear una nueva cuenta";
						ficheroLog.ficheroLog(mensaje);
						byte opcionModificarCuenta = menu.menuModificarCuenta();
						switch (opcionModificarCuenta) {
							case 0:
								System.out.println("Volver al menú principal");
								mensaje = "Vuelve al menú principal";
								ficheroLog.ficheroLog(mensaje);
								break;
							case 1:
								System.out.println("Modificar cuenta de usuario");
								mensaje = "Se modifica una cuenta de usuario";
								ficheroLog.ficheroLog(mensaje);
								break;
							case 2:
								System.out.println("Modificar cuenta de club");
								mensaje = "Se modifica una cuenta de club";
								ficheroLog.ficheroLog(mensaje);
								break;
							default:
								System.out.println("Opción no válida, vuelva a intentarlo");
								mensaje = "Opción no válida, El usuario vuelve a intentarlo";
								ficheroLog.ficheroLog(mensaje);
								break;
							}
					default:
						System.out.println("Opción no válida, vuelva a intentarlo");
						mensaje = "Opción no válida, El usuario vuelve a intentarlo";
						ficheroLog.ficheroLog(mensaje);
						break;
					}
					
				}
				
		
				
			} catch (Exception e) {
				// TODO: handle exception
				mensaje = "Error tipo I/O en el menú o en una de sus opciones";
				ficheroLog.ficheroLog(mensaje);
				System.out.println("Error tipo I/O en el menú o en una de sus opciones " + e.getMessage());
			}
			


	}
}
