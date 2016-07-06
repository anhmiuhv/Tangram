package model;

/**
 * Representation of a player in the model.
 * @author jshen3, kdai, xwang11
 */
public class Player {
	String playerName;
	Kabasuji kabasuji;
	
	/**
	 * Player constructor.
	 * @param playerName
	 * @param kabasuji
	 */
	public Player(String playerName, Kabasuji kabasuji){
		this.playerName = playerName;
		this.kabasuji = kabasuji;
	}
	
}
