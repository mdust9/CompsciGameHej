import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and JComponents

// The class needs to extend JFrame:
public class GuiPictLoader extends JFrame {
	
	// instance variables
	Image fish;
	
	/** Creates a new instance of gui_test - sets up GUI */
    public GuiPictLoader() {
        // STEP 1: must call super() first
        super("Demo Picture Loading");
    

		// need to load up "fish" image used below
		
//		PictLoader test = new PictLoader();	// when using IDE
		JarPictLoader test = new JarPictLoader();	// when using JAR file
		
		ImageIcon fish1Icon = test.getFishy1();
		ImageIcon fish2Icon = test.getFishy2();
		
		fish = fish1Icon.getImage();	
		
        // DON'T FORGET TO INCLUDE THIS CODE - otherwise you will not
        // be able to close your application!!!
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        
        // STEP 6: set window size and show window
        setSize( 400, 170);
        setVisible(true);
        
    }
    
    /*
     * This is the graphics demo section.  When you want to use
     * any methods of the Graphics class, you need to call the
     * Component method paint(), which takes a Graphics object
     * as an argument.  The run-time system is in control of when
     * paint() executes, not the programmer, because drawing graphics
     * is "event-driven" (e.g. when a window is covered or uncovered).
     * If the programmer needs to call paint(), the way to do that is by calling the method
     * repaint() instead.  (See the use of repaint() in GuiTest3.)
     *
     * Here are just some of the Graphics methods:
     *  - public void setColor (Color c)
     *			// sets the current color - see Color class for
     *			// available predefined colors
     *	- public void drawLine(int x1, int y1, int x2, int y2)
     *			// draws line between (x1, y1) and (x2, y2)
     *  - public void drawRect (int x, int y, int width, int height)
     *			// draws rectangle with top left corner at (x,y)
     *  - public void fillRect (int x, int y, int width, int height)
     *			// draws a solid rectangle with top left corner at (x,y)
     *  - public void drawOval (int x, int y, int width, int height)
     *			// draws oval in current color with specified width
     *			// and height; bounding rectangle's top left corner
     *			// is at (x,y) and oval touches all sides of bounding
     *			// rectangle
     *	- public void fillOval (int x, int y, int width, int height)
     *			// see drawOval
     *	- public void drawImage (Image img, int x, int y, ImageObserver observer)
     *			// draws image loaded from a GIF, JPEG or PNG file - upper
     *			// left corner at (x, y) - usually make 'observer' be 'this'
     */
     public void paint (Graphics g )
     {
     	// call superclass's paint method
     	super.paint(g);
     	
     	// draw a red line; 2 blue rectangles, one filled and one
     	// not; and 2 magenta ovals, one filled and one not
     	
     	g.setColor(Color.red);
     	g.drawLine(5, 30, 350, 30);
     	
     	g.setColor(Color.blue);
     	g.drawRect(5, 40, 90, 55);
     	g.fillRect(100, 40, 90, 55);
     	
     	g.setColor(Color.magenta);
     	g.drawOval(195, 100, 90, 55);
     	g.fillOval(290, 100, 90, 55);
     	
     	g.drawImage(fish, 300, 40, this);	// 'fish' was loaded in constructor
     }
     
    public static void main(String[] args) {
        GuiPictLoader application = new GuiPictLoader();
    }
    	
}
/**
 * @(#)JarPictLoader.java
 * 
 * Centralized location for loading all your image files when
 * your program is loading from a Jar file.
 *
 * @author 
 * @version 1.00 2010/5/25
 */

import javax.swing.*;       // access to JFrame and JComponents
import java.net.URL;		// added for JAR file access
import java.io.*;			// for PrintStream to capture error info

public class JarPictLoader {

	private ImageIcon fishy1,fishy2;		// have one for each image needed
	
    public JarPictLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();	
		// just need to call this once for the whole program
			
  		try {
			// the two steps required to get an image’s file location 
			// and then load it
			URL fishy1IconURL   = cldr.getResource("fish.gif");
			fishy1 = new ImageIcon(fishy1IconURL);

 /***************************************************************
  * PURPOSELY CAUSING AN ERROR HERE - when loading image for 'fishy2'
  * it is calling nonexistent file.
  * Program will cause an exception that is caught below.  
  * Then printing the stack trace to an output file.  
  *  (When loading from a JAR file, there is no ConsoleIO window
  *   to print to !)
  **************************************************************/ 
	 		URL fishy2IconURL   = cldr.getResource("ERROR.gif");
			fishy2 = new ImageIcon(fishy2IconURL); 
  		}  	
     	catch (Exception e){
			try{	
					// PrintStream methods need to be in a 
					// try-catch block
				PrintStream p = new PrintStream(
							new FileOutputStream(new File("trace.txt")));
				p.println("got here");	// sample output to file
				e.printStackTrace(p);	// print stack trace to output file
			}
			catch(Exception e1)	// need this empty section for PrintStream
			{
			}
    	}   					
    }
    public ImageIcon getFishy1()
    {						// have a 'get' method for each image
    	return fishy1;
    }
    public ImageIcon getFishy2()
    {						// have a 'get' method for each image
    	return fishy2;
    }
}

 
