package builder.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;
import builder.view.LevelEditorView;

public class testEditLevel {
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	
	
	BuilderApplication app;
	//LevelEditorView lvlev;
	@Before
	public void setup(){
		Builder builder = new Builder("linh", new KabasujiBuilder());
		this.app = new BuilderApplication(builder, false);	
		//this.lvlev = this.app.getLvlBuilder().getLvle();
	}
	
	@After
	public  void dispose(){
		this.app.getLvlBuilder().close();
	}
	@Test
	public void test() {
		Robot r;
		try {
			r = new Robot();
			r.setAutoDelay(40);
			r.setAutoWaitForIdle(true);
			r.mouseMove(900, 175);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.mouseMove(200, 165);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
//	public void lockTest(){
//		Robot r;
//		try {
//			r = new Robot();
//			r.setAutoDelay(40);
//			r.setAutoWaitForIdle(true);
//			
//		}
//		catch (AWTException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//	}

}
