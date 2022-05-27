package com.demoqa.config;

import com.demoqa.dataProviders.BrowserData;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:${launcher}.properties"
})
public interface WebDriverLocalRemoteConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://about.gitlab.com/")
    String getBaseUrl();

    @Key("remoteUrl")
    URL getRemoteUrl();
}
