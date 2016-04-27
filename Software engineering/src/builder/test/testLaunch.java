package builder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;

public class testLaunch {

	@Test
	public void test() {
		Builder builder = new Builder("linh", new KabasujiBuilder());
		@SuppressWarnings("unused")
		BuilderApplication app = new BuilderApplication(builder);	
		
	}

}
