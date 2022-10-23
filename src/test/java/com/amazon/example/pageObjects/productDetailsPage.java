package com.amazon.example.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class productDetailsPage extends basePage {
    //#Locators
    public SelenideElement aboutThisItemHeader() {return Selenide.$(By.xpath("//h1[contains(text(),'About this item')]"));}
    public SelenideElement productTitle() {
        return $(By.id("productTitle"));
    }
    public SelenideElement addToCartButton() {return $(By.id("add-to-cart-button"));}
    public SelenideElement buyNowButton() {
        return $(By.id("buy-now-button"));
    }
    public SelenideElement addToWishListButton() {return $(By.id("wishListMainButton"));}
    public SelenideElement ProductTitle() {return $(By.cssSelector("span#productTitle"));}

    //###class methods
    //Clicks the add to wish list button on product details page.
    public productDetailsPage clickAddToWishListButton() {
        addToWishListButton().shouldBe(visible).click();
        return this;
    }

    //Clicks the add to cart button on product details page.
    public productDetailsPage clickAddToCartButton() {
        addToCartButton().shouldBe(visible).click();
        return this;
    }

    //get current product title.
    public String getCurrentProductTitle() {
        return ProductTitle().shouldBe(visible).getText();
    }

}
