package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUI {
    @BeforeTest
    public void pre()
    {
        System.out.println("Pre process");
    }
    @BeforeMethod
    public void beforePre()
    {
        System.out.println("Catche delete");
    }
    @Test(priority = 2,groups = "Smoke")
    public void test1()
    {
        System.out.println("Testing one");
    }
    @Test(priority = 0,groups = "Regression")
    public void test2()
    {
        System.out.println("Testing two");
    }
    @AfterTest()
    public void post()
    {
        System.out.println("post Cache");
    }
}
