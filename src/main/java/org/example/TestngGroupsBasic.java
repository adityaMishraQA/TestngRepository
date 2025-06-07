package org.example;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "Verification")
public class TestngGroupsBasic {

    @Test(priority = 2,groups = "Regression")
    public void test1()
    {
        System.out.println("Test one-Regression");
    }
    @Test(priority = 1,groups = {"Smoke","Regression"})
    public void test2()
    {
        System.out.println("Test two-Smoke and Regression");
    }
    @Test(priority = 3,groups = "Regression")
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



}