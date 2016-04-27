package gametest;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import model.Achievement;
import model.Board;
import model.Bullpen;
import model.Hint;
import model.Kabasuji;
import model.Level;
import model.LevelState;
import model.LightningLevel;
import model.Piece;
import model.Player;
import model.PuzzleLevel;
import model.ReleaseLevel;
import model.Square;

public class Gametest{

	
	
	
	
	@Test
	public void ShouldreturnStarNum(){
		//Given
		int star = 1;
		int sRow = 1;
		int sColumn = 1;
		
		Square[] sq = new Square[6];
		sq[0] = new Square(0,0);
		sq[1] = new Square(1,0);
		sq[2] = new Square(2,0);
		sq[3] = new Square(3,0);
		sq[4] = new Square(4,0);
		sq[5] = new Square(5,0);
		
		ArrayList<Piece> pca = new ArrayList<Piece>();
		pca.add(new Piece(0, 0,sq,sq[0],2));
		pca.add(new Piece(0, 0,sq,sq[0],2));
		pca.add(new Piece(0, 0,sq,sq[0],2));
		pca.add(new Piece(0, 0,sq,sq[0],2));
		pca.add(new Piece(0, 0,sq,sq[0],2));
		pca.add(new Piece(0, 0,sq,sq[0],2));
		
		int tName = 1;
		Square head = sq[0];
		Color cl;
		int levelNum = 1;
		String a;
		String levelType = "puzzle";
		int allowedMove =10;
		int allowedTime = 100;
		boolean locked = false;
		int[] i = new int[10];
		Color[] c = new Color[10];
		String playerName = "KAMI";
		Level[] lv = new Level[3];
		Board bd = new Board();
		Bullpen bp2 = new Bullpen(pca);
		lv[0] = new PuzzleLevel(levelNum, "puzzle", bd, bp2, allowedMove);
		lv[1] = new ReleaseLevel(levelNum, "release", bd, bp2, i,c);
		lv[2] = new LightningLevel(allowedTime, playerName, bd, bp2, allowedTime);
		Kabasuji kabasuji = null;
		Square tsq = new Square(sColumn,sRow);
		Square tsq2 = new Square(sColumn,sRow);
		Hint ht = new Hint(sq);
		Achievement achieve = new Achievement(1);
		Piece pc = new Piece(sRow,sColumn,sq,sq[0],1);
		Board bd2 = new Board(sq);
		LevelState lvstt = new LevelState();
		LevelState lvstt2 = new LevelState(levelNum,"a",bd2,allowedMove,allowedTime,locked, achieve, bp2, null, null);
		PuzzleLevel pzlv = new PuzzleLevel(levelNum,levelType,bd2,bp2,allowedMove);
		LightningLevel lnlv = new LightningLevel(levelNum,"lightning",bd2,bp2,allowedTime);
		ReleaseLevel rlslv = new ReleaseLevel(levelNum,"release",bd2,bp2,i,c);
		
		
		
		
		
		
		
		//When
		pc.setColor(Color.BLUE);//
		bd2.sethint(ht);
		lvstt2.setLevelNum(levelNum);//
		lvstt2.setLevelType(levelType);//
		lvstt2.setBoard(bd2);//
		lvstt2.setAllowedMove(allowedMove);//
		lvstt2.setAllowedTime(allowedTime);//
		lvstt2.setLocked(locked);//
		lvstt2.setAchievements(achieve);//
		lvstt2.setBullpen(bp2);//
		lvstt2.setSquareNum(i);//
		lvstt2.setCl(c);
		
		pzlv.createLevelState();
		pzlv.loadLevelState(lvstt2);
		lnlv.createLevelState();
		lnlv.loadLevelState(lvstt2);
		rlslv.createLevelState();
		rlslv.loadLevelState(lvstt2);
		lvstt2.saveState();
		lvstt2.loadState(null);
		
		tsq.getVisit();
		Assert.assertFalse(tsq.getVisit());
		tsq.setColumn(sColumn);//
		tsq.setRow(sRow);//
		bd2.addpiece(pc);//
		Assert.assertTrue(bd2.addpiece(pc));
		bd2.removepiece(pc);//
		Assert.assertTrue(bd2.removepiece(pc));
		pc.getHead();//
		Assert.assertEquals(pc.getHead(),sq[0]);
		pc.containSquare(tsq);//
		Assert.assertFalse(pc.containSquare(tsq));
		
		pc.allVisited();
		Assert.assertFalse(pc.allVisited());
		pc.isPiece();
		Assert.assertTrue(pc.isPiece());
		pzlv.getLevelState();//
		Assert.assertEquals(pzlv.getLevelState(),lvstt2);
		pzlv.getlevelTypeNum();//
		Assert.assertEquals(pzlv.getlevelTypeNum(), 0);
		pzlv.getAchievement();//
		Assert.assertEquals(pzlv.getAchievement(), achieve);
		pzlv.getBullpen();
		Assert.assertEquals(expected, actual);
		pzlv.getBoard();
		pzlv.getLevelNumber();
		pzlv.getLevelType();
		lnlv.getlevelTypeNum();
		rlslv.getlevelTypeNum();
		pzlv.updateLevelStar(achieve);
		bp2.setPieceSelected(1);
		bp2.removePiece(1);
		kabasuji.main(null);
		//Then
		Assert.assertEquals(achieve.getAchievement(),star);
		Assert.assertEquals(pc.getname(), tName);
		Assert.assertArrayEquals(sq,pc.getSquares());
		Assert.assertEquals(pc.getColor(),Color.BLUE);
		Assert.assertEquals(tsq.getColumn(), sColumn);
		Assert.assertEquals(tsq.getRow(),sRow);
		Assert.assertEquals(pc.getpColumn(),sColumn);
		Assert.assertEquals(pc.getpRow(),sRow);
		Assert.assertArrayEquals(ht.getHintSquares(), sq);
		Assert.assertArrayEquals(bd2.getSquare(), sq);
		Assert.assertEquals(bd2.getHint(), ht);
		Assert.assertEquals(bp2.getPieces(),pca);
		Assert.assertEquals(lvstt2.getLevelNum(), levelNum);
		Assert.assertEquals(lvstt2.getLevelType(), levelType);
		Assert.assertEquals(bd2,lvstt2.getBoard());
		Assert.assertEquals(lvstt2.getAllowedMove(),allowedMove);
		Assert.assertEquals(lvstt2.getAllowedTime(),allowedTime);
		Assert.assertEquals(lvstt2.getLocked(),locked);
		Assert.assertEquals(lvstt2.getCl(),c);
		Assert.assertEquals(lvstt2.getAchievement(),achieve);
		Assert.assertEquals(lvstt2.getBullpen(), bp2);
		Assert.assertEquals(lvstt2.getSquareNum(), i);
		Assert.assertEquals(pzlv.hasWon(), false);
		//还差一个
		Assert.assertEquals(pzlv.getAllowedMove(),allowedMove);
		Assert.assertEquals(pzlv.getUsedMove(), 0);
		Assert.assertEquals(rlslv.getSquareNum(), i);
		Assert.assertArrayEquals(rlslv.getCl(), c);
		//Assert.assertEquals(expected, actual);
		Assert.assertTrue(tsq.isEqual(tsq2));
		Assert.assertFalse(bp2.removepiece(pc));
		Assert.assertTrue(bp2.addpiece(pc));
		Assert.assertEquals(bp2.getPieceSelected(),1);
		
		
		
		
		
		 
	}//之前一个括号
}//最后的括号
