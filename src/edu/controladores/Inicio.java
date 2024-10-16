package edu.controladores;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.Dtos.ClubDto;
import edu.Dtos.UsuarioDto;
import edu.Servicios.ClubImplementacion;
import edu.Servicios.ClubInterfaz;
import edu.Servicios.ConexionPostgresqlImplementacion;
import edu.Servicios.ConexionPostgresqlInterfaz;
import edu.Servicios.FicheroLogImplementacion;
import edu.Servicios.FicheroLogInterfaz;
import edu.Servicios.MenuImplementacion;
import edu.Servicios.MenuInterfaz;
import edu.Servicios.UsuarioImplementacion;
import edu.Servicios.UsuariosInterfaz;
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
			UsuariosInterfaz usuarios = new UsuarioImplementacion();
			ClubInterfaz clubes = new ClubImplementacion();
			FicheroLogInterfaz ficheroLog = new FicheroLogImplementacion();
			List<UsuarioDto> listaUsuarios = new ArrayList<UsuarioDto>();
			List<ClubDto> listaClub = new ArrayList<ClubDto>();
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
								usuarios.usuarioNuevo(listaUsuarios);
								break;
							case 2:
								System.out.println("Crear cuenta como club");
								mensaje = "Se crea una cuenta como club";
								ficheroLog.ficheroLog(mensaje);
								clubes.crearClub(listaClub);
								break;
							default:
								System.out.println("Opción no válida, vuelva a intentarlo");
								mensaje = "Opción no válida, El usuario vuelve a intentarlo";
								ficheroLog.ficheroLog(mensaje);
								break;
							}
						break;
					case 2:
						System.out.println("Eliminar una cuenta");
						mensaje = "Se va a eliminar una cuenta";
						ficheroLog.ficheroLog(mensaje);
						byte opcionEliminarCuenta = menu.menuEliminarCuenta();
						switch (opcionEliminarCuenta) {
							case 0:
								System.out.println("Volver al menú principal");
								mensaje = "Vuelve al menú principal";
								ficheroLog.ficheroLog(mensaje);
								break;
							case 1:
								System.out.println("Eliminar cuenta de usuario");
								mensaje = "Se eliminar una cuenta de usuario";
								ficheroLog.ficheroLog(mensaje);
								usuarios.usuarioBaja(listaUsuarios);
								break;
							case 2:
								System.out.println("Eliminar cuenta de club");
								mensaje = "Se eliminar una cuenta de club";
								ficheroLog.ficheroLog(mensaje);
								clubes.borrarClub(listaClub);
								break;
							default:
								System.out.println("Opción no válida, vuelva a intentarlo");
								mensaje = "Opción no válida, El usuario vuelve a intentarlo";
								ficheroLog.ficheroLog(mensaje);
								break;
							}
						break;
						
					case 3:
						System.out.println("Modificar una cuenta");
						mensaje = "Se va a Modificar una cuenta";
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
								usuarios.usuarioModificar(listaUsuarios);
								break;
							case 2:
								System.out.println("Modificar cuenta de club");
								mensaje = "Se modifica una cuenta de club";
								ficheroLog.ficheroLog(mensaje);
								clubes.modificarClub(listaClub);
								break;
							default:
								System.out.println("Opción no válida, vuelva a intentarlo");
								mensaje = "Opción no válida, El usuario vuelve a intentarlo";
								ficheroLog.ficheroLog(mensaje);
								break;
							}
						break;
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
