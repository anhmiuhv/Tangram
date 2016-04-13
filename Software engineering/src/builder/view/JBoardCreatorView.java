package builder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Square;
import builder.model.BoardCreator;
import builder.model.LevelEditor;

import javax.swing.JLabel;

public class JBoardCreatorView extends JPanel {

	private LevelEditor lvle;
	private BoardCreator bc;
	JSquareView[] squareV = new JSquareView[144];
	JLabel count;
	/**
	 * Create the panel.
	 */
	public JBoardCreatorView(LevelEditor lvle) {
		this.lvle = lvle;
		this.bc = lvle.getBoardCreator();
		init();
	}

	
	private void init(){
		Square[] squareToDisplay = bc.getSquares();
		boolean[] selectedSquare = bc.getSelected();

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 300, 300);
		add(panel);
		panel.setLayout(new GridLayout(12, 12, 0, 0));

		for (int i = 0; i < 144; i++){
			if (selectedSquare[i]){
				squareV[i] = new JSquareView(squareToDisplay[i], Color.GRAY, 25);
			} else {
				squareV[i] = new JSquareView(squareToDisplay[i], Color.WHITE, 25);
			}
			panel.add(squareV[i]);
		}


		setOpaque(false);
		setLayout(null);
		
		count = new JLabel("Squares:");
		count.setBounds(315, 6, 61, 16);
		add(count);





	}
}
