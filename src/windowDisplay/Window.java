package windowDisplay;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * 09 March 2018
 * Window.java
 * 
 * Creates windows on the canvas.
 */

public class Window 
{
	// Instance variables
	private double x, y;
	private double width, height;
	private Color color;
	
	// Constructor
	public Window(double x, double y, double width, double height, Color color, String name)
	{
		this.x = x;
		this.y = y;
		
		this.width = (width/2);
		this.height = (height/2);
		
		this.color = color;
	}
	
	// Draws windows.
	public void draw()
	{
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(x, y, width, height);
	}
	
	// Checks to see if given coordinates are within a window.
	public boolean contains(double x, double y)
	{
		if(((x <= getRight()) && (x >= getLeft())) && 
			(y <= getTop()) && (y >= getBottom()))
		{
			return true;
		}
		
		return false;
	}
	
	// Getters.
	public double getLeft() {return x-width;}
	public double getRight() {return x + width;}
	public double getTop() {return y + height;}
	public double getBottom() {return y - height;}	
	
	// Setters.
	public void setX(double x) { this.x = x;}
	public void setY(double y) { this.y = y;}
}