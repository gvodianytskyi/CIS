package com.sportsmen.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteConfirmation {
    private WebDriver driver;
    private NavigationPage navigationPage;

    @FindBy(css = "div.modal-footer.ng-scope > button.btn.btn-success")
    private WebElement okButtonElement;

    @FindBy(css = "div.modal-footer.ng-scope > button.btn.btn-warning")
    private WebElement cancelButtonElement;

    public DeleteConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationPage clickOk() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(okButtonElement)).click();
        return navigationPage;
    }

    public NavigationPage clickCancel() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(cancelButtonElement)).click();
        return navigationPage;
    }

    public void setNavigationPage(NavigationPage navigationPage) {
        this.navigationPage = navigationPage;
    }
}
