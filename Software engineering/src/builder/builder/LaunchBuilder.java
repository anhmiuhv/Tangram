package builder.builder;
import builder.model.Builder;
import builder.view.*;


public class LaunchBuilder {

	public static void main(String[] args) {
		Builder builder = new Builder("linh", null);
		BuilderApplication app = new BuilderApplication(builder);	
	}
}
