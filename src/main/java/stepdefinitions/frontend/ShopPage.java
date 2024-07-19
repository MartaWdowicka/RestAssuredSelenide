package stepdefinitions.frontend;

import static com.codeborne.selenide.Selenide.$;
import Abstract.TestContext;

public class ShopPage extends Common {
    private static String shopProductEntry = ".dt_productCards:nth-of-type(1)";

	public ShopPage(TestContext testContext) {
		super(testContext);
	}

    public static void openProductDetailsPage() {
	    $(shopProductEntry).click();
    }
}