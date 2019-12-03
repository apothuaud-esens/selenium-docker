package com.sample;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest {

    @Test
    public void sampleTest1() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        String hubUrl = "http://" + System.getenv("SELENIUM_HUB") + ":4444/wd/hub";
        System.out.println("*********************************************\nHUB URL : " + hubUrl + "\n*********************************************\n");
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        GooglePage.open(driver);
        GooglePage.searchSomething(driver, "Selenium automation");
        assert GooglePage.primaryResultsContainsLinkTo(driver, "https://selenium.dev/");
        driver.quit();
    }

    @Test
    public void sampleTest2() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        String hubUrl = "http://" + System.getenv("SELENIUM_HUB") + ":4444/wd/hub";
        System.out.println("*********************************************\nHUB URL : " + hubUrl + "\n*********************************************\n");
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), capabilities);;
        GooglePage.open(driver);
        GooglePage.searchSomething(driver, "Maven repository");
        assert GooglePage.primaryResultsContainsLinkTo(driver, "https://mvnrepository.com/");
        driver.quit();
    }
}
