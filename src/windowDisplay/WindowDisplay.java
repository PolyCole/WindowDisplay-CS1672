package windowDisplay;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * 09 March 2018
 * WindowDisplay.java
 * 
 * This class creates a display of windows.
 */

public class WindowDisplay 
{
	// List of windows.
	private ArrayList<Window> arr;
	
	// Constructor
	public WindowDisplay(int canvasWidth, int canvasHeight)
	{
		arr = new ArrayList<Window>();
		
		// Initializes canvas.
		StdDraw.setCanvasSize(canvasWidth, canvasHeight);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		StdDraw.enableDoubleBuffering();
	}
	
	// Adds a window to the display.
	public void addWindow(Window w)
	{
		arr.add(w);
	}
	
	public void run()
	{
		// Animation loop.
		while(true)
		{
			if(StdDraw.mousePressed())
			{
				// Returns index of window clicked.
				int windowClicked = checkInside();
				if(windowClicked != -1)
				{
					// Moves window clicked to foremost drawing spot.
					moveElement(windowClicked);
					
					// Infinite loop for "drag-able" effect.
					Outer:
					while(true)
					{
						// Terminates loop when mouse is released.
						if(!(StdDraw.mousePressed()))
						{
							break Outer;
						}
						
						// Updates position of window as it's being dragged.
						arr.get(arr.size()-1).setX(StdDraw.mouseX());
						arr.get(arr.size()-1).setY(StdDraw.mouseY());
						
						animateWindows();
					}
				}
			}
			animateWindows();
		}
	}
	
	// Checks to see if the mouse is clicked within a window.
	public int checkInside()
	{
		for(int i = arr.size()-1; i >= 0; --i)
		{
			if(arr.get(i).contains(StdDraw.mouseX(), StdDraw.mouseY()))
			{
				return i;
			}
		}
		
		// Mouse click misses window, returns -1.
		return -1;
	}

	// Clears canvas, prints all windows, pauses.
	public void animateWindows()
	{
		StdDraw.clear();
		// Draws windows.
		for(Window w : arr)
		{
			w.draw();
		}

		StdDraw.show();
		StdDraw.pause(5);
	}
	
	// Moves windows in array List.
	public void moveElement(int index)
	{
		arr.add(arr.get(index));
		arr.remove(index);
	}
}

