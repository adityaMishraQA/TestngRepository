package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestApi {
    @Test(priority = 0,groups = "Smoke")
    public void test1()
    {
        System.out.println("Running test one");
    }
    @Test(priority = 2,groups = "Regression")
    public void test2()
    {
        System.out.println("Running test two");
    }
    @BeforeTest
    public void initial()
    {
        System.out.println("Pre test");
    }
    @AfterMethod
    public void afterInitial()
    {
        System.out.println("Post mid");
    }
    @AfterTest
    public void post()
    {
        System.out.println("final process");
    }
}
