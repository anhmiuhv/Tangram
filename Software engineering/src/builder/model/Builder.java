package builder.model;

public class Builder {
	String builderName;
	KabasujiBuilder kBuilder;
	
	public Builder(String builderName, KabasujiBuilder kBuilder){
		this.builderName = builderName;
		this.kBuilder = kBuilder;
	}
	
	public KabasujiBuilder getKBuilder(){
		return kBuilder;
	}
}
