package builder.view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPolyPanel extends JPanel {
	/**
	 * 
	 */
	
	Rectangle[] a;
	private static final long serialVersionUID = -7697828858104673437L;
	public DrawPolyPanel(){
		
	}
	
	public DrawPolyPanel(Rectangle[] r){
		this.a = r;
	}
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Polygon p = new Polygon();
    for (int i = 0; i < 5; i++)
      p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
          (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

    g.drawPolygon(p);

    Polygon s = new Polygon();
    for (int i = 0; i < 360; i++) {
      double t = i / 360.0;
      s.addPoint((int) (150 + 50 * t * Math.cos(8 * t * Math.PI)),
          (int) (150 + 50 * t * Math.sin(8 * t * Math.PI)));
    }
    g.drawPolygon(s);
    for (Rectangle h: a){
    	g.drawRect((int)h.getX(), (int)h.getY(), (int)h.getWidth(), (int)h.getHeight());
    }
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("DrawPoly");
    frame.setSize(350, 250);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    contentPane.add(new DrawPolyPanel());

    frame.show();
  }
}