package com.amazon.example.pageObjects;
import com.amazon.example.pageObjects.basePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class signInPage extends basePage {
    //#Locators
    public SelenideElement signInHeader() {
        return $(By.cssSelector("h1"));
    }

}