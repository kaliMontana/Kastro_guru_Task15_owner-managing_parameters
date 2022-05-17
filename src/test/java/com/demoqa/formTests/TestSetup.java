package com.demoqa.formTests;

import com.codeborne.selenide.Configuration;
import com.demoqa.util.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestSetup {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Test form screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
