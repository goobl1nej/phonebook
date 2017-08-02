package ru.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class PhonebookServletTest {
    private String baseUrl = "http://localhost:8080/phonebook/";
    WebDriver driver;

    @BeforeClass
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver",File.separator+"dev/prog/chromedriver.exe");
        String baseUrl = "http://localhost:8080/phonebook/";
        driver=new ChromeDriver();
    }

    @AfterClass
    public void closeDriver() {
        if(driver!=null) driver.close();
    }

    @Test
    public void testAdd() throws Exception {
        driver.get(baseUrl+"phonebook?action=add");
        driver.findElement(By.name("lastName")).sendKeys("test2");
        driver.findElement(By.name("firstName")).sendKeys("testov2");
        driver.findElement(By.name("middleName")).sendKeys("testovich2");
        driver.findElement(By.name("birthday")).sendKeys("10.05.1958");
        driver.findElement(By.name("email")).sendKeys("test@tset");
        driver.findElement(By.name("phone")).sendKeys("8-800-535-35-35");
        driver.findElement(By.name("OK")).click();
    }
    @Test
    public void testLink() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Все контакты")).click();
        Assert.assertEquals(driver.getCurrentUrl().lastIndexOf("phonebook?action=all")!=-1, true);
    }

}