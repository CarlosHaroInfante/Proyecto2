package edu.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.Dtos.UsuarioDto;
/**
 * Clase de utilidad que contiene los métodos de paso a DTO
 * 220923 - rfg
 */
public class ADto {
	
	/**
	 * Método que pasa un resultSet con libros a lista de LibroDto
	 * @param resultadoConsulta
	 * 220923 - rfg
	 * @return lista de libros
	 */
	public ArrayList<UsuarioDto> resultsAUsuarioDtos(ResultSet resultadoConsulta){
		
		ArrayList<UsuarioDto> listaUsuarios = new ArrayList<>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {
				
				listaUsuarios.add(new UsuarioDto(resultadoConsulta.getLong("id"),
						resultadoConsulta.getString("nombre"),
						resultadoConsulta.getString("apellidos"),
						resultadoConsulta.getString("dni"),
						resultadoConsulta.getString("email"),
						resultadoConsulta.getString("telefono")
						));
			}
			
			int i = listaUsuarios.size();
			System.out.println("[INFORMACIÓN-ADto-resultsALibrosDto] Número de usuarios: "+i);
			
		} catch (SQLException e) {
			System.err.println("[ERROR-ADto-resultsALibrosDto] Error al pasar el result set a lista de UsuarioDto" + e);
		}
		
		return listaUsuarios;
		
	}
}
