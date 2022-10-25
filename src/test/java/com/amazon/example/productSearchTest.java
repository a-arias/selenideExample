package com.amazon.example;
import com.amazon.example.pageObjects.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;

public class productSearchTest {
    amazonDashboardPage dashboard = new amazonDashboardPage();
    hamburgerMenu menu = new hamburgerMenu();
    com.amazon.example.pageObjects.productDetailsPage productDetailsPage = new productDetailsPage();
    com.amazon.example.pageObjects.signInPage signInPage = new signInPage();
    cartSideBarPage cartMenu = new cartSideBarPage();
    cartPage userCart = new cartPage();

    @BeforeEach
    public  void setUpAll() {
        Configuration.browserSize = "2000x1100";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.amazon.in";
    }

//    @BeforeAll
//    public void setUp() {
//        final DesiredCapabilities capabilities = new DesiredCapabilities();
//        baseUrl = "https://www.amazon.in/";
//        remote ="http://localhost:4445/wd/hub";
//        browser = "chrome";
//        browserVersion = "79.0";
//        browserCapabilities = capabilities;
//        capabilities.setCapability("enableVNC", false);
//        capabilities.setCapability("enableVideo", false);
//        System.setProperty("selenide.browser", "chrome");
//        //startMaximized = true;
//        browserSize = "1920x1080";
//    }
//
//    @BeforeTest
//    public void startDriver() {
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1024x768";
//        Configuration.baseUrl = "https://www.amazon.in/";
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }

    @AfterEach
    public  void tearDown() {
        closeWindow();
    }

    @Test
    public void searchProductUsingSideMenu(){
        dashboard.open();

        menu.openHamburgerMenu()
                .clickMenuLink("TV, Appliances, Electronics")
                .clickSubsectionMenuLink("Televisions")
                .clickCheckboxButton("Samsung");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromFilterSearch("3")
                .switchToNewWindow();

        //Asserts productTitle contains 'TV' text and aboutThisItemHeader text is displayed.
        productDetailsPage.productTitle().shouldHave(text("QLED"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
    }

    @Test
    public void searchProductWithSearchBar(){
        dashboard.open();

        dashboard.searchByText("Samsung TV");

        dashboard.clickProductFromTypeSearch("3")
                .switchToNewWindow();

        //Asserts productTitle contains 'TV' text and aboutThisItemHeader text is displayed.
        productDetailsPage.productTitle().shouldHave(text("TV"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
    }

    @Test
    public void addItemToWishList(){
        dashboard.open();

        dashboard.searchByText("Samsung TV");

        dashboard.clickProductFromTypeSearch("3")
                 .switchToNewWindow();

        productDetailsPage.clickAddToWishListButton();

        //Asserts SignIn Header page displayed.
        signInPage.signInHeader().shouldHave(text("Sign In"));
    }

    @Test
    public void addProductToCart(){
        dashboard.open();

        dashboard.searchByText("Samsung TV");

        dashboard.clickProductFromTypeSearch("3")
                 .switchToNewWindow();

        productDetailsPage.clickAddToCartButton();

        //Asserts proceedToCheckoutButton and goToCartButton are displayed.
        cartMenu.proceedToCheckoutButton().shouldBe(visible);
        cartMenu.goToCartButton().shouldBe(visible);
    }

    @Test
    public void userCanAddProductToCart(){
        dashboard.open();

        dashboard.searchByText("Toshiba TV");

        dashboard.clickProductFromTypeSearch("5")
                .switchToNewWindow();

        String productTitleFromSearch = productDetailsPage.getCurrentProductTitle();

        //User adds product to cart.
        productDetailsPage.clickAddToCartButton();
        //Validates cart buttons are displayed.
        cartMenu.proceedToCheckoutButton().shouldBe(visible);
        cartMenu.goToCartButton().shouldBe(visible);
        //closes cart menu.
        cartMenu.clickCloseCartMenu();

        //Navigates to Cart button using cart header button.
        dashboard.clickHeaderCartButton();
        //Clicks product from cart list.

        String productNameFromCartList = userCart.productFromListWithName(productTitleFromSearch).getText();

        //Asserts product title from first search is equals to the product on the cart List
        Assertions.assertEquals(productTitleFromSearch,productNameFromCartList);
    }
}
