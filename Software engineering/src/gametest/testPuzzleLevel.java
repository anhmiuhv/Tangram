package gametest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import builder.test.testAddBoard;
import builder.test.testAddPiece;
import builder.test.testEditLevel;
import builder.test.testEditOldLevel;
import builder.test.testKabasuji;
import builder.test.testLaunch;
import builder.test.testRelease;
import builder.test.testSwitchMode;
import builder.test.testTestFrame;
import model.Kabasuji;
import model.Level;
import model.Player;

public class testPuzzleLevel {
	
	Kabasuji kabasuji;
	@Before
	public void setup(){

		Player player = new Player("player", kabasuji);
		kabasuji.main(null);
	
	}
	@After
	public void dispose(){
	//
	}
	@Test
	public void test(){
		Robot r; //set robot for Kabasuji Player
		try {
//------puzzle level test
				r = new Robot();
				r.setAutoDelay(40);
				r.setAutoWaitForIdle(true);
				
				
				
				
				r.mouseMove(140, 303); //test more than 8 moves
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(114,203); // use first piece to test moves
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(524, 267);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(551,275);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(560, 299);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(560,299); 
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(554, 329);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(554,329); 
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(554, 354);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(554,354); 
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(524, 385);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(524,385);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(524,418);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(524,418);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(524,385);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(524,385);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(524,359);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				

				r.mouseMove(531,513);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				
				r.mouseMove(140,303);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(464, 669);// test 4 flip buttons
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.mouseMove(594, 669);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.mouseMove(686, 705);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.mouseMove(555, 718);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.mouseMove(464, 669);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.mouseMove(594, 669);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				
				
				r.mouseMove(114,203); // test First piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(524, 267);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				
				r.mouseMove(253, 206); //test invalid move
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(700, 200);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(253, 206); //test invalid move
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(555, 264);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(253, 206); //test second piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(499, 301);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(37, 390); //test third piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(461, 357);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(260, 395); //test fourth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(515, 325);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(76, 636);//fifth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(585, 325);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(287, 634); //sixth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(620, 388);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(55, 107); //exit current level
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.mouseMove(975, 486);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				
				
				
//----lightning level test	

				r.mouseMove(247,299); //start lightning level
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				//r.delay(31000); //wait 31 seconds to invoke failed 
				
				r.mouseMove(500,500);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(247,299);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(133,203); // test First piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(544, 264);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				r.delay(500);
				
				r.mouseMove(225, 204); //test second piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(461, 297);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(217, 384); //test third piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(463, 355);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(77, 402); //test fourth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(518, 330);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(103, 574);//fifth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(618, 302);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(294, 576); //sixth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(614, 355);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(58, 121); //quit current level
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				r.mouseMove(950, 487);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				
				
//------Release Level Test
				
				r.mouseMove(358,296); //start lightning level
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				
				
				r.mouseMove(133,203); // test First piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(544, 264);
				r.mouseRelease(InputEvent.BUTTON1_MASK); 
				r.delay(500);
				
				r.mouseMove(225, 204); //test second piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(461, 297);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(217, 384); //test third piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(493, 328);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(40, 395); //test fourth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(465, 362);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(103, 574);//fifth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(618, 302);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.delay(500);
				
				r.mouseMove(294, 576); //sixth piece
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseMove(614, 355);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				
				
				
//-------Builder Part Tets and Model Test
				testAddBoard t1 = new testAddBoard();
				testAddPiece t2 = new testAddPiece();
				testEditLevel t3 = new testEditLevel();
				testEditOldLevel t4 = new testEditOldLevel();
				testKabasuji t5 = new testKabasuji();
				testLaunch t6 = new testLaunch();
				testTestFrame t7 = new testTestFrame();
				testLaunch t8 = new testLaunch();
				testRelease t9 = new testRelease();
				testSwitchMode t10 = new testSwitchMode();
				 t1.setup();
				 t1.test();
				 t2.setup();
				 t2.test();
				 t3.setup();
				 t3.test();
				 t4.setup();
				 t4.test();
				 t6.test();
				 t7.setup();
				 t7.test();
				 t8.test();
				 t9.setup();
				 t9.test();
				 t10.test();
				 Gametest t = new Gametest();
				 t.Shouldreturnwhatitneeds();
				 
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}
		
	
	
		
		
}
