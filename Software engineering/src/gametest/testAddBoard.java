package gametest;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JButton;
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
 * test creating board
 * @author lthoang
 *
 */
public class testAddBoard {

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
	
	public Point translate (int x, int y) {
		LevelEditorView frame = app.getLvlBuilder().getLvle();
		JPanel panel = frame.getPanel();
		Point p = SwingUtilities.convertPoint(panel, x, y, frame);
		p.translate(frame.getX(), frame.getY());
		return p;
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

			for (int i = 670; i < 670 + 25 * 6; i = i +25){
				r.mouseMove(i, 370);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			r.mouseMove(150, 640);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

			for (int i = 670; i < 670 + 25 * 6; i = i +25){
				r.mouseMove(i, 370);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}

			r.mouseMove(1000, 450);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			for (int i = 0; i < 17; i++){
				//r.mouseMove(300, 140);
				JButton undo = app.getLvlBuilder().getLvle().getUndoButton();
				System.out.println("raw:" + undo.getX() + ":" + undo.getY());
				Point up = translate(undo.getX(), undo.getY());
				System.out.println("  --> " + up.x + "," + up.y);
				r.mouseMove(up.x, up.y);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}


}
