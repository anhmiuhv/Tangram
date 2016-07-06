package model;

/**
 * This record the stars of the level.
 * @author jshen3, kdai, xwang11
 */

public class Achievement implements java.io.Serializable{

	private static final long serialVersionUID = -3467426884402000828L;
	
	/** The star(Achievement) of the level. */
	int stars;
	
	
	/**
	 * Achievement constructor.
	 * @param stars
	 */
	public Achievement(int stars){
		this.stars = stars;
	}
	
	/**
	 * Return the stars of the level.
	 * @return int
	 */
	public int getAchievement(){
		return stars; //return the Achievement of the 
	}
	
	/**
	 * Set the stars value of the Achievement.
	 * @param s
	 */
	public void setAchievement(int s){
		stars = s;
	}
}
