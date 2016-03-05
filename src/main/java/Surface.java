package main.java;

import java.awt.Point;
import java.util.Arrays;

public class Surface {
	
	private static final int ZERO = 0;
	private static char[][] CANVAS;
	
	public Surface() {
		super();
	}

	public void CreateCanvas(String[] instructionSet){

		int width =Integer.valueOf(instructionSet[1]);
		int height = Integer.valueOf(instructionSet[2]);

		CANVAS = new char[width][height];

		//Crea el canvas vacío y ubica el auto en la posición inicial
		System.out.println("Superficie creada");
		moveCar("", ZERO, new Point(ZERO,ZERO));

	}
	
	public void ClearCanvas(){
		for (int i = 0; i < CANVAS.length; i++) {
			Arrays.fill(CANVAS[i], ' ');
		}
	}

	public void drawCanvas() {

		if (CANVAS !=null){
			System.out.println("\n" + "+"+ fillString('-', CANVAS[0].length)+ "+");
			for (int i = CANVAS.length-1; i >=0; i--) {
				System.out.print("|");
				for (int j = 0; j < CANVAS[0].length; j++) {
					System.out.print(CANVAS[i][j]);
				}
				System.out.print("| \n");
			}
			System.out.print("+" + fillString('-', CANVAS[0].length)+ "+");
		} else {System.out.println("No has definido una superficie!");}
	}
	
	//pinta las líneas superior e inferior de la superficie
	public String fillString(char fillChar, int count) {
		char[] chars = new char[count];
		while (count > 0)
			chars[--count] = fillChar;
		return new String(chars);
	}
	
	public boolean validateMovement(String direction, int steps, Point curPosition){
		if(CANVAS !=null){
			
			int x = curPosition.x;
			int y = curPosition.y;
			
			switch (direction){
			case ("N"):
				y += steps;
				break;
			case ("S"):
				y -= steps;
				break;
			case ("E"):
				x += steps;
				break;
			case ("O"):
				x -= steps;
				break;
			default:
				break;
			}
			
			if(x < 0 || x > CANVAS[0].length-1 || y < 0 || y > CANVAS.length-1 ){
				System.out.println("Se ha detenido el avance por salir de los límites");
				return false;
			}
			
			return true;
			
		} else {
			return false;
		}
	}

	public Point moveCar(String direction, int steps, Point curPosition) {
		
		int x = curPosition.x;
		int y = curPosition.y;
		char position_mark = 'X';
		
		switch (direction){
		case ("N"):
			curPosition.move(x, y+steps);
			break;
		case ("S"):
			curPosition.move(x, y-steps);
			break;
		case ("E"):
			curPosition.move(x+steps, y);
			break;
		case ("O"):
			curPosition.move(x-steps, y);
			break;
		default:
			break;
		}
		
		ClearCanvas();
		//setea la posicion nueva del auto
		CANVAS[curPosition.y][curPosition.x]= position_mark;
		
		System.out.println("("+curPosition.x+","+curPosition.y+")");
		return curPosition;
		
	}
}
