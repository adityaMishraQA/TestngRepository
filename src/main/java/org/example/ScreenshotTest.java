package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class ScreenshotTest{
    WebDriver driver=new ChromeDriver();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    @BeforeMethod(groups = "Smoke")
    public void screenShot()
    {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }
    @Test(description = "Taking screen shot test", groups = "Smoke")
    public void test() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        WebElement element=driver.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab']//child::a[text()='Electronics']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        Calendar calendar=Calendar.getInstance();
        int minute=calendar.get(Calendar.MINUTE);
        int sec=calendar.get(Calendar.SECOND);
        FileUtils.copyFile(screenshotFile,new File(""+ minute +""+ sec +".jpg"));
        throw new SkipException("Nhi karna");
    }

    @AfterMethod
    public void end()
    {
        driver.quit();
    }

}