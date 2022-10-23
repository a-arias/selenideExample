package com.amazon.example.pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class cartPage extends basePage {
    //#########Locators
    public SelenideElement resultsElement(String index) {return $(By.xpath("//a/span[@class='a-size-medium a-color-base a-text-normal']["+"'"+index+"'"+"]"));}


    //#########Class methods
    //Clicks product from list
    public cartPage clickProductFromList(String index) {
        resultsElement(index).shouldBe(visible).click();
        return this;
    }
}