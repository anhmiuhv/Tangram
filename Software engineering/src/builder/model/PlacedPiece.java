package builder.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import model.Piece;
/**
 * This class represent a placed piece on the test frame
 * @author lthoang
 *
 */
public class PlacedPiece implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3311468800867799182L;
	Piece piece;
	BufferedImage image;
	int x;
	int y;
	Color random;
	Rectangle[] araragi;
	int rotate = 0;

	/**
	 * create a test frame with location
	 * @param piece
	 * @param x
	 * @param y
	 */
	public PlacedPiece(Piece piece, int x, int y){
		this.piece = piece;
		this.x = x;
		this.y = y;
		this.random = this.piece.getColor();
		this.image = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB); 
		Graphics2D g2d = image.createGraphics();
		BasicStroke line = new BasicStroke(2);

		//g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
		araragi = getRectange();
		for (Rectangle r: araragi){
			g2d.setStroke(line);
			g2d.setPaint(Color.BLACK);
			g2d.drawRect((int) r.getX(), (int) r.getY(), (int) r.getHeight(),(int) r.getWidth());
			g2d.setColor(random);
			g2d.fillRect((int) r.getX(), (int) r.getY(), (int) r.getHeight(),(int) r.getWidth());
		}
	}

	/**
	 * get the piece of the placed piece
	 * @return piece
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * set the image of the placed piece
	 * @param image
	 */
	public void setImage(BufferedImage image){
		this.image = image;
	}
	/**
	 * get the image of the piece for the graphics
	 * @return graphics image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * get the x location of the piece
	 * @return
	 */
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	/**
	 * get the y location of the piece
	 * @return
	 */
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	/**
	 * get the rectangle shape of the piece
	 * @return
	 */
	public Rectangle[] getRectange(){
		Rectangle[] r = new Rectangle[6];
		for (int i = 0;i < 6; i++){
			r[i] = new Rectangle(piece.getSquares()[i].getColumn() * 25, piece.getSquares()[i].getRow() * 25, 25, 25);
		}
		return r;
	}

	/**
	 * check if buffered image of the piece contains this points
	 * @param draggingAnchor
	 * @return
	 */
	public boolean contains(Point draggingAnchor) {
		Point offset = new Point(draggingAnchor.x - this.x, draggingAnchor.y - this.y);
		switch (rotate % 4){
		case 1:
			offset.setLocation(offset.getY(), 150 - offset.getX());
			break;
		case 2:
			offset.setLocation(150 - offset.getX(), 150 - offset.getY());
			break;
		case 3:
			offset.setLocation(150 - offset.getY(), offset.getX());
			break;
		}
		boolean result = false;
		for (Rectangle r: araragi){
			result = result || r.contains(offset);
		}
		return result;
	}

	/**
	 * move the piece a certain distance
	 * @param diffX
	 * @param diffY
	 */
	public void translate(int diffX, int diffY) {
		this.x = this.x + diffX;
		this.y = this.y + diffY;

	}

	/**
	 * rotate the piece
	 */
	public void rotate(){
		rotate++;
	}


}
