package com.mlytvyn.flatten;

import com.mlytvyn.flatten.i.Tree;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mlytvyn on 7/9/14.
 */
public class MyFlattenTreeTest {

    @Test
    public void testFlattenInOrder() throws Exception {
        Tree<Integer> $5 = new Tree.Leaf<Integer>(5);
        Tree<Integer> $4 = new Tree.Leaf<Integer>(4);
        Tree<Integer> $9 = new Tree.Leaf<Integer>(9);

        Tree<Integer> node_$5_$4_$9 = new Tree.Node<Integer>($5, $4, $9);

        Tree<Integer> $1 = new Tree.Leaf<Integer>(1);
        Tree<Integer> $6 = new Tree.Leaf<Integer>(6);

        Tree<Integer> tree = new Tree.Node<Integer>($1, node_$5_$4_$9, $6);

        MyFlattenTree<Integer> myTree = new MyFlattenTree<Integer>();

        List<Integer> expected = Arrays.asList(new Integer[]{1, 5, 4, 9, 6});
        List<Integer> actual = myTree.flattenInOrder(tree);

        Assert.assertEquals(actual, expected);
    }
}
