package stepdefinitions.frontend;

import Abstract.ServerConfig;
import Abstract.TestContext;

public abstract class Common {
	protected static ServerConfig config = ServerConfig.getServerConfig();
	@SuppressWarnings("unused")
	private TestContext testContext;

	public Common (TestContext testContext) {
		this.testContext = testContext;
	}
}