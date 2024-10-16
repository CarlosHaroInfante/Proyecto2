package edu.Servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz{
	Scanner sc = new Scanner(System.in);
	public byte menuPrincipal() {
		
		System.out.println("Menu Principal");
		System.out.println("//////////////");
		System.out.println("[0 - Cerrar Menú]");
		System.out.println("[1 - Crear nueva cuenta]");
		System.out.println("[2 - Eliminar nueva cuenta]");
		System.out.println("[3 - Modificar una cuenta]");
		
		byte opMenuPrincipal = sc.nextByte();
		
		return opMenuPrincipal;
		
		
	}
	
	public byte menuNuevaCuenta() {
		
		System.out.println("Crear nueva cuenta");
		System.out.println("//////////////");
		System.out.println("[0 - Volver al menú principal]");
		System.out.println("[1 - Crear cuenta de como usuario]");
		System.out.println("[2 - Crear cuenta como club]");
		
		byte opMenuCuentaNueva = sc.nextByte();
		
		return opMenuCuentaNueva;
		
	}
	
	public byte menuEliminarCuenta() {
		
		System.out.println("Crear nueva cuenta");
		System.out.println("//////////////");
		System.out.println("[0 - Volver al menú principal]");
		System.out.println("[1 - Eliminar cuenta de un usuario]");
		System.out.println("[2 - Eliminar cuenta de un club]");
		
		byte opMenuCuentaNueva = sc.nextByte();
		
		return opMenuCuentaNueva;
		
	}
	
	public byte menuModificarCuenta() {
		
		System.out.println("Modificar cuenta");
		System.out.println("//////////////");
		System.out.println("[0 - Volver al menú principal]");
		System.out.println("[1 - Modificar cuenta de un usuario]");
		System.out.println("[2 - Modificar cuenta de un club]");
		
		byte opMenuModificarCuenta = sc.nextByte();
		
		return opMenuModificarCuenta;
	}
	
}
