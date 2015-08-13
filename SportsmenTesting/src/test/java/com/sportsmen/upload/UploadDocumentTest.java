package com.sportsmen.upload;

import com.sportsmen.pageobjects.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UploadDocumentTest {
    private NavigationPage navigationPage;
    private PersonalDataPage personalData;
    private WebDriver driver;
    private WebDriver browser;

    private final String URL = "http://streamtv.net.ua/base/";
    private final String SEARCH_TEXT = "Ivanchenko";
    private final String DOCUMENT_PATH = (new File("input/documents/document.txt")).getAbsolutePath();

    public UploadDocumentTest(WebDriver browser){
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Collection<Object[] > data(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        Object[][] data = new Object[][] { { new ChromeDriver() }, { new FirefoxDriver() }};
        return Arrays.asList(data);
    }

    @Before
    public void openNavigationPage() {
        driver = browser;
        navigationPage = PageFactory.initElements(driver, NavigationPage.class);
        navigationPage.openNavigationPage(URL);
    }

    @Test
    public void uploadPhotoTest() {
        navigationPage.typeSearchInfo(SEARCH_TEXT);
        SearchResult searchResult = navigationPage.clickSearch();
        int id = searchResult.openPersonalData(SEARCH_TEXT);
        personalData = PageFactory.initElements(driver, PersonalDataPage.class);
        personalData.setNavigationPage(navigationPage);

        if (id >= 0) {
            personalData.uploadDocument(DOCUMENT_PATH);
        } else {
            fail("Sportsman not found");
        }

        navigationPage.closeAllTabs();
        navigationPage.clickSearch();
        searchResult.openPersonalData(SEARCH_TEXT);

        try {
            assertTrue(personalData.containsDocument(DOCUMENT_PATH));
        } catch (AssertionError ae) {
            fail("Document was not uploaded.");
        }
    }

    @After
    public void end() {
        driver.quit();
    }
}
