package org.example.annotationPractise.groupPractise;

import org.testng.annotations.*;

public class TestMethodClass {


    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("beforeSuiteMethod called");
    }

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("beforeClassMethod called");
    }

    @BeforeTest
    public void beforeTestMethod() {
        System.out.println("beforeTestMethod called");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod called");
    }

    @Test(priority = 0)
    public void test1() {
        System.out.println("Test1 called");
    }

    @Test(priority = 1)
    public void test2() {
        System.out.println("Test2 called");
    }

    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println("afterSuiteMethod called");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("afterClassMethod called");
    }

    @AfterTest
    public void afterTestMethod() {
        System.out.println("afterTestMethod called");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod called");
    }


}
