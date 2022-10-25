package com.amazon.example.pageObjects;

import com.codeborne.selenide.Selenide;

public class basePage {

    public basePage switchToNewWindow() {
        Selenide.switchTo().window(1);
        return this;
    }
}