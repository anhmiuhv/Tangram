package gametest;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;
import builder.view.LevelEditorView;

/**
 * test switching mode
 * @author lthoang
 *
 */
public class testSwitchMode {

	BuilderApplication app;
	//LevelEditorView lvlev;

	public Point translate (int x, int y) {
		LevelEditorView frame = app.getLvlBuilder().getLvle();
		JPanel panel = frame.getPanel();
		Point p = SwingUtilities.convertPoint(panel, x, y, frame);
		p.translate(frame.getX(), frame.getY());
		return p;
	}

	
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
			r.delay(300);
			Point mode = this.app.getLvlBuilder().getLvle().getMode().getLocation();
			mode = translate((int) mode.getX(),(int) mode.getY());
			r.mouseMove(mode.x, mode.y);
			
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(500);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(500);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(500);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.delay(500);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(500);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
