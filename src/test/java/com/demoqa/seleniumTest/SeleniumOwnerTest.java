package com.demoqa.seleniumTest;

import com.demoqa.config.WebDriverLocalRemoteConfig;
import com.demoqa.config.WebDriverSettings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SeleniumOwnerTest extends WebDriverSettings {
    WebDriverLocalRemoteConfig config;

    @Test
    @Tag("title")
    public void checkTitleTest() {
        step("Title", () -> {
            String title = driver.getTitle();

            Assertions.assertThat(title)
                    .as("Mistake in the checking title")
                    .isEqualTo("The One DevOps Platform | GitLab");
        });
    }
}
