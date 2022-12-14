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
    public SelenideElement dropdownMenuItem(String criteria) {return $(By.xpath("//li/a[(text()="+"'"+criteria+"'"+")]"));}
    public SelenideElement resultsElementFromFilter(String index) {return $(By.xpath("//a/span[@class='a-size-base-plus a-color-base a-text-normal']["+"'"+index+"'"+"]"));}
    public SelenideElement resultsElementFromTypeSearch(String index) {return $(By.xpath("//a/span[@class='a-size-medium a-color-base a-text-normal']["+"'"+index+"'"+"]"));}
    public SelenideElement cartHeaderButton() {return $(By.id("nav-cart-text-container"));}
    public SelenideElement searchInput() {return $(By.id("twotabsearchtextbox"));}
    public SelenideElement searchButton() {return $(By.id("nav-search-submit-button"));}


    //#########Complex methods
    //open amazon dashboard page
    public amazonDashboardPage open() {
        Selenide.open("/");
        return this;
    }

    public amazonDashboardPage clickHeaderCartButton() {
        cartHeaderButton().click();
        return this;
    }


    //Perform a search with given string.
    public amazonDashboardPage searchByText(String product) {
        searchInput().setValue(product).pressEnter();
        return this;
    }

    //Opens up sortBy menu.
    public amazonDashboardPage openSortByMenu() {
        dropdownMenu().click();
        return this;
    }

    //clicks the dropdown element given by user.
    public amazonDashboardPage sortBy(String criteria) {
        dropdownMenuItem(criteria).click();
        return this;
    }

    //Clicks a product from a filtered search by user.
    //this is used for when user finds products using the hamburger menu.
    public amazonDashboardPage clickProductFromFilterSearch(String index) {
        resultsElementFromFilter(index).shouldBe(Condition.visible).click();
        return this;
    }

    //Clicks a product from a type search by user.
    //this is used for when user finds products using the search input.
    public amazonDashboardPage clickProductFromTypeSearch(String index) {
        resultsElementFromTypeSearch(index).shouldBe(Condition.visible).click();
        return this;
    }

}
