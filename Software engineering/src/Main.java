import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Kabasuji;
import model.Player;

import org.w3c.dom.*;



import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import java.io.*;

import javax.swing.*;


public class Main {
	static final String gameInfo = "kabasuji.xml";
	
	
	
	/**
	 * get the number of level from xml file
	 * @return number of level
	 */
	static int getNumlevel(){
		int levelnum;
		try{
			File inputFile = new File(gameInfo);
			DocumentBuilderFactory dbFactory 
			= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("levelnum");
			Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               levelnum = Integer.parseInt(eElement.getAttribute("num"));
	               return levelnum;
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main (String[] args) {
		
		Kabasuji kabasuji = new Kabasuji();
		Player m = new Player("Linh", kabasuji);
		
		/*
		// if using 'app' within the anonymous class generated below, must be marked final.
		//final Application app = new Application(m);

		// state how to deal with leaving
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				app.dispose();
			}      
		});

		app.setVisible(true)
		*/
	}
	
}	