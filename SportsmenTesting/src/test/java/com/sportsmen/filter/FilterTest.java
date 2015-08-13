package com.sportsmen.filter;

import com.sportsmen.pageobjects.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FilterTest {
    private NavigationPage navigationPage;
    private WebDriver driver;
    private SearchResult searchResult;
    private WebDriver browser;

    private final String URL = "http://streamtv.net.ua/base/";
    private final String REGION = "";
    private final String FST = "";
    private final String YEAR = "2014";
    private final String PHOTO = "No";
    private final String STYLE = "";

    public FilterTest(WebDriver browser){
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
    public void filterTest() {
        navigationPage.selectFilters(REGION, FST, YEAR, PHOTO, STYLE);
        searchResult = navigationPage.clickSearch();
        try {
            assertTrue(searchResult.verifyFilterResult(REGION, FST, YEAR, PHOTO, STYLE) == true);
        } catch (AssertionError ae) {
            fail("Incorrect filtering.");
        }
    }

    @After
    public void end() {
        driver.quit();
    }
}
