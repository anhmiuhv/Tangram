package gametest;

import static org.junit.Assert.*;

import org.junit.Test;

import builder.model.KabasujiBuilder;
import builder.model.LevelEditorState;

/**
 * test kabasuji
 * @author lthoang
 *
 */
public class testKabasuji {

	@Test
	public void test() {
		KabasujiBuilder kb = new KabasujiBuilder();
		if (kb.getNumberOfLevel() > 0){
			assertEquals(kb.getLevel(0).getLevelEditorType(), LevelEditorState.PUZZLE);
		}
	}

}
