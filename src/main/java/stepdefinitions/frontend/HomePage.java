package stepdefinitions.frontend;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.By;
import Abstract.TestContext;

public class HomePage extends Common {
	
    private static String acceptCookie = "#didomi-notice-agree-button";
    private static String sideMenuButton = ".toggle-navbar";
    private static By basketItemsCounter = By.xpath("//*[contains(text(), 'Przejdź do strony koszyka')]/ancestor::a//div");

    public HomePage(TestContext testContext) {
        super(testContext);
    }

    public static void openTMobileHomePage(boolean expectingCookiePopup) {
        open(config.getTMobileUrl());
        if (expectingCookiePopup && $$(acceptCookie).size() > 0) {
            $(acceptCookie).click();
        }
    }

    public static void openSideMenu() {
        $(sideMenuButton).click();
    }

    public static void confirmBasketIconHasItemsCountCounter() {
        try {
            $(basketItemsCounter, 1).getText();
        } catch (Exception e) {
            throw new AssertionError("Could not find Items Count icon above basket icon: " + e.getMessage());
        }
    }
}