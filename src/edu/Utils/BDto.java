package edu.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.Dtos.ClubDto;
/**
 * Clase de utilidad que contiene los métodos de paso a DTO
 * 220923 - rfg
 */
public class BDto {
	
	/**
	 * Método que pasa un resultSet con libros a lista de LibroDto
	 * @param resultadoConsulta
	 * 220923 - rfg
	 * @return lista de libros
	 */
	public ArrayList<ClubDto> resultsAClubDtos(ResultSet resultadoConsulta){
		
		ArrayList<ClubDto> listaClub = new ArrayList<>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {
				
				listaClub.add(new ClubDto(resultadoConsulta.getLong("idClub"),
						resultadoConsulta.getString("nombre"),
						resultadoConsulta.getString("colores"),
						resultadoConsulta.getString("codigo_acceso")
						));
			}
			
			int i = listaClub.size();
			System.out.println("[INFORMACIÓN-ADto-resultsALibrosDto] Número de usuarios: "+i);
			
		} catch (SQLException e) {
			System.err.println("[ERROR-ADto-resultsALibrosDto] Error al pasar el result set a lista de LibroDto" + e);
		}
		
		return listaClub;
		
	}
}

