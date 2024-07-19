package stepdefinitions.frontend;

import static com.codeborne.selenide.Selenide.$x;
import Abstract.TestContext;

public class SideMenuPage extends Common {
	
    private static String firstMenuPageElement = "//button[contains(text(), '%s')][not(contains(@class, 'menu-dropdown-item'))]";
    private static String secondMenuPageElement = "//button[contains(text(), '%s')]";
    private static String thirdMenuPageElement = "//a[contains(text(), '%s')]";

    public SideMenuPage(TestContext testContext) {
        super(testContext);
    }

    public static void clickFirstMenuPageElement(String elementName) {
        $x(String.format(firstMenuPageElement, elementName)).click();
    }

    public static void clickSecondMenuPageElement(String elementName) {
        $x(String.format(secondMenuPageElement, elementName)).click();
    }

    public static void clickThirdMenuPageElement(String elementName) {
        $x(String.format(thirdMenuPageElement, elementName)).click();
    }
}