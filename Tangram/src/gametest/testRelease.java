package gametest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import builder.model.*;

/**
 * test release level
 * @author lthoang
 *
 */
public class testRelease {
	Release r;
	LevelEditorState les;
	@Before
	public void setup(){
		les = new LevelEditorState();
		les.loadState("test/les1.sav");
		
	}
	
	@Test
	public void test() {
		r = new Release(les);
		r.createLevelEditorState();
		assertEquals(r.getLevelEditorType(), LevelEditorState.RELEASE);
		r.createActualSquareNum(les.getBoard());
		r.createLevelEditorState();
		les = r.getLes();
		assertEquals(les.getActualSquareNum().length, 36);
		Release copyr = new Release(r.getLevelNum(), r.getPieceContainer(), r.getPieceCreator(), r.getBoardCreator(), r.getSquareNum(), r.getColorNum(), r.getColoredNum());
		assertEquals(r.getSquareNum(), copyr.getSquareNum());
	}

}
