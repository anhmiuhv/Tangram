package controller;

import view.JPieceView;
import view.LevelView;

public class KabasujiMouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
	
	LevelView lv;
	
	public KabasujiMouseMotionAdapter(LevelView levelView){
		this.lv = levelView;
	}
	
	@Override
	public void mouseDragged(java.awt.event.MouseEvent me) {
		lv.draggingPiece.setLocation(me.getPoint().x - lv.diffx, me.getPoint().y - lv.diffy);
	}
}
