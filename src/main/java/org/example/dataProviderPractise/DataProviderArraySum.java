package org.example.dataProviderPractise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderArraySum {

    @DataProvider(name="hello")
    public Object[][] dataArray()
    {
        return new Object[][]
                {
                        {3, 2, 1, 4},
                        {2, 3, 1, 5, 7, 8, 9, 10, 4, 6},
                        {5, 7, 8, 9, 10, 4, 6},
                        {-2, 2, 3, 1, 5, 7, 8, 9, 10, 4, -6, 0}
                };
    }

    @Test(dataProvider = "hello")
    public void test2(int[] a)
    {
        int i,sum=0;

        for(i=0;i<a.length;i++)
        {
            sum=sum+a[i];

        }
        System.out.println(sum);
    }


}
