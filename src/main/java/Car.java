package main.java;

import java.awt.Point;

public class Car {
	
	private static final int ZERO = 0;
	private Point currentLoc = new Point();

	public Car(Point currentLoc) {
		super();
		this.currentLoc = currentLoc;
	}

	public Car(int x1, int y1) {
		super();
		this.currentLoc.move(x1, y1);
	}
	
	public Car() {
		super();
		this.currentLoc.move(ZERO, ZERO);
	}
	
	public Point getCurrentLoc() {
		return currentLoc;
	}

	public void setCurrentLoc(Point posiciónActual) {
		this.currentLoc = posiciónActual;
	}

}
