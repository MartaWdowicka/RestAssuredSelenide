package testrunner.stepdeclarations;

import Abstract.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.frontend.TestSteps;

public class FrontendSteps {
	
    private final TestSteps browser;

    public FrontendSteps(TestContext testContext) {
        this.browser = new TestSteps(testContext);
    }

    @Given("open T-Mobile home page")
    public void openHomePage() {
        browser.openTMobileHomePage(false);
    }
    
    @Given("open T-Mobile home page {}")
    public void openHomePage(String again) {
        browser.openTMobileHomePage(true);
    }

    @When("add product to basket")
    public void addProductToBasket() throws Exception {
        browser.addProductToBasket();
    }

    @Then("added products visible in basket")
    public void executePatchRequest() throws Exception {
        browser.basketNotEmpty();
    }
}