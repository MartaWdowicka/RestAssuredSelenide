package stepdefinitions.backend;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import Abstract.ServerConfig;
import Abstract.TestContext;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Common {
    protected static final Logger log = LoggerFactory.getLogger(Common.class);
    protected ServerConfig config = ServerConfig.getServerConfig();
    protected TestContext testContext;

    public Common(TestContext testContext) {
        this.testContext = testContext;
    }

    public void setEndpoint(String endpoint) {
        switch (endpoint) {
        case "exchangerates":
            endpoint = config.getCurrencyExchangeEndpoint();
        }
        log.info("Using endpoint: " + endpoint);
        this.testContext.setEndpoint(endpoint);
    }

    public void getDataFromEndpoint() {
        RestAssured.baseURI = testContext.getEndpoint();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        log.info("Status received => " + response.getStatusLine());
        try {
        	Assert.assertEquals(200, response.statusCode());
            this.testContext.setResponse(response);
            this.testContext.setJSONBody(response.getBody().toString());
        } catch (Exception e) {
            throw new AssertionError("  Request response was not 200. Response:\n" + response.prettyPrint());
        }
    }

    public List<Map<String, Object>> filteredCurrencyRateJson(String jsonFilteringPath, Filter filter) {
        return JsonPath.parse(this.testContext.getResponse().getBody().asString()).read(jsonFilteringPath, filter);
    }
}