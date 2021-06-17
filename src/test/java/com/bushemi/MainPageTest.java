package com.bushemi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest {

    public static final String CHROMEDRIVER_PATH = "D:\\chromedriver_win32/chromedriver.exe";
    public static final String MAIN_PAGE_URL = "http://localhost:8080/";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void destroyDriver() {
        driver.close();
    }

    @Test
    public void openPage() {
        driver.get(MAIN_PAGE_URL);
        String title = driver.getTitle();

        assertThat(title)
                .withFailMessage("title is not match!!!")
                .isEqualTo("Маин Паге");
    }
}
