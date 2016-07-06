package controller;

import view.LevelView;
/**
 * the mouse motion adapter for handling the dragging
 * @author jshen3, kdai, xwang11
 *
 */
public class KabasujiMouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
	
	LevelView lv;
	
	public KabasujiMouseMotionAdapter(LevelView levelView){
		this.lv = levelView;
	}
	
	@Override
	/**
	 * handling the dragging
	 */
	public void mouseDragged(java.awt.event.MouseEvent me) {
		if(lv.getDraggingPieceView() == null){
			return;
		}
		lv.getDraggingPieceView().setLocation(me.getPoint().x - lv.getDiffx(), me.getPoint().y - lv.getDiffy());
	}
}
