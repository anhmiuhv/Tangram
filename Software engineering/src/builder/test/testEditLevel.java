package builder.test;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;

import javax.swing.JComponent;


import org.junit.Before;
import org.junit.Test;

import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;

public class testEditLevel {
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createPressed (JComponent game, JComponent view, int dx, int dy) {
		MouseEvent me = new MouseEvent(game, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				view.getX()+dx, view.getY()+dy, 0, false);
		return me;
	}
	
	BuilderApplication app;
	@Before
	public void setup(){
		Builder builder = new Builder("linh", new KabasujiBuilder());
		this.app = new BuilderApplication(builder);	
	}
	
	@Test
	public void test() {
		//MouseEvent me =createPressed(this.app.lvlBuilder.getComponentAt(741, 26)))
	}

}
