package com.amazon.example.pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class signInPage extends basePage {
    //#Locators
    public SelenideElement signInHeader() {
        return $(By.cssSelector("h1"));
    }

}