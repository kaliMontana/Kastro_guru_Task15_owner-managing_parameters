package com.demoqa.config;

import com.demoqa.dataProviders.BrowserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {
    private WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());

        return driver;
    }

    private WebDriver createWebDriver() {
        if (config.getBrowser().equals(BrowserData.CHROME)) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().driverVersion(config.getVersion()).setup();

            return new ChromeDriver();
        }
        if (config.getBrowser().equals(BrowserData.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            WebDriverManager.firefoxdriver().driverVersion(config.getVersion()).setup();

            return new FirefoxDriver();
        }
        throw new RuntimeException("No such browser");
    }
}
