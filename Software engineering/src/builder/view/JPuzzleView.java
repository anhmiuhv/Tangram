package builder.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import builder.model.PieceContainer;
import builder.model.PlacedPiece;

public class JPuzzleView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6844295609697032689L;
	private BufferedImage image;
	JTestFrame app;
	PieceContainer pc;
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	
    public JPuzzleView(PieceContainer pc, JTestFrame app) {
    	this.pc = pc;
    	this.app = app;
       try {                
          image = ImageIO.read(new File("temp/Paint.jpg"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

		if (offScreenImage == null){
			// create on demand
			Dimension s = getSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();
			redraw();
		}

		
         
        g.drawImage(offScreenImage, 0, 0, this);
        PlacedPiece active = pc.getActive();
		if (active != null) {
			g.drawImage(active.getImage(), active.getX(), active.getY(),null);
		}
    }
    
    /** Draw background and then all pieces on top of it. */
	public void redraw() {
		
		
		Dimension dim = getSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);
		
		offScreenGraphics.drawImage(image, 70, 100, null);
		
		// placed pieces.
		if (pc.getSelected() != null) {
			for (PlacedPiece pp : pc.getSelected()) {
				if (pp != pc.getDraggingPiece()) {
					offScreenGraphics.drawImage(pp.getImage(), pp.getX(), pp.getY(),null);
				}
			}
		}		
	}
}
