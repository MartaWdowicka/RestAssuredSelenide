package stepdeclarations;

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

    @Given("navigate to T-Mobile home page")
    public void setAPIEndpoint() {
        browser.openTMobileHomePage();
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