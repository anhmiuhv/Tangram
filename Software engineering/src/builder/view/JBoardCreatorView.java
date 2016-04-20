package builder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Hint;
import model.Square;
import builder.controller.CreateBoardController;
import builder.controller.CreatePieceController;
import builder.controller.SelectBoardTileController;
import builder.model.BoardCreator;
import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Release;

import javax.swing.JLabel;

/**
 * This class represent the board creator view
 * @author lthoang
 *
 */
public class JBoardCreatorView extends JPanel {

	private LevelEditor lvle;
	private BoardCreator bc;
	JSquareView[] squareV = new JSquareView[144];
	JLabel count;
	JLabel lblNotCreated;
	/**whether the board creator is in hint mode*/
	boolean hintMode;
	/**
	 * in hint mode or not
	 * @return true if in hint mode
	 */
	public boolean isHintMode() {
		return hintMode;
	}

	/**
	 * set the hintmode
	 * @param hintMode
	 */
	public void setHintMode(boolean hintMode) {
		this.hintMode = hintMode;
	}


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

		boolean isHintSquare[] = bc.getIsHintSquare();
		
		
		for (int i = 0; i < 144; i++){
			if (selectedSquare[i]){
				squareV[i] = new JSquareView(squareToDisplay[i], Color.BLACK, 25);
			} else {
				squareV[i] = new JSquareView(squareToDisplay[i], Color.WHITE, 25);
			}
			if (isHintSquare[i]){
				squareV[i].setHint(true);
			}
			squareV[i].addMouseListener(new SelectBoardTileController(lvle, this, squareV[i]));
			if (lvle.getLevelEditorType().equals(LevelEditorState.RELEASE)){
				int numLabel = ((Release) lvle).getSquareNum()[i];
				Color c = ((Release) lvle).getColorNum()[i];
				
				squareV[i].paintColorNum(numLabel, c);
			}
			panel.add(squareV[i]);
		}


		setOpaque(false);
		setLayout(null);
		
		count = new JLabel("<html>Squares: <br>" + bc.getNumSelect() +"</html>");
		count.setBounds(315, 6, 61, 32);
		add(count);
		
		ImageIcon addLevel = new ImageIcon("images//addLevel.png");
		JButton addButton = new JButton();
		addButton.setBounds(316,70,60,60);
		addButton.setIcon(addLevel);
		addButton.addActionListener(new CreateBoardController(lvle, this));
		add(addButton);
		
		lblNotCreated = new JLabel(bc.isBoardCreated());
		lblNotCreated.setBounds(318, 142, 83, 16);
		add(lblNotCreated);
		
		
		
		/*
			sv[i].setBounds(h.getHintSquares()[i].getColumn()*30,h.getHintSquares()[i].getRow()*30,30,30);
			sv[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
			bv.add(sv[i]);
*/

	}
	
	/**
	 * update things
	 */
	public void update(){
		count.setText("<html>Squares: <br>" + bc.getNumSelect() +"</html>"); 
		lblNotCreated.setText(bc.isBoardCreated());
		for (int i = 0; i < 144; i++){
			squareV[i].paintSquare();
		}
	}
}
