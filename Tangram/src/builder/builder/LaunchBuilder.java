package builder.builder;
import builder.model.*;
import builder.view.*;

/**
 * This class launch the builder
 * @author lthoang
 *
 */
public class LaunchBuilder {

	public static void main(String[] args) {
		Builder builder = new Builder("linh", new KabasujiBuilder());
		@SuppressWarnings("unused")
		BuilderApplication app = new BuilderApplication(builder);	
	}

	
}
