package com.demoqa.config;

import com.demoqa.dataProviders.BrowserData;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
       "classpath:chromeBrowser.properties",
       "classpath:firefoxBrowser.properties"

})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://about.gitlab.com/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    BrowserData getBrowser();

    @Key("version")
    @DefaultValue("101")
    String getVersion();
}
