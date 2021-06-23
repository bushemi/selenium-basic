package com.bushemi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class YoutubeTest extends BaseTest {

    private static final String MAIN_PAGE_URL = "https://www.youtube.com/";

    @Test
    public void openPage() {
        openPage(MAIN_PAGE_URL);

        String title = driver.getTitle();

        assertThat(title)
                .withFailMessage("title is not match!!!")
                .isEqualTo("YouTube");
    }

    @Test
    public void findSearchIcon_byId() {
        openPage(MAIN_PAGE_URL);

        WebElement element = driver.findElement(By.id("search-icon-legacy"));
        String ariaLabel = element.getAttribute("aria-label");

        assertThat(ariaLabel)
                .withFailMessage("'aria-label' attribute of search icon is not match!!!")
                .isEqualTo("Введите запрос");
    }

    @Test
    public void findSearchInput_byCssSelector() {
        openPage(MAIN_PAGE_URL);

        WebElement element = driver.findElement(By.cssSelector("input#search"));
        String name = element.getAttribute("name");

        assertThat(name)
                .withFailMessage("'name' attribute of search input is not match!!!")
                .isEqualTo("search_query");
    }

    @Test
    public void searchFirstVideos() {
        openPage(MAIN_PAGE_URL);

        WebElement searchInput = driver.findElement(By.cssSelector("input#search"));
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));

        searchInput.sendKeys("first video");
        searchButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());
        webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("#button.ytd-toggle-button-renderer")));

        String title = driver.getTitle();

        assertThat(title)
                .withFailMessage("title is not match!!!")
                .isEqualTo("first video - YouTube");
    }
}
