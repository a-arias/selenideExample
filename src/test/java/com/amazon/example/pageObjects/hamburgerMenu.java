package com.amazon.example.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class hamburgerMenu extends basePage {
    //Locators
    public SelenideElement HamburgerMenu() {
        return Selenide.$(By.id("nav-hamburger-menu"));
    }
    public SelenideElement MenuLink(String name) {return Selenide.$(By.xpath("//a[@data-menu-id]/div[text()="+"'"+name+"'"+"]"));}
    public SelenideElement SubMenuLink(String element) { return Selenide.$(By.xpath("//a[@class='hmenu-item'][(text()="+"'"+element+"'"+")]"));}
    public SelenideElement checkboxButton(String name) {return Selenide.$(By.xpath("//a/span[(text()="+"'"+name+"'"+")]"));}

    //Complex methods
    public hamburgerMenu openHamburgerMenu() {
        HamburgerMenu().shouldBe(Condition.visible).click();
        return this;
    }

    public hamburgerMenu clickMenuLink(String name) {
        MenuLink(name).shouldBe(Condition.visible).click();
        return this;
    }

    public hamburgerMenu clickSubsectionMenuLink(String name) {
        SubMenuLink(name).shouldBe(Condition.visible).click();
        return this;
    }

    public void clickCheckboxButton(String name) {
        checkboxButton(name).shouldBe(Condition.visible).scrollIntoView(true).click();
    }
}
