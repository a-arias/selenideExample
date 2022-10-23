package com.amazon.example.pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class cartSideBarPage extends basePage {
    //###Locators
    public SelenideElement goToCartButton() {return $(By.id("attach-sidesheet-view-cart-button-announce"));}
    public SelenideElement proceedToCheckoutButton() {return $(By.id("attach-sidesheet-checkout-button-announce"));}
    public SelenideElement closeCartMenu() {return $(By.id("attach-close_sideSheet-link"));}


    //###class methods
    //clicks go to cart button inside the cart menu component.
    public cartSideBarPage clickGoToCartButton() {
        goToCartButton().shouldBe(visible).click();
        return this;
    }

    //clicks go to cart button inside the cart menu component.
    public cartSideBarPage clickCloseCartMenu() {
        closeCartMenu().shouldBe(visible).click();
        return this;
    }

}