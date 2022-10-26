package com.amazon.example.pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class cartPage extends basePage {
    //#########Locators
    public SelenideElement productFromListByIndex(String index) {return $(By.xpath("//span[@class='a-size-medium a-color-base sc-product-title']["+"'"+index+"'"+"]"));}
    public SelenideElement productFromListWithName(String name) {return $(By.xpath("//span[contains(@class, 'a-truncate-cut') and text() = "+"'"+name+"'"+"]"));}

    //#########Class methods
    //Clicks product from list
    public cartPage clickProductFromList(String index) {
        productFromListByIndex(index).shouldBe(visible).click();
        return this;
    }
}