package com.sportsmen.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SearchResult {
    private WebDriver driver;
    private NavigationPage navigationPage;

    @FindBy(css = ".table-striped > tbody")
    private WebElement allFoundSportsmen;

    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getResultElements() {
        List<WebElement> sportsmen = new ArrayList<WebElement>();

        try {
            sportsmen = allFoundSportsmen.
                    findElements(By.tagName("tr"));
        } catch (ElementNotVisibleException e) {
            getResultElements();
        }

        return sportsmen;
    }

    public int openPersonalData(String searchText) {
        List<WebElement> res = this.getResultElements();
        int id = -1;

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).findElement(By.cssSelector("td:nth-child(2)")).getText().contains(searchText)) {
                id = Integer.valueOf(res.get(i).findElement(By.cssSelector("td:nth-child(1)")).getText());
                res.get(i).click();
                break;
            }
        }

        return id;
    }

    public boolean verifyFilterResult(String region, String fst, String year, String photo, String style) {
        boolean filterResult = true;
        List<WebElement> res = getResultElements();

        for (int i = 0; i < res.size(); i++) {
            if (!region.isEmpty() &&
                    !res.get(i).findElement(By.cssSelector("td:nth-child(3)")).getText().equals(region)) {
                return false;
            }
            if (!fst.isEmpty() &&
                    !res.get(i).findElement(By.cssSelector("td:nth-child(4)")).getText().equals(fst)) {
                return false;
            }
            if (!year.isEmpty() &&
                    !res.get(i).findElement(By.cssSelector("td:nth-child(5)")).getText().equals(year)) {
                return false;
            }
            if (!photo.isEmpty() &&
                    !res.get(i).findElement(By.cssSelector("td:nth-child(6)")).getText().equals(photo)) {
                return false;
            }
            if (!style.isEmpty() &&
                    !res.get(i).findElement(By.cssSelector("td:nth-child(7)")).getText().equals(style)) {
                return false;
            }
        }

        return filterResult;
    }

    public void setNavigationPage(NavigationPage navigationPage) {
        this.navigationPage = navigationPage;
    }
}
