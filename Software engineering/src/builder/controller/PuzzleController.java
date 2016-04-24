package builder.controller;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import model.Piece;
import builder.model.PieceContainer;
import builder.model.PlacedPiece;
import builder.view.JPieceContainerView;
import builder.view.JPuzzleView;
import builder.view.JTestFrame;

/**
 * This controller handle the drawing of the board in the test frame
 * @author lthoang
 *
 */
public class PuzzleController extends MouseAdapter implements Action {
	JTestFrame t;
	PieceContainer pc;
	JPuzzleView jpv;
	JPieceContainerView jpc;
	Point draggingAnchor;
	PlacedPiece draggingPiece;


	public PuzzleController(PieceContainer pc, JTestFrame t){
		this.pc = pc;
		this.t = t;
		jpv = t.getPuzzleView();
		jpc = t.getJpc();
	}
	@Override
	public void mouseDragged (MouseEvent me) {
		// if nothing being dragged, leave
		if (draggingPiece == null) {
			return;
		}

		int diffX = me.getPoint().x - draggingAnchor.x;
		int diffY = me.getPoint().y - draggingAnchor.y;
		draggingAnchor = me.getPoint();

		draggingPiece.translate(diffX, diffY);
		jpv.redraw();
		jpv.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent me){
		super.mouseMoved(me);
		Piece selected = pc.getChosen();
		if (selected == null) return;
		PlacedPiece pp = new PlacedPiece(selected, me.getX(), me.getY());
		pc.setActive(pp);
		jpv.repaint();
	}

	/** Determine which piece was selected in the PiecesView. */
	@Override
	public void mousePressed (MouseEvent me) {
		super.mousePressed(me);
		PlacedPiece pp = pc.getActive();
		if (pp == null) {
			draggingAnchor = me.getPoint();

			// perhaps we are pressing inside one of the existing pieces? Take LAST piece that
			// intersects, since that will ensure we grab topmost one.
			for (PlacedPiece exist : pc.getSelected()) {
				if (exist.contains(draggingAnchor)) {
					// perhaps we will be dragging this one. Keep going until last one chosen.
					draggingPiece = exist;
				}
			}
			return;
		}

		pc.setActive(null);    // no longer being dragged around
		pc.setChosen(null);

		pc.addSelected(pp);

		jpv.redraw();   // has changed state

		jpv.repaint();
		//tangramView.repaint();   // has also changed state since piece no longer selected.
	}


	/** Once released, no more dragging. */
	public void mouseReleased(MouseEvent me) {
		draggingPiece = null;
		draggingAnchor = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AffineTransform at = new AffineTransform();

		if (pc.getActive() != null){
			BufferedImage i = pc.getActive().getImage();
			pc.getActive().rotate();
			at.rotate(Math.PI/2, i.getWidth(null) / 2, i.getHeight(null) / 2);
			AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			pc.getActive().setImage(op.filter(pc.getActive().getImage(), null));
			jpv.redraw();
			jpv.repaint();
			return;
		}
		
		if (draggingPiece != null){
			BufferedImage i = draggingPiece.getImage();
			draggingPiece.rotate();
			at.rotate(Math.PI/2, i.getWidth(null) / 2, i.getHeight(null) / 2);
			AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			draggingPiece.setImage(op.filter(i, null));
			jpv.redraw();
			jpv.repaint();
			return;
		}


	}
	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
