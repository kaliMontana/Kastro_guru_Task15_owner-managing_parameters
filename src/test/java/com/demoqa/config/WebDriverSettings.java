package com.demoqa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverSettings {
   // public WebDriver driver = new WebDriverProvider().get();
    public WebDriver driver = new WebDriverLocalRemoteProvider().get();

    @BeforeEach
    public void installingSettings() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
