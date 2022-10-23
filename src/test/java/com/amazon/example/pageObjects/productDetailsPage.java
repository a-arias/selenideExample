package com.amazon.example.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class productDetailsPage extends basePage {
    //Locators
    public SelenideElement aboutThisItemHeader() {
        return Selenide.$(By.xpath("//h1[contains(text(),'About this item')]"));
    }
    public SelenideElement productTitle() {
        return Selenide.$(By.id("productTitle"));
    }
    public SelenideElement addToCartButton() {
        return Selenide.$(By.id("add-to-cart-button"));
    }
    public SelenideElement buyNowButton() {
        return Selenide.$(By.id("buy-now-button"));
    }

}
