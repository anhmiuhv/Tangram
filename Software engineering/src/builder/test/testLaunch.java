package builder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import builder.builder.LaunchBuilder;
import builder.model.Builder;
import builder.model.KabasujiBuilder;
import builder.view.BuilderApplication;

public class testLaunch {

	@Test
	public void test() {
		String[] args = new String[0];
		LaunchBuilder.main(args);
	}

}
