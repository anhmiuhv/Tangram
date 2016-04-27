package model;

public class Achievement implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3467426884402000828L;
	int stars;
	
	public Achievement(int stars){
		this.stars = stars;
	}
	public int getAchievement(){
		return stars; //return the Achievement of the 
	}
	
	public void setAchievement(int s){
		stars = s;
	}
}
