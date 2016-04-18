package builder.model;

import java.io.File;
import java.util.ArrayList;

public class KabasujiBuilder {
	ArrayList<LevelEditor> editor;
	
	public KabasujiBuilder(ArrayList<LevelEditor> editor){
		this.editor = editor;
	}
	
	public KabasujiBuilder(){
		this.editor = loadAll();
	}
	
	public LevelEditor getLevel(int i){
		System.out.println(editor.size());
		return editor.get(i);
	}
	
	public int getNumberOfLevel(){
		return editor.size();
	}
	
	public ArrayList<LevelEditor> loadAll(){
		ArrayList<LevelEditor> all = new ArrayList<LevelEditor>();

		try{
			File dir = new File("leveleditor/");
			File[] directoryListing = dir.listFiles();
			if(directoryListing != null){  // Use default level directory to create buttons
				for(File child : directoryListing){
					LevelEditorState tmp = new LevelEditorState();
					tmp.loadState(child.getName());
					String levelType = tmp.getLevelType();
					if(levelType != null){
						LevelEditor newLevel = null;
						if(levelType.equals(LevelEditorState.PUZZLE)){
							newLevel = new Puzzle(tmp);
						} else if(levelType.equals(LevelEditorState.LIGHTNING)) {
							newLevel = new Lightning(tmp);
						} else if(levelType.equals(LevelEditorState.RELEASE)) {
							newLevel = new Release(tmp);			
						}
						all.add(newLevel);
					}
					
					
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return all;

	}
	
	public boolean replace(int order, LevelEditor editor){
		try{
			this.editor.remove(order);
			this.editor.add(order, editor);
			return true;
		} catch (Exception e){
			return false;
		}
	}
}
