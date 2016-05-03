package builder.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;

/**
 * test test frame
 * @author lthoang
 *
 */
public class testTestFrame {

	BuilderApplication app;
	@Before
	public void setup(){
		Builder builder = new Builder("linh", new KabasujiBuilder());
		this.app = new BuilderApplication(builder,false);	
	}

	@After
	public void dispose(){
		this.app.getLvlBuilder().getLvle().close();
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

			for (int i = 150; i < 150 + 30 * 6; i = i +30){
				r.mouseMove(i, 450);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			
			r.mouseMove(150 + 30 * 6 + 90, 540);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			
			r.mouseMove(150 + 229, 640);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


}
