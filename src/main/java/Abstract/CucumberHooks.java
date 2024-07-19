package Abstract;

import java.io.IOException;
import java.util.Properties;
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
    public static void setUp(Scenario scenario) throws IOException {
        try {
            java.io.InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("my.properties");
            java.util.Properties properties = new Properties();
            properties.load(inputStream);
            System.setProperty("selenide.browser", properties.getProperty("selenide.browser"));
        } catch (Exception e) {
           System.setProperty("selenide.browser", "Chrome");
        }
        Configuration.timeout = 10000;
    }
}