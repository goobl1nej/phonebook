package ru.phonebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {
    @Test(invocationCount = 5)
    public void loadTestThisWebsite() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println("Page Title is " + driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}
