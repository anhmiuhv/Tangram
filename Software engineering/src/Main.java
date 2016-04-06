import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class Main {
	public static void main (String[] args) {
		Model m = new Model();
		
		
		// if using 'app' within the anonymous class generated below, must be marked final.
		final Application app = new Application(m);

		// state how to deal with leaving
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true);
	}
	
	// hi I am thomas