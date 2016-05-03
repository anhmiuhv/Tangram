package builder.test;

import static org.junit.Assert.*;

import java.awt.Point;

import model.Piece;
import model.Square;

import org.junit.Before;
import org.junit.Test;

import builder.model.PlacedPiece;

/**
 * test placed piece
 * @author lthoang
 *
 */
public class testPlacedPiece {
	PlacedPiece n;
	Piece p;
	@Before
	public void setup(){
		Square bullPenSquare1[] = new Square[6]; 
		bullPenSquare1[0] = new Square(1,3);
		bullPenSquare1[1] = new Square(0,1);
		bullPenSquare1[2] = new Square(0,2);
		bullPenSquare1[3] = new Square(0,3);
		bullPenSquare1[4] = new Square(0,4);
		bullPenSquare1[5] = new Square(0,5);
		p = new Piece(0, 0, bullPenSquare1, bullPenSquare1[0], 0);
	}
	
	@Test
	public void test() {
		n = new PlacedPiece(p, 0, 0);
		assertEquals(n.getPiece(),p);
		assertTrue(!n.contains(new Point(0, 0)));
		assertEquals(n.getX(), 0);
		n.translate(0, 10);
		assertEquals(n.getY(),10);
	}

}
