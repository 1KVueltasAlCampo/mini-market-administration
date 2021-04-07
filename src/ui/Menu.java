package ui;
import model.*;
import exceptions.*;

import java.util.Scanner;

public class Menu {
	private final static int ENTER_A_PERSON_TO_THE_MINIMARKET = 1;
	private final static int SEE_HOW_MANY_PEOPLE_ATTEMPTED_TO_ENTER = 2;
	private final static int EXIT = 3;
	private Scanner sc;
	
	private Minimarket mm;
	
	public Menu() {
		sc = new Scanner(System.in);
		mm = new Minimarket();
	}
	
	public void showMenuOptions() {
		System.out.println("*************** Mi barrio te quiere *****************");
		System.out.println("**** Ingrese una opcion: ");
		System.out.println("** Ingrese 1 para permitir el ingreso de una persona al minimercado");
		System.out.println("** Ingrese 2 para visualizar cuantas personas intentaron entrar al minimercado");
		System.out.println("** Ingrese 3 para salir ");
		System.out.println("******************************************************");
	}
	
	public void start() {
		int option = -1;
		do {
			showMenuOptions();
			option = sc.nextInt();
			sc.nextLine();
			doAnOption(option);
		} while(option != 0);
	}
	
	public void doAnOption(int option) {
		switch(option) {
		case ENTER_A_PERSON_TO_THE_MINIMARKET:
			enterAPersonToTheMinimarket();
			break;
		default: System.out.println("Ingrese una opcion valida");	
		}
	}
	public void showIDTypesOptions() {
		System.out.println("-Ingrese 1 para cedula de ciudadania (CC) ");
		System.out.println("-Ingrese 2 para pasaporte (PP)");
		System.out.println("-Ingrese 3 para cedula de extranjeria (CE)");
		System.out.println("-Ingrese 4 para tarjeta de identidad (TI)");
	}
	
	public void enterAPersonToTheMinimarket() {
		System.out.println("I N G R E S E  U N A  P E R S O N A  A L  M I N I M E R C A D O");
		System.out.println("Ingrese el tipo de identificacion de la persona. Use una de las siguientes opciones:");
		showIDTypesOptions();
		int idType = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el numero de documento");
		String idNumber = sc.nextLine();
		try {
			mm.enterAPerson(idType, idNumber);
			System.out.println("Ingreso exitoso");
		} catch(IncompatibleDayAndIDNumberException typeE) {
			System.out.println("Debido al día, esta persona no puede ingresar porque su número de identificación no es válido.");
		} catch (InvalidIDTypeException e) {
			System.out.println("El tipo de identificacion ingresado no es valido, asegurese de que el tipo de identificacion exista o no sea tarjeta de identidad");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Presione enter para continuar ");
			sc.nextLine();
		}
		
	}
}
