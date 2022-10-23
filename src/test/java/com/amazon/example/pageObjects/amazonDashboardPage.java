package com.amazon.example.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class amazonDashboardPage extends basePage {

    //#########Locators
    public SelenideElement dropdownMenu() {
        return $(By.id("a-autoid-0-announce"));
    }
    public SelenideElement dropdownMenuItem(String criteria) {
        return $(By.xpath("//li/a[(text()="+"'"+criteria+"'"+")]"));
    }
    public SelenideElement resultsElement(String index) {
        return $(By.cssSelector("[data-index="+"'"+index+"'"+"]"));
    }

    public SelenideElement searchInput() {
        return $(By.id("twotabsearchtextbox"));
    }

    public SelenideElement searchButton() {
        return $(By.id("nav-search-submit-button"));
    }



    //#########Complex methods
    public amazonDashboardPage open() {
        Selenide.open("/");
        return this;
    }

    public amazonDashboardPage searchByText(String product) {
        searchInput().setValue(product);
        searchButton().click();
        return this;
    }

    public amazonDashboardPage openSortByMenu() {
        dropdownMenu().click();
        return this;
    }

    public amazonDashboardPage sortBy(String criteria) {
        dropdownMenuItem(criteria).click();
        return this;
    }

    public amazonDashboardPage clickProductFromList(String index) {
        resultsElement(index).shouldBe(Condition.visible).scrollIntoView(true).click();
        return this;
    }

}
