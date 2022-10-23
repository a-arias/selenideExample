package com.amazon.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class cartPage extends basePage {
    public SelenideElement resultsElement(String index) {
        return $(By.cssSelector("[data-item-index="+"'"+index+"'"+"]"));
    }

    public cartPage clickProductFromList(String index) {
        resultsElement(index).shouldBe(visible).click();
        return this;
    }

//    public cartPage clickProductFromList(String index) {
//         $(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][index]"));
//         return this;
//
//    }
}