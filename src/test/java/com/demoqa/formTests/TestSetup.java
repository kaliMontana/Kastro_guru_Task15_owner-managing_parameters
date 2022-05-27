package com.demoqa.formTests;

import com.codeborne.selenide.Configuration;
import com.demoqa.config.CredentialsConfig;
import com.demoqa.util.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.demoqa.util.Helper.format;

public class TestSetup {
/*
    @BeforeAll
    static void setup() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.remote = format("https://{}:{}@{}",
                config.selenoidLogin(),
                config.selenoidPassword(),
                System.getProperty("selenoidUrl")
        );

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Test form screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }*/
}
