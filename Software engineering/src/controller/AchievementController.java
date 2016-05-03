package controller;

import javax.swing.JOptionPane;

/**
 * Representation of a controller of Achievement
 * @author jshen3, kdai, xwang11
 */

import model.Achievement;
import view.LevelSelection;
import view.LevelView;

/**
 * Achievement Controller which is called when you get 3 stars .
 * @author jshen3, kdai, xwang11
 */
public class AchievementController {
	
	Achievement achievement;
	LevelView levelview;
	LevelSelection levelselect;
	
	/**
	 * Constructor of AchievementController.
	 * @param levelselect
	 * @param levelview
	 * @param achievement
	 */
	public AchievementController(LevelSelection levelselect,LevelView levelview,Achievement achievement){
		this.levelview =levelview;
		this.achievement=achievement;
		this.levelselect = levelselect;
	}

	/**
	 * get the achievement and feedback certain information
	 * 
	 */
	public void actionPerformed(){

		if (achievement.getAchievement()==0){
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get zero star, game fails!", "Achievement", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (achievement.getAchievement()==1){
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get 1 star, next level is unlocked", "Achievement", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (achievement.getAchievement()==2){
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get 2 stars, next level is unlocked!", "Achievement", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get 3 stars, that is awesome", "Achievement", JOptionPane.INFORMATION_MESSAGE);
		}
		levelview.closeWindowsFlag = true;
		new GoMenuController(levelselect,levelview,levelview.getLevel()).actionPerformed();
		levelview.close();
		
	}
}
