package com.sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    @Test
    public void sampleTest1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        GooglePage.open(driver);
        GooglePage.searchSomething(driver, "Selenium automation");
        assert GooglePage.primaryResultsContainsLinkTo(driver, "https://selenium.dev/");
        driver.quit();
    }

    @Test
    public void sampleTest2(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        GooglePage.open(driver);
        GooglePage.searchSomething(driver, "Maven repository");
        assert GooglePage.primaryResultsContainsLinkTo(driver, "https://mvnrepository.com/");
        driver.quit();
    }
}
