import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import java.io.*;

import javax.swing.*;

import model.*;


public class Main {
	static final String gameInfo = "kabasuji.xml";
	static void setNumlevel(int num){
		
	}
	
	
	static int getNumlevel(){
		return 0;
	}
	
	public static void main (String[] args) {
		
		Kabasuji kabasuji = new Kabasuji();
		Player m = new Player("Linh", kabasuji);
		
		
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