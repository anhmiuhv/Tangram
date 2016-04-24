package builder.model;
/**T
 * this class represent all of the level currently in the builder
 * @author lthoang
 *
 */

public class Builder {
	String builderName;
	KabasujiBuilder kBuilder;
	
	/**
	 * create a new builder
	 * @param builderName builder name
	 * @param kBuilder Kabasujibuilder (array of editors)
	 */
	public Builder(String builderName, KabasujiBuilder kBuilder){
		this.builderName = builderName;
		this.kBuilder = kBuilder;
	}
	
	/**
	 * return the arrays of editors
	 * @return arrays of editors
	 */
	public KabasujiBuilder getKBuilder(){
		return kBuilder;
	}
}
