package com.sportsmen.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import com.sportsmen.data.TestData;

import java.io.File;
import java.util.*;

public class PersonalDataPage {
    private WebDriver driver;
    private NavigationPage navigationPage;

    @FindBy(css = "button[ng-click*='save()']")
    private WebElement saveButtonElement;

    @FindBy(css = "button[ng-click='delete()']")
    private WebElement deleteButtonElement;

    @FindBy(css = "fg-input.ng-isolate-scope:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement lastNameElement;

    @FindBy(css = "div.form-group-2:nth-child(1) > fg-input:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement firstNameElement;

    @FindBy(css = "fg-date.ng-pristine > div:nth-child(1) > input:nth-child(1)")
    private WebElement birthElement;

    @FindBy(css = "div.form-group-2:nth-child(2) > fg-input:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement middleNameElement;

    @FindBy(css = "div.form-group:nth-child(3) > fg-select:nth-child(1) > div:nth-child(1) > select:nth-child(1)")
    private WebElement region1Element;

    @FindBy(css = "div.form-group:nth-child(3) > fg-select:nth-child(2) > div:nth-child(1) > select:nth-child(1)")
    private WebElement region2Element;

    @FindBy(css = "div.form-group:nth-child(4) > fg-select:nth-child(1) > div:nth-child(1) > select:nth-child(1)")
    private WebElement fst1Element;

    @FindBy(css = "div.form-group:nth-child(4) > fg-select:nth-child(2) > div:nth-child(1) > select:nth-child(1)")
    private WebElement fst2Element;

    @FindBy(css = "fg-typeahead.ng-isolate-scope:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement trainer1Element;

    @FindBy(css = "fg-typeahead.ng-isolate-scope:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement trainer2Element;

    @FindBy(css = "div.form-group:nth-child(6) > fg-select:nth-child(1) > div:nth-child(1) > select:nth-child(1)")
    private WebElement styleElement;

    @FindBy(css = "div.form-group:nth-child(6) > fg-select:nth-child(2) > div:nth-child(1) > select:nth-child(1)")
    private WebElement ageElement;

    @FindBy(css = "div.form-group:nth-child(7) > fg-select:nth-child(1) > div:nth-child(1) > select:nth-child(1)")
    private WebElement yearElement;

    @FindBy(css = "f-select.ng-isolate-scope > select:nth-child(1)")
    private WebElement statusElement;

    @FindBy(css = ".col-sm-4 > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
    private WebElement uploadPhotoElement;

    @FindBy(css = "div.col-sm-12:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)")
    private WebElement uploadDocumentElement;

    @FindBy(css = "img")
    private WebElement photoElement;

    @FindBy(css =
            "div.tab-pane.ng-scope.active > div > div > div > form > div > div > div.col-sm-12 > div > div.panel-body > div > table > tbody")
    private WebElement documentsElement;

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNavigationPage(NavigationPage navigationPage) {
        this.navigationPage = navigationPage;
    }

    public PersonalDataPage typeLastName(String surname) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(lastNameElement)).sendKeys(surname);
        return this;
    }

    public PersonalDataPage typeFirstName(String name) {
        firstNameElement.sendKeys(name);
        return this;
    }

    public PersonalDataPage typeBirth(String birth) {
        birthElement.sendKeys(birth);
        return this;
    }

    public PersonalDataPage typeMiddleName(String middleName) {
        middleNameElement.sendKeys(middleName);
        return this;
    }

    public PersonalDataPage selectRegion1(String region) {
        Select clickThis = new Select(region1Element);
        clickThis.selectByVisibleText(region);
        return this;
    }

    public PersonalDataPage selectRegion2(String region) {
        Select clickThis = new Select(region2Element);
        clickThis.selectByVisibleText(region);
        return this;
    }

    public PersonalDataPage selectFst1(String fst) {
        Select clickThis = new Select(fst1Element);
        clickThis.selectByVisibleText(fst);
        return this;
    }

    public PersonalDataPage selectFst2(String fst) {
        Select clickThis = new Select(fst2Element);
        clickThis.selectByVisibleText(fst);
        return this;
    }

    public PersonalDataPage typeTrainer1(String trainer) {
        trainer1Element.sendKeys(trainer);
        return this;
    }

    public PersonalDataPage typeTrainer2(String trainer) {
        trainer2Element.sendKeys(trainer);
        return this;
    }

    public PersonalDataPage selectStyle(String style) {
        Select clickThis = new Select(styleElement);
        clickThis.selectByVisibleText(style);
        return this;
    }

    public PersonalDataPage selectAge(String age) {
        Select clickThis = new Select(ageElement);
        clickThis.selectByVisibleText(age);
        return this;
    }

    public PersonalDataPage selectYear(String year) {
        Select clickThis = new Select(yearElement);
        clickThis.selectByVisibleText(year);
        return this;
    }

    public PersonalDataPage selectStatus(String status) {
        Select clickThis = new Select(statusElement);
        clickThis.selectByVisibleText(status);
        return this;
    }

    public PersonalDataPage uploadPhoto(String path) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(uploadPhotoElement)).sendKeys(path);
        return this;
    }

    public PersonalDataPage uploadDocument(String path) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(uploadDocumentElement)).sendKeys(path);
        return this;
    }

    public PersonalDataPage clickSave() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(saveButtonElement)).click();
        return this;
    }

    public DeleteConfirmation clickDelete() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(deleteButtonElement)).click();
        DeleteConfirmation deleteConfirmation = PageFactory.initElements(driver, DeleteConfirmation.class);
        deleteConfirmation.setNavigationPage(navigationPage);
        return deleteConfirmation;
    }

    public String readDropdownSelection(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public String getPhotoAttribute() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(photoElement)).getAttribute("ng-src");
    }

    public List<WebElement> getDocumentElements() {
        List<WebElement> documents = new ArrayList<WebElement>();

        try {
            documents = documentsElement.
                    findElements(By.tagName("a"));
        } catch (ElementNotVisibleException e) {
            getDocumentElements();
        }

        return documents;
    }

    public boolean containsDocument(String path) {
        String fileName = (new File(path)).getName();
        List<WebElement> documents = this.getDocumentElements();

        for (WebElement doc : documents) {
            if (doc.getText().equals(fileName)) {
                return true;
            }
        }

        return false;
    }

    public void fillFields(String path) {
        TestData data = new TestData(path);
        this.typeLastName(data.getLastName());
        this.typeFirstName(data.getFirstName());
        this.typeMiddleName(data.getMiddleName());
        this.typeBirth(data.getBirth());
        this.selectRegion1(data.getRegion1());
        this.selectRegion2(data.getRegion2());
        this.selectFst1(data.getFst1());
        this.selectFst2(data.getFst2());
        this.typeTrainer1(data.getTrainer1());
        this.typeTrainer2(data.getTrainer2());
        this.selectStyle(data.getStyle());
        this.selectAge(data.getAge());
        this.selectYear(data.getYear());
        this.selectStatus(data.getStatus());
    }

    public boolean matches(String path) {
        TestData data = new TestData(path);

        if((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.getLastNameElement()))
                    .getAttribute("value").equals(data.getLastName()) &&
                this.getFirstNameElement().getAttribute("value").equals(data.getFirstName()) &&
                this.getBirthElement().getAttribute("value").equals(data.getBirth()) &&
                this.getMiddleNameElement().getAttribute("value").equals(data.getMiddleName()) &&
                this.readDropdownSelection(this.getRegion1Element()).equals(data.getRegion1()) &&
                this.readDropdownSelection(this.getRegion2Element()).equals(data.getRegion2()) &&
                this.readDropdownSelection(this.getFst1Element()).equals(data.getFst1()) &&
                this.readDropdownSelection(this.getFst2Element()).equals(data.getFst2()) &&
                this.getTrainer1Element().getAttribute("value").equals(data.getTrainer1()) &&
                this.getTrainer2Element().getAttribute("value").equals(data.getTrainer2()) &&
                this.readDropdownSelection(this.getStyleElement()).equals(data.getStyle()) &&
                this.readDropdownSelection(this.getAgeElement()).equals(data.getAge()) &&
                this.readDropdownSelection(this.getYearElement()).equals(data.getYear()) &&
                this.readDropdownSelection(this.getStatusElement()).equals(data.getStatus())) {

            return true;
        }

        return false;
    }

    public boolean updateFields(String path) {
        TestData data = new TestData(path);
        boolean wasUpdated = false;

        if (!(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.getLastNameElement())).getAttribute("value").equals(data.getLastName())) {
            this.typeLastName(data.getLastName());
            wasUpdated = true;
        }
        if (!this.getBirthElement().getAttribute("value").equals(data.getBirth())) {
            this.typeBirth(data.getBirth());
            wasUpdated = true;
        }
        if (!this.getFirstNameElement().getAttribute("value").equals(data.getFirstName())) {
            this.typeFirstName(data.getFirstName());
            wasUpdated = true;
        }
        if (!this.getMiddleNameElement().getAttribute("value").equals(data.getMiddleName())) {
            this.typeMiddleName(data.getMiddleName());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getRegion1Element()).equals(data.getRegion1())) {
            this.selectRegion1(data.getRegion1());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getRegion2Element()).equals(data.getRegion2())) {
            this.selectRegion2(data.getRegion2());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getFst1Element()).equals(data.getFst1())) {
            this.selectFst1(data.getFst1());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getFst2Element()).equals(data.getFst2())) {
            this.selectFst2(data.getFst2());
            wasUpdated = true;
        }
        if (!this.getTrainer1Element().getAttribute("value").equals(data.getTrainer1())) {
            this.typeTrainer1(data.getTrainer1());
            wasUpdated = true;
        }
        if (!this.getTrainer2Element().getAttribute("value").equals(data.getTrainer2())) {
            this.typeTrainer2(data.getTrainer2());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getStyleElement()).equals(data.getStyle())) {
            this.selectStyle(data.getStyle());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getAgeElement()).equals(data.getAge())) {
            this.selectAge(data.getAge());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getYearElement()).equals(data.getYear())) {
            this.selectYear(data.getYear());
            wasUpdated = true;
        }
        if (!this.readDropdownSelection(this.getStatusElement()).equals(data.getStatus())) {
            this.selectStatus(data.getStatus());
            wasUpdated = true;
        }

        return wasUpdated;
    }

    public WebElement getLastNameElement() {
        return lastNameElement;
    }

    public void setLastNameElement(WebElement lastNameElement) {
        this.lastNameElement = lastNameElement;
    }

    public WebElement getFirstNameElement() {
        return firstNameElement;
    }

    public void setFirstNameElement(WebElement firstNameElement) {
        this.firstNameElement = firstNameElement;
    }

    public WebElement getBirthElement() {
        return birthElement;
    }

    public void setBirthElement(WebElement birthElement) {
        this.birthElement = birthElement;
    }

    public WebElement getMiddleNameElement() {
        return middleNameElement;
    }

    public void setMiddleNameElement(WebElement middleNameElement) {
        this.middleNameElement = middleNameElement;
    }

    public WebElement getRegion1Element() {
        return region1Element;
    }

    public void setRegion1Element(WebElement region1Element) {
        this.region1Element = region1Element;
    }

    public WebElement getRegion2Element() {
        return region2Element;
    }

    public void setRegion2Element(WebElement region2Element) {
        this.region2Element = region2Element;
    }

    public WebElement getFst1Element() {
        return fst1Element;
    }

    public void setFst1Element(WebElement fst1Element) {
        this.fst1Element = fst1Element;
    }

    public WebElement getFst2Element() {
        return fst2Element;
    }

    public void setFst2Element(WebElement fst2Element) {
        this.fst2Element = fst2Element;
    }

    public WebElement getTrainer1Element() {
        return trainer1Element;
    }

    public void setTrainer1Element(WebElement trainer1Element) {
        this.trainer1Element = trainer1Element;
    }

    public WebElement getTrainer2Element() {
        return trainer2Element;
    }

    public void setTrainer2Element(WebElement trainer2Element) {
        this.trainer2Element = trainer2Element;
    }

    public WebElement getStyleElement() {
        return styleElement;
    }

    public void setStyleElement(WebElement styleElement) {
        this.styleElement = styleElement;
    }

    public WebElement getAgeElement() {
        return ageElement;
    }

    public void setAgeElement(WebElement ageElement) {
        this.ageElement = ageElement;
    }

    public WebElement getYearElement() {
        return yearElement;
    }

    public void setYearElement(WebElement yearElement) {
        this.yearElement = yearElement;
    }

    public WebElement getStatusElement() {
        return statusElement;
    }

    public void setStatusElement(WebElement statusElement) {
        this.statusElement = statusElement;
    }
}
