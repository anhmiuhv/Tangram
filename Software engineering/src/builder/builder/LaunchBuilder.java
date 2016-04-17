package builder.builder;
import java.io.File;
import java.util.ArrayList;
import builder.model.*;
import builder.view.*;


public class LaunchBuilder {

	public static void main(String[] args) {
		LaunchBuilder launcher = new LaunchBuilder();
		ArrayList<LevelEditor> editor = launcher.loadAll();
		Builder builder = new Builder("linh", new KabasujiBuilder(editor));
		BuilderApplication app = new BuilderApplication(builder);	
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
}
