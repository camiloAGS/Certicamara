package main.java;

import java.awt.Point;
import java.io.*;

/*
 * Coded by: Camilo Andres Guchubo S.
 * */

public class CarMovement {
	
	public static void main(String[] args) throws IOException {

		//Condiciones iniciales
		Car car = new Car();
		Surface surf = new Surface();
		executeCommands(car, surf);

	}

	private static void executeCommands(Car car, Surface surf) throws IOException{

		String command;
		boolean draw = true;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		command = "";
		System.out.println("\n\n Bienvenido al programa de vehículo a control remoto");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		showMenu();

		while (!"Q".equals(command.toUpperCase())) {

			System.out.println("\n");
			command = in.readLine();

			try {

				String[] instructionSet;
				instructionSet = command.split(" ");
				//avoids OutofBounds when pressing enter
				switch ("".equals(command)?"M":command.substring(0,1).toUpperCase()) {

				case ("S"):
					surf.CreateCanvas(instructionSet);
					break;
				
				case ("D"):
					Point actualLocation = car.getCurrentLoc();
					car.setCurrentLoc(processInstructions(surf, instructionSet[1], actualLocation));
					break;

				case ("Q"):
					System.out.println("Hasta Luego");
					draw = false;
					break;
				
				case("M"):
					showMenu();
					break;
				
				default:
					System.out.println("Por favor usa uno de los comandos del menú");
					break;
				};
			} catch (Exception e) {
				System.out.println("Error en formato de comando");
			}

			if (draw)surf.drawCanvas();
		}
	}
	
	
	
	private static Point processInstructions(Surface surf, String coordinateSet, Point currentLoc){
		
		String[] coord = coordinateSet.split(";");
		Point lastLocation = currentLoc;
		System.out.println("Desplazándose...");
		for(String c : coord) {
			
			String[] coordinate = c.split(",");
			int steps = Integer.valueOf(coordinate[0]);
			String direction = coordinate[1].toUpperCase();
			
			if(surf.validateMovement(direction, steps, lastLocation)) {
				lastLocation = surf.moveCar(direction, steps, lastLocation);
			} 
		}
		return lastLocation;
	}

	

	private static void showMenu(){
		clearConsole();
		System.out.println(" Menu:");
		System.out.println("\n");
		System.out.println(" S n m	= Crea una superficie de n x m casillas.");
		System.out.println(" D p,c	= Desplaza el auto p numero de pasos en dirección c.");
		System.out.println(" M	= Muestra este menú");
		System.out.println(" Q 	= Sale del programa");
		System.out.println(" Para desplazar el vehículo introduzca la letra D el número de casillas a mover coma(,) y las direcciónes: Norte (N), Sur(S), Este (E), Oeste(O)");
		System.out.println(" Ejemplo: D 5,N el auto se desplazará 5 pasos en dirección norte. Puede enlazar varios movimientos separándolos por un ;");
		System.out.println(" Ejemplo: D 5,N;8,E;1,S el auto se desplazará 5 pasos en dirección norte, 8 oeste y 1 sur");
		System.out.println(" Es indiferente la capitalización de las letras");
	}

	private final static void clearConsole()
	{
		try
		{
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) Runtime.getRuntime().exec("cls");
			else Runtime.getRuntime().exec("clear");
		}
		catch (final Exception e)
		{
		}
	}

}