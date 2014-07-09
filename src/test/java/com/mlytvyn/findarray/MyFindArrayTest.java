package com.mlytvyn.findarray;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by mlytvyn on 7/9/14.
 */
public class MyFindArrayTest {

    private MyFindArray testClass;

    @BeforeMethod
    public void setUp() throws Exception {
        testClass = new MyFindArray();
    }

    @Test
    public void testSubArrayInTheMiddle() throws Exception {
        int[] A = {4, 9, 3, 7, 8};
        int[] B = {3, 7};
        Assert.assertEquals(testClass.findArray(A, B), 2);
    }

    @Test
    public void testSubArrayAtFirstPosition() throws Exception {
        int[] A = {1, 3, 5};
        int[] B = {1};
        Assert.assertEquals(testClass.findArray(A, B), 0);
    }

    @Test
    public void testSubArrayNotFound() throws Exception {
        int[] A = {7, 8, 9};
        int[] B = {8, 9, 10};
        Assert.assertEquals(testClass.findArray(A, B), -1);
    }
}
