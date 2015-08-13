package com.sportsmen.crud.read;

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

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReadTest {
    private NavigationPage navigationPage;
    private PersonalDataPage personalData;
    private WebDriver driver;
    private WebDriver browser;

    private final String URL = "http://streamtv.net.ua/base/";
    private final String SEARCH_TEXT = "Sydorenko";
    private final String TEST_DATA_PATH = "input/read_test.json";

    public ReadTest(WebDriver browser){
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
    public void readTest() {
        navigationPage.typeSearchInfo(SEARCH_TEXT);
        SearchResult searchResult = navigationPage.clickSearch();
        int id = searchResult.openPersonalData(SEARCH_TEXT);
        personalData = PageFactory.initElements(driver, PersonalDataPage.class);
        personalData.setNavigationPage(navigationPage);

        if (id >= 0) {
            try {
                assertTrue(personalData.matches(TEST_DATA_PATH) == true);
            } catch (AssertionError ae) {
                fail("Not equal");
            }
        } else {
            fail("No data found.");
        }
    }

    @After
    public void end() {
        driver.quit();
    }
}
