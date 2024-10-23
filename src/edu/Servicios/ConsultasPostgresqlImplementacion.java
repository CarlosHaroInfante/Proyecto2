package edu.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import edu.Dtos.ClubDto;
import edu.Dtos.UsuarioDto;
import edu.Utils.ADto;
import edu.Utils.BDto;

	/**
	 * Implementación de la interfaz de consultas sobre Postgresql
	 * 220923-rfg
	 */
	public class ConsultasPostgresqlImplementacion implements ConsultasPostgresqlInterfaz{

		@Override
		 /**
	     * Método para insertar un nuevo usuario en la base de datos
	     * @param conexionGenerada Conexión a la base de datos
	     * @param usuario Usuario a insertar
	     * @return boolean indicando si el usuario fue insertado con éxito
	     */
	    public boolean insertaUsuario(Connection conexionGenerada, UsuarioDto usuario) {
			
			Long nuevoId = generarIdAutonumericoUsuario(conexionGenerada);
		    usuario.setIdUsuario(nuevoId);

	        String query = "INSERT INTO \"dlk\".\"usuario\" (id, nombre, apellidos, dni, email, telefono) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement declaracionSQL = null;

	        try {
	            // Prepara la declaración SQL con los valores a insertar
	            declaracionSQL = conexionGenerada.prepareStatement(query);
	            declaracionSQL.setLong(1, usuario.getIdUsuario());
	            declaracionSQL.setString(2, usuario.getNombre());
	            declaracionSQL.setString(3, usuario.getApellidos());
	            declaracionSQL.setString(4, usuario.getDni());
	            declaracionSQL.setString(5, usuario.getEmail());
	            declaracionSQL.setString(6, usuario.getTelefono());

	            // Ejecuta el insert
	            int filasAfectadas = declaracionSQL.executeUpdate();

	            // Verifica si la inserción fue exitosa
	            if (filasAfectadas > 0) {
	                System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-insertaUsuario] Usuario insertado correctamente.");
	                return true;
	            } else {
	                System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-insertaUsuario] No se pudo insertar el usuario.");
	                return false;
	            }

	        } catch (SQLException e) {
	            System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertaUsuario] Error al insertar el usuario: " + e);
	            return false;
	        } finally {
	            try {
	                // Cierra la declaración y la conexión
	                if (declaracionSQL != null) declaracionSQL.close();
	                if (conexionGenerada != null) conexionGenerada.close();
	            } catch (SQLException e) {
	                System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertaUsuario] Error al cerrar recursos: " + e);
	            }
	        }
	    }
	    
	    /**
	     * Método para eliminar un usuario de la base de datos
	     * @param conexionGenerada Conexión a la base de datos
	     * @param dni DNI del usuario a eliminar
	     * @return boolean indicando si el usuario fue eliminado con éxito
	     */
	    public boolean eliminaUsuario(Connection conexionGenerada, String dni) {
	        String query = "DELETE FROM \"dlk\".\"usuario\" WHERE dni = ?";
	        PreparedStatement declaracionSQL = null;

	        try {
	            // Prepara la declaración SQL con el DNI como parámetro
	            declaracionSQL = conexionGenerada.prepareStatement(query);
	            declaracionSQL.setString(1, dni);

	            // Ejecuta el delete
	            int filasAfectadas = declaracionSQL.executeUpdate();

	            // Verifica si la eliminación fue exitosa
	            if (filasAfectadas > 0) {
	                System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminaUsuario] Usuario con DNI " + dni + " eliminado correctamente.");
	                return true;
	            } else {
	                System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminaUsuario] No se encontró ningún usuario con el DNI " + dni + ".");
	                return false;
	            }

	        } catch (SQLException e) {
	            System.err.println("[ERROR-ConsultasPostgresqlImplementacion-eliminaUsuario] Error al eliminar el usuario: " + e);
	            return false;
	        } finally {
	            try {
	                // Cierra la declaración y la conexión
	                if (declaracionSQL != null) declaracionSQL.close();
	                if (conexionGenerada != null) conexionGenerada.close();
	            } catch (SQLException e) {
	                System.err.println("[ERROR-ConsultasPostgresqlImplementacion-eliminaUsuario] Error al cerrar recursos: " + e);
	            }
	        }
	    }
	    
	    
	   public boolean insertaClub(Connection conexionGenerada, ClubDto club) {

		   	Long nuevoId = generarIdAutonumerico(conexionGenerada);
		    club.setIdClub(nuevoId);
		    
	        String query = "INSERT INTO \"dlk\".\"club\" (id, nombre, colores, codigo_acceso) VALUES (?, ?, ?, ?)";
	        PreparedStatement declaracionSQL = null;

	        try {
	            // Prepara la declaración SQL con los valores a insertar
	            declaracionSQL = conexionGenerada.prepareStatement(query);
	            declaracionSQL.setLong(1, club.getIdClub());
	            declaracionSQL.setString(2, club.getNombre());
	            declaracionSQL.setString(3, club.getColores());
	            declaracionSQL.setString(4, club.getCodigo_acceso());
	            

	            // Ejecuta el insert
	            int filasAfectadas = declaracionSQL.executeUpdate();

	            // Verifica si la inserción fue exitosa
	            if (filasAfectadas > 0) {
	                System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-insertaUsuario] Club insertado correctamente.");
	                return true;
	            } else {
	                System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-insertaUsuario] No se pudo insertar el Club.");
	                return false;
	            }

	        } catch (SQLException e) {
	            System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertaUsuario] Error al insertar el Club: " + e);
	            return false;
	        } finally {
	            try {/*
	                // Cierra la declaración y la conexión
	                //if (declaracionSQL != null) declaracionSQL.close();
	                if (conexionGenerada != null)conexionGenerada.close();*/
	            } catch (Exception e) {
	                System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertaUsuario] Error al cerrar recursos: " + e);
	            }
	        }
	    }
	        
	    

public void eliminarClub(Connection conexionGenerada, String clubAEliminar) {
	
	
	PreparedStatement declaracionSQL = null;

	try {
	    // Se abre la declaración
	    String query = "DELETE FROM \"dlk\".\"club\" WHERE codigo_acceso = ?";
	    declaracionSQL = conexionGenerada.prepareStatement(query);
	    
	    // Establece el parámetro para el ID a eliminar
	    declaracionSQL.setString(1, clubAEliminar);
	    
	    // Ejecuta la consulta
	    int filasAfectadas = declaracionSQL.executeUpdate();
	    
	    // Imprimir el resultado
	    if (filasAfectadas > 0) {
	        System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminarUsuario] Usuario con ID " + clubAEliminar + " eliminado exitosamente.");
	    } else {
	        System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminarUsuario] No se encontró un usuario con ID " + clubAEliminar + ".");
	    }
	    
	}catch (SQLException e) {
	
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertarUsuario] Error generando o ejecutando la declaracionSQL: " + e);
		
	}
	
}

public ArrayList<Long> seleccionIdClubs(Connection conexionGenerada) {

	

	Statement declaracionSQL = null;

	ResultSet resultadoConsulta = null;

	BDto adto = new BDto();

	ArrayList<Long> listaIdClubs = new ArrayList<>();

	

	

try {

		

		//Se abre una declaración

		declaracionSQL = conexionGenerada.createStatement();

		//Se define la consulta de la declaración y se ejecuta

		resultadoConsulta = declaracionSQL.executeQuery("SELECT id FROM \"dlk\".\"club\" ORDER BY id ASC");

		while (resultadoConsulta.next()) {

			listaIdClubs.add(resultadoConsulta.getLong("id"));	

		}

		//adto.listaTodosUsuarios(resultadoConsulta, listaUsuarios);

		//int i = listaUsuarios.size();

		System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: "/*+ */);

		System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");				

	    resultadoConsulta.close();

	    declaracionSQL.close();

	} catch (SQLException e) {

		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: " + e);

	}

	return listaIdClubs;

}

public Long generarIdAutonumerico(Connection conexionGenerada) {
    ArrayList<Long> listaIdClubs = seleccionIdClubs(conexionGenerada);
    Long nuevoId = 1L; // Valor por defecto

    if (!listaIdClubs.isEmpty()) {
        nuevoId = Collections.max(listaIdClubs) + 1;
    }

    return nuevoId;
}


	public ArrayList<Long> seleccionIdUsuarios(Connection conexionGenerada) {
	
		
	
		Statement declaracionSQL = null;
	
		ResultSet resultadoConsulta = null;
	
		ADto adto = new ADto();
	
		ArrayList<Long> listaIdUsuarios = new ArrayList<>();
	
		
	
		
	
	try {
	
			
	
			//Se abre una declaración
	
			declaracionSQL = conexionGenerada.createStatement();
	
			//Se define la consulta de la declaración y se ejecuta
	
			resultadoConsulta = declaracionSQL.executeQuery("SELECT id FROM \"dlk\".\"usuario\" ORDER BY id ASC");
	
			while (resultadoConsulta.next()) {
	
				listaIdUsuarios.add(resultadoConsulta.getLong("id"));	
	
			}
	
			//adto.listaTodosUsuarios(resultadoConsulta, listaUsuarios);
	
			//int i = listaUsuarios.size();
	
			System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: "/*+ */);
	
			System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");				
	
		    resultadoConsulta.close();
	
		    declaracionSQL.close();
	
		} catch (SQLException e) {
	
			System.err.println("[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: " + e);
	
		}
	
		return listaIdUsuarios;
	
	}
	
	public Long generarIdAutonumericoUsuario(Connection conexionGenerada) {
	    ArrayList<Long> listaIdUsuarios = seleccionIdUsuarios(conexionGenerada);
	    Long nuevoId = 1L; // Valor por defecto

	    if (!listaIdUsuarios.isEmpty()) {
	        nuevoId = Collections.max(listaIdUsuarios) + 1;
	    }

	    return nuevoId;
	}
	
	/**
	 * Método para editar un usuario en la base de datos
	 * @param conexionGenerada Conexión a la base de datos
	 * @param usuario Usuario con los nuevos datos
	 * @return boolean indicando si la actualización fue exitosa
	 */
	public boolean actualizaUsuario(Connection conexionGenerada, UsuarioDto usuario) {
	    String query = "UPDATE \"dlk\".\"usuario\" SET nombre = ?, apellidos = ?, telefono = ?, email = ? WHERE dni = ?";
	    PreparedStatement declaracionSQL = null;

	    try {
	        declaracionSQL = conexionGenerada.prepareStatement(query);
	        declaracionSQL.setString(1, usuario.getNombre());
	        declaracionSQL.setString(2, usuario.getApellidos());
	        declaracionSQL.setString(3, usuario.getTelefono());
	        declaracionSQL.setString(4, usuario.getEmail());
	        declaracionSQL.setString(5, usuario.getDni());

	        int filasAfectadas = declaracionSQL.executeUpdate();
	        return filasAfectadas > 0;
	    } catch (SQLException e) {
	        System.err.println("[ERROR-actualizaUsuario] Error al actualizar el usuario: " + e);
	        return false;
	    } finally {
	        try {
	            if (declaracionSQL != null) declaracionSQL.close();
	            if (conexionGenerada != null) conexionGenerada.close();
	        } catch (SQLException e) {
	            System.err.println("[ERROR-actualizaUsuario] Error al cerrar recursos: " + e);
	        }
	    }
	}

	
	public UsuarioDto buscarUsuarioPorDni(Connection conexionGenerada, String dni) {
	    String query = "SELECT * FROM \"dlk\".\"usuario\" WHERE dni = ?";
	    PreparedStatement declaracionSQL = null;
	    ResultSet resultadoConsulta = null;

	    try {
	        declaracionSQL = conexionGenerada.prepareStatement(query);
	        declaracionSQL.setString(1, dni);
	        resultadoConsulta = declaracionSQL.executeQuery();

	        if (resultadoConsulta.next()) {
	            UsuarioDto usuario = new UsuarioDto();
	            usuario.setIdUsuario(resultadoConsulta.getLong("id"));
	            usuario.setNombre(resultadoConsulta.getString("nombre"));
	            usuario.setApellidos(resultadoConsulta.getString("apellidos"));
	            usuario.setDni(resultadoConsulta.getString("dni"));
	            usuario.setEmail(resultadoConsulta.getString("email"));
	            usuario.setTelefono(resultadoConsulta.getString("telefono"));
	            return usuario;
	        }
	    } catch (SQLException e) {
	        System.err.println("[ERROR-buscarUsuarioPorDni] Error al buscar el usuario: " + e);
	    } finally {
	        try {
	            if (resultadoConsulta != null) resultadoConsulta.close();
	            if (declaracionSQL != null) declaracionSQL.close();
	        } catch (SQLException e) {
	            System.err.println("[ERROR-buscarUsuarioPorDni] Error al cerrar recursos: " + e);
	        }
	    }
	    return null; // Si no se encuentra el usuario, retornar null
	}

	/**
	 * Método para editar un usuario en la base de datos
	 * @param conexionGenerada Conexión a la base de datos
	 * @param usuario Usuario con los nuevos datos
	 * @return boolean indicando si la actualización fue exitosa
	 */
	public boolean actualizaClub(Connection conexionGenerada, ClubDto club) {
	    String query = "UPDATE \"dlk\".\"club\" SET nombre = ?, colores = ? WHERE codigo_acceso = ?";
	    PreparedStatement declaracionSQL = null;

	    try {
	        declaracionSQL = conexionGenerada.prepareStatement(query);
	        declaracionSQL.setString(1, club.getNombre());
	        declaracionSQL.setString(2, club.getColores());
	        declaracionSQL.setString(3, club.getCodigo_acceso());

	        int filasAfectadas = declaracionSQL.executeUpdate();
	        return filasAfectadas > 0;
	    } catch (SQLException e) {
	        System.err.println("[ERROR-actualizaUsuario] Error al actualizar el usuario: " + e);
	        return false;
	    } finally {
	        try {
	            if (declaracionSQL != null) declaracionSQL.close();
	            if (conexionGenerada != null) conexionGenerada.close();
	        } catch (SQLException e) {
	            System.err.println("[ERROR-actualizaUsuario] Error al cerrar recursos: " + e);
	        }
	    }
	}

	
	public ClubDto buscarClubPorCodigo(Connection conexionGenerada, String codigo_acceso) {
	    String query = "SELECT * FROM \"dlk\".\"club\" WHERE codigo_acceso = ?";
	    PreparedStatement declaracionSQL = null;
	    ResultSet resultadoConsulta = null;

	    try {
	        declaracionSQL = conexionGenerada.prepareStatement(query);
	        declaracionSQL.setString(1, codigo_acceso);
	        resultadoConsulta = declaracionSQL.executeQuery();

	        if (resultadoConsulta.next()) {
	            ClubDto club = new ClubDto();
	            club.setIdClub(resultadoConsulta.getLong("id"));
	            club.setNombre(resultadoConsulta.getString("nombre"));
	            club.setColores(resultadoConsulta.getString("colores"));
	            club.setCodigo_acceso(resultadoConsulta.getString("codigo_acceso"));
	            return club;
	        }
	    } catch (SQLException e) {
	        System.err.println("[ERROR-buscarUsuarioPorDni] Error al buscar el usuario: " + e);
	    } finally {
	        try {
	            if (resultadoConsulta != null) resultadoConsulta.close();
	            if (declaracionSQL != null) declaracionSQL.close();
	        } catch (SQLException e) {
	            System.err.println("[ERROR-buscarUsuarioPorDni] Error al cerrar recursos: " + e);
	        }
	    }
	    return null; // Si no se encuentra el usuario, retornar null
	}

	    
	}



