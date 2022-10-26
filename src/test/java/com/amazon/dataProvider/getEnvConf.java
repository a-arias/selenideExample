package com.amazon.dataProvider;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class getEnvConf {

    public void getEnvironmentConfiguration(){
        ConfigFileReader configFileReader;
        configFileReader = new ConfigFileReader();

        if(Objects.equals(System.getenv("ENVIRONMENT"), "Selenoid")){
            //Configuration for Selenoid
            Configuration.browser = configFileReader.getBrowser();
            Configuration.baseUrl = configFileReader.getbaseUrl();
            Configuration.remote =  configFileReader.getRemoteUrl();
            ChromeOptions options = new ChromeOptions();
            options.setCapability("enableVNC", true);
            Configuration.browserCapabilities = options;
        }else {
            //Configuration for locally
            Configuration.browser = configFileReader.getBrowser();
            Configuration.baseUrl = configFileReader.getbaseUrl();
        }

    }
}
