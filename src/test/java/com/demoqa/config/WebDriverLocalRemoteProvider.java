package com.demoqa.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
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

    private WebDriver createWebDriver() throws MalformedURLException {
        if (System.getProperty("launcher").equals("localLauncher")) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().driverVersion(config.getVersion()).setup();

            return new ChromeDriver();
        } else if (System.getProperty("launcher").equals("remoteLauncher")) {

            System.out.println("config.getBrowser() " + config.getBrowserName()); // TODO null почему?
            System.out.println("config.getVersion() " + config.getVersion()); // TODO null почему?
            System.out.println("config.getRemoteUrl() " + config.getRemoteUrl()); // TODO null почему?

            DesiredCapabilities capabilities = new DesiredCapabilities();
            //capabilities.setBrowserName("chrome");
            // capabilities.setVersion("102"); // TODO version не принимает почему?
            capabilities.setCapability("browserName", "chrome");
            // capabilities.setCapability("browserVersion", "101");

            return new RemoteWebDriver(new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub/"), capabilities);
//new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
           /* ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("browserVersion", config.getVersion());
            chromeOptions.setCapability("platformName", "Windows");

            WebDriver driver = new RemoteWebDriver(new URL(String.valueOf(config.getRemoteUrl())), chromeOptions);


            return driver;*/
        }
        throw new RuntimeException("No such browser");
    }
}
