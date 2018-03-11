package windowDisplay;

import java.awt.Color;

/*
 * Author: Cole Polyak
 * 09 March 2018
 * WindowDriver.java
 * 
 * This class exercises the WindowDisplay and Window classes.
 */

public class WindowDriver 
{
	public static void main(String[] args)
	{
		// Creation of windows.
		Window w1 = new Window(50, 50, 40, 40, Color.RED, "RED");
		Window w2 = new Window(30, 60, 35, 60, Color.GREEN, "GREEN");
		Window w3 = new Window(40, 75, 80, 30, Color.BLUE, "BLUE");
		Window w4 = new Window(20, 35, 30, 20, Color.YELLOW, "YELLOW");
		
		// Creation of display.
		WindowDisplay w = new WindowDisplay(1500, 1500);
		
		// Adding windows to display.
		w.addWindow(w1); w.addWindow(w2); w.addWindow(w3); w.addWindow(w4); 
		
		// and output.
		w.run();
	}
}

