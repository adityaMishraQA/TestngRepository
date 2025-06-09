package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSumOfNumber {


    @DataProvider
    public Object[][] dataSum() {
        return new Object[][]{
                {2, 3, 3},
                {1, 2, 4},
                {3, 2, 5}};
    }


    @Test(dataProvider = "dataSum")
    public void test1(int user, int pass, int passtwo) {
        System.out.println(user + pass + passtwo);
    }
}
