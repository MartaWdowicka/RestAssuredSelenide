package stepdefinitions.backend;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import Abstract.TestContext;
import java.util.List;
import java.util.Map;

public class ExchangeRatesAPI extends Common {
	
    private String jsonCurrenyRatesPath = "$[*].rates[?]";

    public ExchangeRatesAPI(TestContext testContext) {
        super(testContext);
    }

    public void displayCurrencyRates(String currency) {
        Filter filterByCurrencyName = Filter.filter(Criteria.where("currency").is(currency));
        Filter filterByCurrencyCode = Filter.filter(Criteria.where("code").is(currency));
        List<Map<String, Object>> currencyRate = (currency.length() == 3)
                ? filteredCurrencyRateJson(jsonCurrenyRatesPath, filterByCurrencyCode)
                : filteredCurrencyRateJson(jsonCurrenyRatesPath, filterByCurrencyName);
        log.info("Filtered currency rate by " + ((currency.length() == 3) ? "code:" : "name:"));
        log.info(currencyRate.toString());
    }

    public void currencyBelowOrAboveValue(String direction, String boundaryValue) {
        Filter filter = (direction.equals("above")
                ? Filter.filter(Criteria.where("mid").gte(Float.valueOf(boundaryValue)))
                : Filter.filter(Criteria.where("mid").lte(Float.valueOf(boundaryValue))));
        log.info("Filtered currency rates " + direction + " " + boundaryValue + " :");
        for (Map<String, Object> currency : filteredCurrencyRateJson(jsonCurrenyRatesPath, filter)) {
            log.info(currency.toString());
        }
    }
}