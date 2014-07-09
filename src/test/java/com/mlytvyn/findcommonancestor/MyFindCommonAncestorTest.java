package com.mlytvyn.findcommonancestor;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by mlytvyn on 7/9/14.
 */
public class MyFindCommonAncestorTest {

    private MyFindCommonAncestor testClass;

    @BeforeMethod
    public void setUp() throws Exception {
        testClass = new MyFindCommonAncestor();
    }

    @Test
    public void testFindCommonAncestor() throws Exception {
        String[] commitHashes = {"G", "F", "E", "D", "C", "B", "A"};
        String[][] parentHashes = {{"F", "D"}, {"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
        String commitHash1 = "D";
        String commitHash2 = "F";
        String result = testClass.findCommonAncestor(commitHashes, parentHashes, commitHash1, commitHash2);
        Assert.assertEquals(result, "B");

    }
}
