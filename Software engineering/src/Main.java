import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Kabasuji;
import model.Level;
import model.Player;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;


public class Main {
	static final String gameInfo = "kabasuji.xml";
	
	
	
	/**
	 * get the number of level from xml file
	 * @return number of level
	 * @throws Exception 
	 */
	static int getNumlevel() throws Exception{
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
			throw e;
		}
		return 0;
	}
	
	/**
	 * return the levels used by the game
	 * @param numLevel number of level
	 * @return array of Level
	 */
	static Level[] loadLevel(int numLevel){
		/*
		try
	      {
	         FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Level) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      */
		return new Level[0];
	}
	public static void main (String[] args) {
		
		//get number of Level
		int numLevel;
		try {
			numLevel = getNumlevel();
		} catch (Exception e){
			e.printStackTrace();
			return;
		}
		System.out.print(numLevel);
	//	ArrayList<Level> level = loadLevel(numLevel);
		
		
		
		//Kabasuji kabasuji = new Kabasuji(level);
		//Player m = new Player("Linh", kabasuji);
		
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
