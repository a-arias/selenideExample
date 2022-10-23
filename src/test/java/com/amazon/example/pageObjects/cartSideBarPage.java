package com.amazon.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class cartSideBarPage extends basePage {
    //###Locators
    public SelenideElement goToCartButton() {return $(By.cssSelector("input[type='submit']"));}
    public SelenideElement proceedToCheckoutButton() {return $(By.id("attach-sidesheet-checkout-button-announce"));}

    //###class methods
    //clicks go to cart button inside the cart menu component.
    public cartSideBarPage clickGoToCartButton() {
        goToCartButton().shouldBe(visible).click();
        return this;
    }

}