package builder.model;

import java.util.ArrayList;

public class KabasujiBuilder {
	ArrayList<LevelEditor> editor;
	
	public KabasujiBuilder(ArrayList<LevelEditor> editor){
		this.editor = editor;
	}
	
	public int getNumberOfLevel(){
//		return editor.size();
		return 19;
	}
}
