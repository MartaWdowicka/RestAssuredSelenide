package stepdefinitions.frontend;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import org.openqa.selenium.By;
import Abstract.TestContext;

public class ItemDetailsPage extends Common {
	
    private static String addToBasketButton = "//div[contains(text(), 'Dodaj do koszyka')]";
    private static String continueButton = "//span[contains(text(), 'Dalej')]";

    public ItemDetailsPage(TestContext testContext) {
        super(testContext);
    }

    public static void clickAddProductToBasketButton() {
        $(By.xpath(addToBasketButton), 1).click();
    }

    public static void clickContinueButton() {
        $x(continueButton).click();
    }
}