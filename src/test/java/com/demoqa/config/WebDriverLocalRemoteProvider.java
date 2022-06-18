package com.demoqa.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverLocalRemoteProvider implements Supplier<WebDriver> {
    private WebDriverLocalRemoteConfig config;

    public WebDriverLocalRemoteProvider() {
        this.config = ConfigFactory.create(WebDriverLocalRemoteConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());

        return driver;
    }

    private WebDriver createWebDriver() {
        if (System.getProperty("launcher").equals("localLauncher")) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().driverVersion(config.getVersion()).setup();

            return new ChromeDriver();
        } else if (System.getProperty("launcher").equals("remoteLauncher")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setBrowserName(config.getBrowserName());
            capabilities.setVersion(config.getVersion());

            return new RemoteWebDriver(config.getRemoteUrl(), capabilities);
        }
        throw new RuntimeException("No such browser");
    }
}
