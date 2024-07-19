package Abstract;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports"},
    features = "src/test/resources/features",
    glue = {"stepdefinitions.backend", "stepdefinitions.frontend", "stepdeclaration"}
)
public class CucumberRunner {}