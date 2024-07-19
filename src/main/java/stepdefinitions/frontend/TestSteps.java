package stepdefinitions.frontend;

import Abstract.TestContext;

public class TestSteps extends Common {
    @SuppressWarnings("unused")
    public TestSteps(TestContext testContext) {
        super(testContext);
    }

    public void openTMobileHomePage() {
        HomePage.openTMobileHomePage();
    }

    public void addProductToBasket() throws Exception {
        try {
            HomePage.openSideMenu();
            SideMenuPage.clickFirstMenuPageElement("Urządzenia");
            SideMenuPage.clickSecondMenuPageElement("Smartwatche i opaski");
            SideMenuPage.clickThirdMenuPageElement("Bez abonamentu");
            ShopPage.openProductDetailsPage();
            ItemDetailsPage.clickAddProductToBasketButton();
            ItemDetailsPage.clickContinueButton();
        } catch (Exception e) {
            throw new Exception("Adding product to basket ended with error: " + e.getMessage());
        }
    }

    public void basketNotEmpty() {
        HomePage.confirmBasketIconHasItemsCountCounter();
    }
}