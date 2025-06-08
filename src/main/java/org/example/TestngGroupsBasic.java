package org.example;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "Verification")
public class TestngGroupsBasic {

    @Test(priority = -25,groups = "Regression")
    public void test1()
    {
        System.out.println("Test one-Regression");
    }
    @Test(priority = 52,groups = {"Smoke","Regression"})
    public void test2()
    {
        System.out.println("Test two-Smoke and Regression");
    }
    @Test(priority = -14,groups = "Regression")
    public void test3()
    {
        System.out.println("Test three - Regression");
    }
    @BeforeTest
    public void beforeTest4()
    {
        System.out.println("Before test");
    }
    @BeforeTest
    public void beforeTest3()
    {
        System.out.println("Before test");
    }
    @AfterTest
    public void afterTest1()
    {
        System.out.println("After test");
    }



}