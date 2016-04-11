package builder.view;

import builder.model.PieceCreator;
import builder.model.Puzzle;

public class Test {
	public static void main(String[] args){
			Puzzle n = new Puzzle(null, new PieceCreator(), null, 0);
			JPieceCreatorView jpcv = new JPieceCreatorView(n);
			
	}
}
