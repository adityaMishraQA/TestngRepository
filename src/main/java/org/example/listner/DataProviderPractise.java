package org.example.listner;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;

@Listeners(org.example.listner.DataProvieForm.class)
public class DataProviderPractise{

    WebDriver driver;
    WebDriverWait wait;
    Actions act;


    @Parameters("browser")
    @BeforeTest
    public void preSetup(String browser)
    {
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equals("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();


    }

    @Test(enabled = false,priority = 0,dataProvider = "DataProvide",dataProviderClass = org.example.listner.DataProvieForm.class)
    public void test(String name)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        act=new Actions(driver);
        WebElement element=driver.findElement(By.xpath(""));
        wait.until(ExpectedConditions.visibilityOf(element));
        act.moveToElement(element);
        act.perform();

    }
    @Test(priority = 1,dataProvider = "DataProvide",dataProviderClass = org.example.listner.DataProvieForm.class)
    public void test2(String name) throws IOException {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        act=new Actions(driver);

        /*WebElement element1=driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
        element1.click();*/
        WebElement element2=driver.findElement(By.xpath("//input[starts-with(@title,'S')]"));
        wait.until(ExpectedConditions.elementToBeClickable(element2)).click();
        element2.clear();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Calendar calendar=Calendar.getInstance();
        int min=calendar.get(Calendar.MINUTE);
        int sec=calendar.get(Calendar.SECOND);
        FileUtils.copyFile(screenshotFile,new File(".//Screenshots//"+min+"-"+sec+".jpg"));
        element2.sendKeys(""+name+""+ Keys.ENTER);
        System.out.println(name);
        WebElement element3=driver.findElement(By.xpath("//span[text()='Yes']"));
        wait.until(ExpectedConditions.elementToBeClickable(element3));
        act.scrollToElement(element3);
        act.perform();





    }

    @AfterTest
    public void postSetup()
    {
        driver.close();
    }
}