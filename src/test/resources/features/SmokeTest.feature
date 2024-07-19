Feature: T-Mobile Interview Tests

	@ui
	Scenario: On T-Mobile page verify adding products to basket
		Given navigate to T-Mobile home page
		When add product to basket
		And navigate to T-Mobile home page
		Then added products visible in basket 
	    
  Scenario: Validate currency rates API
    Given set endpoint as exchangerates
    When get current exchange rates
    Then print rates for currency USD
    And print rates for currency dolar amerykański
    And print currencies with rates above 5
    And print currencies with rates below 3