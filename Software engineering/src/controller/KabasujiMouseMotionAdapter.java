package controller;

import view.LevelView;

public class KabasujiMouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
	
	LevelView lv;
	
	public KabasujiMouseMotionAdapter(LevelView levelView){
		this.lv = levelView;
	}
	
	@Override
	public void mouseDragged(java.awt.event.MouseEvent me) {
		if(lv.getDraggingPieceView() == null){
			return;
		}
		lv.getDraggingPieceView().setLocation(me.getPoint().x - lv.getDiffx(), me.getPoint().y - lv.getDiffy());
	}
}
