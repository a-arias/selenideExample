package com.amazon.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class cartPage extends basePage {
    //#########Locators
    public SelenideElement resultsElement(String index) {return $(By.cssSelector("[data-item-index="+"'"+index+"'"+"]"));}

    //#########Class methods
    //Clicks product from list
    public cartPage clickProductFromList(String index) {
        resultsElement(index).shouldBe(visible).click();
        return this;
    }
}