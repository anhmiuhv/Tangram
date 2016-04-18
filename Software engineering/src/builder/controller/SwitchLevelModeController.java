package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.BoardCreator;
import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.PieceContainer;
import builder.model.PieceCreator;
import builder.model.Puzzle;
import builder.view.LevelEditorView;

public class SwitchLevelModeController implements ActionListener {

	LevelEditorView lv;
	LevelEditor editor;
	JComboBox b;
	public SwitchLevelModeController(LevelEditorView lv, LevelEditor editor, JComboBox b){
		this.lv = lv;
		this.editor = editor;
		this.b = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.editor = new Puzzle(0, new PieceContainer(), new PieceCreator(), new BoardCreator(), 0);
		lv.init();
	}
	/*new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String m = (String) mode.getSelectedItem();
				switch (m){
				case "Puzzle Level":
					m = LevelEditorState.PUZZLE;
					break;
				case "Lightning Level":
					m = LevelEditorState.LIGHTNING;
					break;
				case "Release Level":
					m = LevelEditorState.RELEASE;
					break;
				}
				
				if (!editor.getLevelEditorType().equals(m)){
					switch (m){
					case LevelEditorState.PUZZLE:
						this.editor 
					}
						
				}
			}*/

}
