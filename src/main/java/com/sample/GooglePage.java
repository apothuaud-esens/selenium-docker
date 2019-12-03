package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    static String url = "https://www.google.fr/";

    static By searchForm = new By.ByXPath("//form[@name=\"f\"]");
    static By searchField = new By.ByXPath("//input[@name=\"q\"]");
    static By primaryResults = new By.ByXPath("//div[contains(@class, 'rc')]/div[contains(@class, 'r')]");

    static void open(WebDriver driver){
        driver.get(url);
    }

    static void searchSomething(WebDriver driver, String something) {
        driver.findElements(searchField).get(0).sendKeys(something);
        driver.findElements(searchForm).get(0).submit();
    }

    static boolean primaryResultsContainsLinkTo(WebDriver driver, String linkTo){
        for (WebElement element : driver.findElements(primaryResults)) {
            if(element.findElement(By.tagName("a")).getAttribute("href").contentEquals(linkTo)) return true;
        }
        return false;
    }
}
