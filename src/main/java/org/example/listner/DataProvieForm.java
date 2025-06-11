package org.example.listner;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;

public class DataProvieForm implements ITestListener {

    @DataProvider(name = "dataPass")
    public Object[] data()
    {
        return new Object[]{"cs"};
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("Test got skipped");
    }
}
