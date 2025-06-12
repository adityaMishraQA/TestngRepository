package org.example.listner;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProvieForm implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        System.out.println("Test  Failed");
    }

    @DataProvider(name = "DataProvide")
    public Object[] dataProvide(Method m)
    {
        if(m.getName().equals("test"))
        {
            return new Object[]{"Not possible"};
        }
        else {
            return new Object[]{"Gym","Graphics Card","Lamborgini","Chakka"};
        }

    }



}


