package testrunner.stepdeclarations;

import Abstract.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.backend.Common;
import stepdefinitions.backend.ExchangeRatesAPI;

public class BackendSteps {
	
    private final ExchangeRatesAPI exchangeRatesAPI;
    private final Common common;

    public BackendSteps(TestContext testContext) {
        this.common = new Common(testContext);
        this.exchangeRatesAPI = new ExchangeRatesAPI(testContext);
    }

    @Given("set endpoint as {}")
    public void setEndpoint(String endpoint) {
        common.setEndpoint(endpoint);
    }
    
    @When("get current exchange rates")
    public void getExchangeRates() throws Exception {
        common.getDataFromEndpoint();
    }

    @Then("print rates for currency {}")
    public void displayCurrencyRates(String currency) throws Exception {
        exchangeRatesAPI.displayCurrencyRates(currency);
    }
    
    @Then("print currencies with rates {} {}")
    public void displayCurrencyWithRates(String direction, String boundaryValue) throws Exception {
        exchangeRatesAPI.currencyBelowOrAboveValue(direction, boundaryValue);
    }
}