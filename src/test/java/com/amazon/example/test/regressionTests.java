package com.amazon.example.test;
import com.amazon.example.pageObjects.*;

import com.amazon.example.pageObjects.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class regressionTests {
    amazonDashboardPage dashboard = new amazonDashboardPage();
    hamburgerMenu menu = new hamburgerMenu();
    productDetailsPage productDetailsPage = new productDetailsPage();
    signInPage signInPage = new signInPage();
    cartSideBarPage cartMenu = new cartSideBarPage();
    cartPage userCart = new cartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "2000x1100";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.amazon.in";
    }

    @BeforeEach
    public void getToProductList() {
        dashboard.open();

        menu.openHamburgerMenu()
                .clickMenuLink("TV, Appliances, Electronics")
                .clickSubsectionMenuLink("Televisions")
                .clickCheckboxButton("Samsung");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromList("3")
                .switchToNewWindow();

        productDetailsPage.productTitle().shouldHave(text("QLED TV"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
        productDetailsPage.addToCartButton().shouldBe(visible);
        productDetailsPage.buyNowButton().shouldBe(visible);
    }

//    @Test
//    public void searchProductUsingSideMenu(){
//        dashboard.open();
//
//        menu.openHamburgerMenu()
//                .clickMenuLink("TV, Appliances, Electronics")
//                .clickSubsectionMenuLink("Televisions")
//                .clickCheckboxButton("Samsung");
//
//        dashboard.openSortByMenu()
//                .sortBy("Price: High to Low")
//                .clickProductFromList("3")
//                .switchToNewWindow();
//
//        productDetailsPage.productTitle().shouldHave(text("QLED TV"));
//        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
//        productDetailsPage.addToCartButton().shouldBe(visible);
//        productDetailsPage.buyNowButton().shouldBe(visible);
//
//    }


    @Test
    public void addItemToWishList(){
        productDetailsPage.clickAddToWishListButton();

        signInPage.signInHeader().shouldHave(text("Sign In"));
    }

    @Test
    public void addProductToCart(){
        productDetailsPage.clickAddToCartButton();

        cartMenu.proceedToCheckoutButton().shouldBe(visible);
        cartMenu.goToCartButton().shouldBe(visible);
    }

    @Test
    public void userCanAddProductToCart(){
        String currentProductTitle = productDetailsPage.getCurrentProductTitle();

        productDetailsPage.clickAddToCartButton();

        cartMenu.clickGoToCartButton();

        userCart.clickProductFromList("1");

        Assertions.assertEquals(currentProductTitle, productDetailsPage.getCurrentProductTitle());
    }

}
