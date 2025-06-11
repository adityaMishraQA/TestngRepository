package org.example.dataProviderPractise;

import org.testng.annotations.Test;

public class SumOfArrayElement {

    @Test
    public void test2()
    {
        int[] a={2,3,4};
        int i,sum=0;
        for(i=0;i<a.length;i++)
        {
            sum=sum+a[i];
        }
        System.out.println(sum);
    }
}
