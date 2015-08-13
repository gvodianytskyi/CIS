package com.sportsmen.crud.update;

import com.sportsmen.pageobjects.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UpdateTest {
    private NavigationPage navigationPage;
    private PersonalDataPage personalData;
    private WebDriver driver;
    private WebDriver browser;

    private final String URL = "http://streamtv.net.ua/base/";
    private final String SEARCH_TEXT = "Ivanchenko";
    private final String TEST_DATA_PATH = "input/update_test.json";

    public UpdateTest(WebDriver browser){
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
    public void updateTest() {
        navigationPage.typeSearchInfo(SEARCH_TEXT);
        SearchResult searchResult = navigationPage.clickSearch();
        searchResult.openPersonalData(SEARCH_TEXT);
        personalData = PageFactory.initElements(driver, PersonalDataPage.class);
        personalData.setNavigationPage(navigationPage);
        boolean wasUpdated = personalData.updateFields(TEST_DATA_PATH);

        if (wasUpdated) {
            personalData.clickSave();
        }
    }

    @After
    public void end() {
        driver.quit();
    }

}
