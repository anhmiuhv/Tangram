package builder.builder;
import java.io.File;
import java.util.ArrayList;
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
		BuilderApplication app = new BuilderApplication(builder);	
	}

	
}
