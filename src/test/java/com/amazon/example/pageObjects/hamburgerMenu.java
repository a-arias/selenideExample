package com.amazon.example.pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class hamburgerMenu extends basePage {
    //###Locators
    public SelenideElement HamburgerMenu() {return $(By.id("nav-hamburger-menu"));}
    public SelenideElement MenuLink(String name) {return $(By.xpath("//a[@data-menu-id]/div[text()="+"'"+name+"'"+"]"));}
    public SelenideElement SubMenuLink(String element) { return $(By.xpath("//a[@class='hmenu-item'][(text()="+"'"+element+"'"+")]"));}
    public SelenideElement checkboxButton(String name) {return $(By.xpath("//a/span[(text()="+"'"+name+"'"+")]"));}

    //###class methods
    // opens up hamburger menu.
    public hamburgerMenu openHamburgerMenu() {
        HamburgerMenu().shouldBe(visible).click();
        return this;
    }

    //clicks menu link inside hamburger menu.
    public hamburgerMenu clickMenuLink(String name) {
        MenuLink(name).shouldBe(visible).click();
        return this;
    }

    //clicks sub menu item inside hamburger menu.
    public hamburgerMenu clickSubsectionMenuLink(String name) {
        SubMenuLink(name).shouldBe(visible).click();
        return this;
    }

    //clicks checkbox from hamburger menu.
    public void clickCheckboxButton(String name) {
        checkboxButton(name).shouldBe(visible).scrollIntoView(true).click();
    }
}
