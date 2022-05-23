package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("browserSize")
    String browserSize();

    @Key("selenoid.login")
    String selenoidLogin();

    @Key("selenoid.password")
    String selenoidPassword();
}
