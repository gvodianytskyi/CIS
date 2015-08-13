package com.sportsmen.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavigationPage {
    private WebDriver driver;

    @FindBy(css = "input.form-control")
    private WebElement searchFieldElement;

    @FindBy(css = "button.btn:nth-child(2)")
    private WebElement searchButtonElement;

    @FindBy(css = "button.btn:nth-child(3)")
    private WebElement addNewElement;

    @FindBy(css = "button.btn:nth-child(1)")
    private WebElement resetFiltersElement;

    @FindBy(css = "select.form-control:nth-child(1)")
    private WebElement resultAmountElement;

    @FindBy(css = "select.form-control:nth-child(2)")
    private WebElement regionsFilterElement;

    @FindBy(css = "select.form-control:nth-child(3)")
    private WebElement fstFilterElement;

    @FindBy(css = "select.form-control:nth-child(4)")
    private WebElement yearFilterElement;

    @FindBy(css = "select.form-control:nth-child(5)")
    private WebElement photoFilterElement;

    @FindBy(css = "select.form-control:nth-child(6)")
    private WebElement styleFilterElement;

    @FindBy(css = "div.ng-isolate-scope > ul")
    private WebElement tabElements;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public NavigationPage openNavigationPage(String url) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openLoginPage(url);
        return loginPage.loginAs("auto", "test");
    }

    public void selectRegion(String region) {
        Select clickThis = new Select((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(regionsFilterElement)));
        clickThis.selectByVisibleText(region);
    }

    public void selectFst(String fst) {
        Select clickThis = new Select((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(fstFilterElement)));
        clickThis.selectByVisibleText(fst);
    }

    public void selectYear(String year) {
        Select clickThis = new Select((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(yearFilterElement)));
        clickThis.selectByVisibleText(year);
    }

    public void selectPhoto(String photo) {
        Select clickThis = new Select((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(photoFilterElement)));
        clickThis.selectByVisibleText(photo);
    }

    public void selectStyle(String style) {
        Select clickThis = new Select((new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(styleFilterElement)));
        clickThis.selectByVisibleText(style);
    }

    public SearchResult selectFilters(String region, String fst, String year, String photo, String style) {
        if (!region.isEmpty()) {
            selectRegion(region);
        }
        if (!fst.isEmpty()) {
            selectRegion(fst);
        }
        if (!year.isEmpty()) {
            selectYear(year);
        }
        if (!photo.isEmpty()) {
            selectPhoto(photo);
        }
        if (!style.isEmpty()) {
            selectStyle(style);
        }
        SearchResult searchResult = PageFactory.initElements(driver, SearchResult.class);
        searchResult.setNavigationPage(this);
        return searchResult;
    }

    public NavigationPage typeSearchInfo(String searchInfo) {
        try {
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOf(searchFieldElement)).sendKeys(searchInfo);
        } catch (StaleElementReferenceException e) {
            typeSearchInfo(searchInfo);
        } catch (NoSuchElementException e) {
            typeSearchInfo(searchInfo);
        }

        return this;
    }

    public SearchResult clickSearch() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(searchButtonElement)).click();
        SearchResult searchResult = PageFactory.initElements(driver, SearchResult.class);
        searchResult.setNavigationPage(this);
        return searchResult;
    }

    public PersonalDataPage clickNew() {
        try {
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.elementToBeClickable(addNewElement)).click();
        } catch (StaleElementReferenceException e) {
            clickNew();
        } catch (NoSuchElementException e) {
            clickNew();
        }

        PersonalDataPage personalDataPage = PageFactory.initElements(driver, PersonalDataPage.class);
        personalDataPage.setNavigationPage(this);
        return personalDataPage;
    }

    public void selectTab(int tabNumber) {
        List<WebElement> allTabs = tabElements.findElements(By.cssSelector("li > a > tab-heading > div"));
        allTabs.get(tabNumber).click();
    }

    public void closeAllTabs() {
        try {
            List<WebElement> allTabsToClose = tabElements.
                    findElements(By.cssSelector("li > a > tab-heading > div > div.close-it > ico > span"));
            for (int i = 1; i < allTabsToClose.size(); i++) {
                allTabsToClose.get(i).click();
            }
        } catch (ElementNotVisibleException e) {
            closeAllTabs();
        }
    }

    public void quit() {
        driver.quit();
    }
}
