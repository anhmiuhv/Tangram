package builder.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import model.Piece;

public class PlacedPiece {
	Piece piece;
	BufferedImage image;
	int x;
	int y;
	Color random = Color.CYAN;
	Rectangle[] araragi;
	int rotate = 0;
	
	public PlacedPiece(Piece piece, int x, int y){
		this.piece = piece;
		this.x = x;
		this.y = y;
		this.image = new BufferedImage(140, 140, BufferedImage.TYPE_INT_ARGB); 
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

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

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
			r[i] = new Rectangle(piece.getSquares()[i].getColumn() * 23, piece.getSquares()[i].getRow() * 23, 23, 23);
		}
		return r;
	}

	public boolean contains(Point draggingAnchor) {
		Point offset = new Point(draggingAnchor.x - this.x, draggingAnchor.y - this.y);
		if (rotate % 4 == 1){
			offset.setLocation(offset.getY(), 140 - offset.getX());
		}
		
		if (rotate % 4 == 2){
			offset.setLocation(140 - offset.getX(), 140 - offset.getY());
		}
		
		if (rotate % 4 == 3){
			offset.setLocation(140 - offset.getY(), offset.getX());
		}

		boolean result = false;
		for (Rectangle r: araragi){
			result = result || r.contains(offset);
		}
		return result;
	}

	public void translate(int diffX, int diffY) {
		this.x = this.x + diffX;
		this.y = this.y + diffY;
		
	}
	
	public void rotate(){
		rotate++;
	}
	
	
}
