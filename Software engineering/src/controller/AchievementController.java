package controller;

import javax.swing.JOptionPane;

import model.Achievement;
import view.LevelSelection;
import view.LevelView;

public class AchievementController {
	
	Achievement achievement;
	LevelView levelview;
	LevelSelection levelselect;
	
	
	public AchievementController(LevelSelection levelselect,LevelView levelview,Achievement achievement){
		this.levelview =levelview;
		this.achievement=achievement;
		this.levelselect = levelselect;
	}
	
	public void actionPerformed(){

		if (achievement.getAchievement()==0){
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get zero star, game fails!", "Achievement", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("aaaaaaa");
		}
		else if (achievement.getAchievement()==1){
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get 1 star, next level is unlocked", "Achievement", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("aaaaaaa");
		}
		else if (achievement.getAchievement()==2){
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get 2 stars, next level is unlocked!", "Achievement", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("aaaaaaa");
		}
		else{
			JOptionPane.showMessageDialog(levelview.getContentPane(),
					"You get 3 stars, that is awesome", "Achievement", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("aaaaaaa");
		}
		levelview.closeWindowsFlag = true;
		new GoMenuController(levelselect,levelview,levelview.getLevel()).actionPerformed();
		levelview.close();
		
	}
}
