package com.bushemi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

abstract class BaseTest {

    private static final String CHROMEDRIVER_PATH = "D:\\chromedriver_win32\\chromedriver.exe";
    protected WebDriver driver;

    protected void openPage(String url) {
        driver.get(url);
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void exitFromBrowser() {
        driver.quit();
    }


}
