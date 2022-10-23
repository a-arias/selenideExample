package com.amazon.example.test;
import com.amazon.example.pageObjects.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

public class MainPageTest {
    amazonDashboardPage dashboard = new amazonDashboardPage();
    hamburgerMenu menu = new hamburgerMenu();
    productDetailsPage productDetailsPage = new productDetailsPage();
    signInPage signInPage = new signInPage();
    cartSideBarPage cartMenu = new cartSideBarPage();
    cartPage userCart = new cartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.browser = "Chrome";
        Configuration.headless = false;
        Configuration.baseUrl = "https://www.amazon.in";
    }
    @Test
    public void searchProductUsingSideMenu(){
        dashboard.open();

        menu.openHamburgerMenu()
                .clickMenuLink("TV, Appliances, Electronics")
                .clickSubsectionMenuLink("Televisions")
                .clickCheckboxButton("Samsung");

        productDetailsPage.productTitle().shouldHave(text("QLED TV"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
        productDetailsPage.addToCartButton().shouldBe(visible);
        productDetailsPage.buyNowButton().shouldBe(visible);

    }

    @Test
    public void searchProductUsingSearchBar(){
        dashboard.open();

        dashboard.searchByText("TV");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromList("5");

        productDetailsPage.productTitle().shouldHave(text("TV"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
        productDetailsPage.addToCartButton().shouldBe(visible);
        productDetailsPage.buyNowButton().shouldBe(visible);

    }

    @Test
    public void addItemToWishList(){
        dashboard.open();

        dashboard.searchByText("TV");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromList("5");

        productDetailsPage.clickAddToWishListButton();
        signInPage.signInHeader().shouldHave(text("Sign In"));
    }

    @Test
    public void addProductToCart(){
        dashboard.open();

        dashboard.searchByText("TV");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromList("5");

        productDetailsPage.clickAddToCartButton();

        cartMenu.proceedToCheckoutButton().shouldBe(visible);
        cartMenu.goToCartButton().shouldBe(visible);
    }

    @Test
    public void userCanAddProductToCart(){
        dashboard.open();

        dashboard.searchByText("TV");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromList("5");

        String currentProductTitle = productDetailsPage.getCurrentProductTitle();

        productDetailsPage.clickAddToCartButton();

        cartMenu.clickGoToCartButton();

        userCart.clickProductFromList("1");

        Assertions.assertEquals(currentProductTitle, productDetailsPage.getCurrentProductTitle());
    }



}
