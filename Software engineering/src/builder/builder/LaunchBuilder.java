package builder.builder;
import java.util.ArrayList;

import builder.model.*;
import builder.view.*;


public class LaunchBuilder {

	public static void main(String[] args) {
		ArrayList<LevelEditor> editor = new ArrayList<LevelEditor>();
		editor.add(new Puzzle(null, new PieceCreator(), null, 0));
		Builder builder = new Builder("linh", new KabasujiBuilder(editor));
		BuilderApplication app = new BuilderApplication(builder);	
	}
}
