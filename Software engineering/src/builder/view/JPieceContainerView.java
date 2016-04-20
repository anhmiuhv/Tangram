package builder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Piece;
import view.JPieceView;
import builder.controller.DeletePieceController;
import builder.model.*;

/**
 * This class represent a piece container view
 * @author lthoang
 *
 */
public class JPieceContainerView extends JPanel {
											
	LevelEditor lvl;
	PieceContainer pc;
	/**
	 * individual pieces
	 */
	ArrayList<JPieceView> jp = new ArrayList<JPieceView>();
	ArrayList<Piece> pieces;
	/**
	 * number of pieces
	 */
	int pNum = 0;
	int PCXcount =0;
	int PCycount =0;
	/**
	 * position of view
	 */
	int bpX;
	/**
	 * position of view
	 */
	int bpY;
	ArrayList<JButton> delete;
		
	public JPieceContainerView(LevelEditor lvl) {
		this.lvl = lvl;
		pc = lvl.getPieceContainer();
		createJPieceContainerView();
	}
	
	/**
	 * setup the view
	 */
	private void createJPieceContainerView(){

		//setBounds(bpX,bpY,180*2+15,180*3+20);
		setPreferredSize(new Dimension(180*2+30,180*20+20));

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		pieces = pc.getPieces();
		pNum = pieces.size();
		
		delete = new ArrayList<JButton>();
		for(int i = 0; i< pNum;i++){
			if (i % 2 == 0){
				PCXcount=0;
			}
			jp.add(new JPieceView(pieces.get(i), (180 + 20) * PCXcount + 5, ((int) (i / 2)) * (180 + 5) + 5));
			delete.add(new JButton("delete"));
			delete.get(i).setBounds((180 + 20) * PCXcount + 5, ((int) (i / 2)) * (180 + 5) + 5, 60, 20);
			delete.get(i).addActionListener(new DeletePieceController(lvl, this, i));
			PCXcount++;
			add(delete.get(i));
			add(jp.get(i));
		}
		
		//scrollPane.setViewportView(this);
	}
	
	/**
	 * update the view
	 */
	public void update(){
		removeAll();
		jp = new ArrayList<JPieceView>();
		pieces = pc.getPieces();
		pNum = pieces.size();
		delete = new ArrayList<JButton>();
		for(int i = 0; i< pNum;i++){
			if (i % 2 == 0){
				PCXcount=0;
			}
			jp.add(new JPieceView(pieces.get(i), (180 + 20) * PCXcount + 5, ((int) (i / 2)) * (180 + 5) + 5));
			delete.add(new JButton("delete"));
			delete.get(i).setBounds((180 + 20) * PCXcount + 5, ((int) (i / 2)) * (180 + 5) + 5, 60, 20);
			delete.get(i).addActionListener(new DeletePieceController(lvl, this, i));
			PCXcount++;
			add(delete.get(i));
			add(jp.get(i));
		}
		
	}
}
