package com.demoqa.config;

import com.codeborne.selenide.Configuration;
import com.demoqa.dataProviders.BrowserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.function.Supplier;

public class WebDriverLocalRemoteProvider implements Supplier<WebDriver> {
    private WebDriverLocalRemoteConfig config;

    public WebDriverLocalRemoteProvider() {
        this.config = ConfigFactory.create(WebDriverLocalRemoteConfig.class, System.getProperties());
        //Configuration.remote = String.valueOf(config.getRemoteUrl());
    }

    @SneakyThrows
    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());

        return driver;
    }

    private WebDriver createWebDriver(){
        if (System.getProperty("launcher").equals("localLauncher")) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().driverVersion(config.getVersion()).setup();

            return new ChromeDriver();
        }
        if (System.getProperty("launcher").equals("remoteLauncher")) {
           //Configuration.remote = String.valueOf(config.getRemoteUrl());

            DesiredCapabilities capabilities = new DesiredCapabilities();
           // capabilities.setCapability("browser", BrowserData.CHROME);
            //capabilities.setCapability("remote", config.getRemoteUrl());
            capabilities.setBrowserName(config.getBrowser());
            capabilities.setVersion(config.getBrowser());
            RemoteWebDriver driver = new RemoteWebDriver(config.getRemoteUrl(), capabilities);
            return driver;
        }
        throw new RuntimeException("No such browser");
    }
}
