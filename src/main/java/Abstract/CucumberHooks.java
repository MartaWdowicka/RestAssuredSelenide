package Abstract;

import org.openqa.selenium.chrome.ChromeDriver;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

@SuppressWarnings("unused")
public class CucumberHooks {
	
    private final TestContext testContext;

    public CucumberHooks(TestContext testContext) {
    this.testContext = testContext;
    }

    @Before()
    public void setUp() {}

    @Before("@ui")
    public static void setUp(Scenario scenario) {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.timeout = 10000;
    }
}