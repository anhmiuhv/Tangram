package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Square;
/**
 * represent a square, the smallest unit of piece and board
 * @author kdai
 * @author jshen3
 * @author xwang111 
 *
 */
public class JSquareView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3050748323372552414L;
	Square square;
	Color cl;
	JPanel topJPanel;


	public JSquareView(Square square,Color cl){
		this.square = square;
		this.cl = cl;
		paintSquare();
	}



	private void paintSquare() {
		setBackground(cl);
		setBounds(square.getColumn()*30,square.getRow()*30,30,30);

		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
	}

	/**
	 * draw the color number
	 * @param num
	 * @param c
	 */
	public void paintColorNum(int num,Color c) {
		JLabel lblNewLabel = new JLabel(""+num);

		lblNewLabel.setForeground(c);
		lblNewLabel.setBounds(0, 0, 30, 30);
		add(lblNewLabel);

	}


}
