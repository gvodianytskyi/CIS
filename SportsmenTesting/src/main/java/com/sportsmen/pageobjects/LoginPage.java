package com.sportsmen.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css = "#username > div > input")
    private WebElement loginElement;

    @FindBy(css = "div:nth-child(2) > fg-input > div > input")
    private WebElement passwordElement;

    @FindBy(css = "button[ng-click='Login()']")
    private WebElement submitElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public void closeBrowser() {
        driver.quit();
    }

    public LoginPage typeLogin(String login) {
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.visibilityOf(loginElement)).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordElement.sendKeys(password);
        return this;
    }

    public NavigationPage loginAs(String login, String password) {
        typeLogin(login);
        typePassword(password);
        submitElement.click();
        return PageFactory.initElements(driver, NavigationPage.class);
    }
}
