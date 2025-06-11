package org.example.listner;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(org.example.listner.DataProvieForm.class)
public class DataProviderPractise {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void preSetUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://store.steampowered.com/");
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }

    @Test(dataProvider = "dataPass",dataProviderClass = org.example.listner.DataProvieForm.class)
    public void test(String data)
    {
        WebElement element=driver.findElement(By.xpath("//a[@class='gutter_item' and @href='https://store.steampowered.com/genre/Free%20to%20Play/?snr=1_4_4__125']"));
        actions.scrollToElement(element);
        actions.perform();
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        WebElement element1=driver.findElement(By.id("store_nav_search_term"));
        wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
        element1.sendKeys(""+data+"");

    }
    @Test
    public void test2()
    {
        System.out.println("Test two going to start");
        throw new SkipException("Skipping");
    }

    @AfterMethod
    public void postSetUp()
    {
        driver.close();
    }




}