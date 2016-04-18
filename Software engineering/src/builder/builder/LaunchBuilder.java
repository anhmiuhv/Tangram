package builder.builder;
import java.io.File;
import java.util.ArrayList;
import builder.model.*;
import builder.view.*;


public class LaunchBuilder {

	public static void main(String[] args) {
		Builder builder = new Builder("linh", new KabasujiBuilder());
		BuilderApplication app = new BuilderApplication(builder);	
	}

	
}
