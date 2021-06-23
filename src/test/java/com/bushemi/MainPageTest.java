package com.bushemi;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {
    private static final String MAIN_PAGE_URL = "http://localhost:8080/";

    @Test
    @Ignore("test is written only for spring-boot-application")
    public void openPage() {
        openPage(MAIN_PAGE_URL);
        String title = driver.getTitle();

        assertThat(title)
                .withFailMessage("title is not match!!!")
                .isEqualTo("Маин Паге");
    }
}
