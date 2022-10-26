package com.amazon.example;
import com.amazon.example.pageObjects.*;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;


import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import com.amazon.dataProvider.getEnvConf;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TextReportExtension.class)
public class productSearchTest {
    amazonDashboardPage dashboard = new amazonDashboardPage();
    hamburgerMenu menu = new hamburgerMenu();
    com.amazon.example.pageObjects.productDetailsPage productDetailsPage = new productDetailsPage();
    com.amazon.example.pageObjects.signInPage signInPage = new signInPage();
    cartSideBarPage cartMenu = new cartSideBarPage();
    cartPage userCart = new cartPage();

    @BeforeAll
    public static void startDriver(){
        getEnvConf driverConfiguration = new getEnvConf();
        driverConfiguration.getEnvironmentConfiguration();
    }

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    public void tearDown(){
        closeWindow();
    }

    @Test
    public void searchProductUsingSideMenu(){
        dashboard.open();

        menu.openHamburgerMenu()
                .clickMenuLink("TV, Appliances, Electronics")
                .clickSubsectionMenuLink("Televisions")
                .clickCheckboxButton("Samsung");

        dashboard.openSortByMenu()
                .sortBy("Price: High to Low")
                .clickProductFromFilterSearch("3")
                .switchToNewWindow();

        //Asserts productTitle contains 'TV' text and aboutThisItemHeader text is displayed.
        productDetailsPage.productTitle().shouldHave(text("QLED"));
        productDetailsPage.aboutThisItemHeader().shouldBe(visible);
    }

}
