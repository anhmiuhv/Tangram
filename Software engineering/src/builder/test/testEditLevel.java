package builder.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import org.junit.Before;
import org.junit.Test;

import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;

public class testEditLevel {
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	
	
	BuilderApplication app;
	@Before
	public void setup(){
		Builder builder = new Builder("linh", new KabasujiBuilder());
		this.app = new BuilderApplication(builder);	
	}
	
	@Test
	public void test() {
		Robot r;
		try {
			r = new Robot();
			r.mouseMove(900, 175);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
