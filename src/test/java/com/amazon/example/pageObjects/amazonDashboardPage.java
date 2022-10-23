package com.amazon.example.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class amazonDashboardPage extends basePage {

    //#########Locators
    public SelenideElement dropdownMenu() {
        return $(By.id("a-autoid-0-announce"));
    }
    public SelenideElement dropdownMenuItem(String criteria) {return $(By.xpath("//li/a[(text()="+"'"+criteria+"'"+")]"));}
    public SelenideElement resultsElementFromFilter(String index) {
        return $(By.xpath("//*[@data-index="+"'"+index+"'"+"]"));
    }
    public SelenideElement resultsElementFromTypeSearch(String index) {
        return $(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
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
        searchInput().setValue(product).pressEnter();
        //searchButton().click();
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

    public amazonDashboardPage clickProductFromFilterSearch(String index) {
        resultsElementFromFilter(index).shouldBe(visible).click();
        return this;
    }

    public amazonDashboardPage clickProductFromTypeSearch(String index) {
        resultsElementFromTypeSearch(index).shouldBe(visible).click();
        return this;
    }

}
