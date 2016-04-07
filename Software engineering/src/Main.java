import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import model.Kabasuji;
import model.Player;


public class Main {
	public static void main (String[] args) {
		Player m = new Player("Linh", new Kabasuji());
		
		
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
	
}	