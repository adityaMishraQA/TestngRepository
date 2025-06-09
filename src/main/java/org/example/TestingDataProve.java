package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestingDataProve {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void preSetup()
    {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       wait=new WebDriverWait(driver, Duration.ofSeconds(20));
       driver.get("https://practicetestautomation.com/practice-test-login/");
       driver.manage().window().maximize();

    }



    @Test(dataProvider = "dataProve")
    public void test(String username)
    {
      WebElement element=driver.findElement(By.xpath("//input[@name='username']"));
      WebElement element1=driver.findElement(By.id("submit"));
      wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(username);
      wait.until(ExpectedConditions.visibilityOf(element1)).click();
    }

    @AfterMethod
    public void postSetup()
    {
        driver.close();
    }


    @DataProvider
    public Object[] dataProve()
    {
        return new Object[]{
                "Hellouser",
                "User_1999",
                "2000_User"};


    }


}
