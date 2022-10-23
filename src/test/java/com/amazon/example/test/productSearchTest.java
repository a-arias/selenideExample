package com.amazon.example.test;
import com.amazon.example.pageObjects.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.closeWindow;

public class productSearchTest {
    amazonDashboardPage dashboard = new amazonDashboardPage();
    hamburgerMenu menu = new hamburgerMenu();
    productDetailsPage productDetailsPage = new productDetailsPage();
    signInPage signInPage = new signInPage();
    cartSideBarPage cartMenu = new cartSideBarPage();
    cartPage userCart = new cartPage();

    @BeforeEach
    public  void setUpAll() {
        Configuration.browserSize = "2000x1100";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.amazon.in";
    }

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

        productDetailsPage.productTitle().shouldHave(text("QLED"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
    }

    @Test
    public void searchProductWithSearchBar(){
        dashboard.open();

        dashboard.searchByText("Samsung TV");

        dashboard.clickProductFromTypeSearch("3")
                .switchToNewWindow();

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

        signInPage.signInHeader().shouldHave(text("Sign In"));
    }

    @Test
    public void addProductToCart(){
        dashboard.open();

        dashboard.searchByText("Samsung TV");

        dashboard.clickProductFromTypeSearch("3")
                 .switchToNewWindow();

        productDetailsPage.clickAddToCartButton();

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
