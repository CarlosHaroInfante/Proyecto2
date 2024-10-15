package edu.Servicios;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FicheroLogImplementacion implements FicheroLogInterfaz{

	public void ficheroLog(String mensaje) {
		try {
			
		LocalDate fecha = LocalDate.now();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
		
		String fechaFormateada = formato.format(fecha);
		
		String ficheroLog = "C:\\Users\\CHI\\Desktop\\CSI2\\DWS (D Regino)\\Proyecto2\\src\\edu\\" + fechaFormateada + ".txt";
		
		FileWriter escribe = new FileWriter(ficheroLog, true);
		escribe.write(mensaje + "\n");
		escribe.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear el fichero log " + e.getMessage());
		}
		
		
	}
}
