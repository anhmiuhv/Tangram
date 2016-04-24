package builder.model;

import java.io.File;
import java.util.ArrayList;

/**
 * This class represent all of the editoes can be chosen
 * @author lthoang
 *
 */
public class KabasujiBuilder {
	
	/** array of editor*/
	ArrayList<LevelEditor> editor;
	
	/**
	 * create a KabasujiBuilder
	 * @param editor the number the Kabasuji builder manage
	 */
	public KabasujiBuilder(ArrayList<LevelEditor> editor){
		this.editor = editor;
	}
	
	/**
	 * Load kabasuji builder from default location (/leveleditor/)
	 */
	public KabasujiBuilder(){
		this.editor = loadAll();
	}
	
	/**
	 * Return level
	 * @param i order
	 * @return level order i
	 */
	public LevelEditor getLevel(int i){
		System.out.println(editor.size());
		return editor.get(i);
	}
	
	/**
	 * return the number of editors
	 * @return number of editors
	 */
	public int getNumberOfLevel(){
		return editor.size();
	}
	
	/**
	 * Add editor to the builder
	 * @return levelNum
	 */
	public int addLevelState(){
		int levelNum = editor.size();
		editor.add(new Puzzle(levelNum, new PieceContainer(), new PieceCreator(), new BoardCreator(), 0));
		return levelNum;
	}
	
	/**
	 * load the editor from default location
	 * @return array of editors
	 */
	public ArrayList<LevelEditor> loadAll(){
		ArrayList<LevelEditor> all = new ArrayList<LevelEditor>();

		try{
			File dir = new File("leveleditor/");
			File[] directoryListing = dir.listFiles();
			if(directoryListing != null){  // Use default level directory to create buttons
				for(File child : directoryListing){
					if (child.getName().equals(".DS_Store")) continue;
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
	
	/**
	 * replace location of the array with the given editor
	 * @param order order
	 * @param editor editor
	 * @return true if successfull
	 */
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
