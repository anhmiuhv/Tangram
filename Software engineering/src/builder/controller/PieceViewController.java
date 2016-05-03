package builder.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Piece;
import builder.model.PieceContainer;
import builder.model.PlacedPiece;
import builder.view.JPieceView;
import builder.view.JTestFrame;

/**
 * This class control the piece view in the test frame
 * @author lthoang
 *
 */
public class PieceViewController implements MouseListener {

	PieceContainer pc;
	int idx;
	JPieceView k;
	JTestFrame t;
	public PieceViewController(PieceContainer pc, int idx, JPieceView k, JTestFrame t){
		this.pc = pc;
		this.idx = idx;
		this.k = k;
		this.t = t;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (pc.getChosen() == k.getPiece()){
			k.setBackground(null);
			pc.setChosen(null);
		} else {
			Piece select = k.getPiece();
			for (PlacedPiece pp : pc.getSelected()) {
				if (pp.getPiece() == select) { 
					pc.setChosen(null);
					pc.getSelected().remove(pp);
					k.setBackground(null);
					t.getPuzzleView().redraw();
					t.getPuzzleView().repaint();
					return;
					
				}
			}
			k.setBackground(Color.blue);
			pc.setChosen(select);
		}
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
