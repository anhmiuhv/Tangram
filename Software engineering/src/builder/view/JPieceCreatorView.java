package builder.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import builder.model.*;

public class JPieceCreatorView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7437149537257431547L;
	
	private LevelEditor lvle;
	private PieceCreator pc;
	JSquareView[] squareV = new JSquareView[36];
	/**
	 * Create the panel.
	 */
	public JPieceCreatorView(LevelEditor lvle) {
		this.lvle = lvle;
		this.pc = lvle.getPieceCreator();
		
		Square[] squareToDisplay = pc.getSquares();
		boolean[] selectedSquare = pc.getSelected();
		
		for (int i = 0; i < 36; i++){
			if (selectedSquare[i]){
				squareV[i] = new JSquareView(squareToDisplay[i], Color.GRAY);
			} else {
				squareV[i] = new JSquareView(squareToDisplay[i], Color.WHITE);
			}
			add(squareV[i]);
		}
		
		setBounds(65, 94, 180, 180);
		setOpaque(false);
		setLayout(null);


	}
}
