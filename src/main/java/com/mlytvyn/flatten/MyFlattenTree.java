package com.mlytvyn.flatten;

import com.mlytvyn.flatten.i.FlattenTree;
import com.mlytvyn.flatten.i.Function;
import com.mlytvyn.flatten.i.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Question
 * Implement a method that, given a tree as a parameter, will return an inorder
 * traversal of that tree.
 * Your implementation should throw an IllegalArgumentException if the tree is
 * null.
 * Your implementation must implement the FlattenTree interface
 */

/**
 * For example a tree like:
 * /|\
 * 1 | 6
 * /|\
 * 5 4 9
 */
public class MyFlattenTree<T> implements FlattenTree<T> {

    private Function<T, T> leafFunction = new Function<T, T>() {
        @Override
        public T apply(T p) {
            return p;
        }
    };

    private Function<Triple<Tree<T>>, Triple<Tree<T>>> nodeFunction = new Function<Triple<Tree<T>>, Triple<Tree<T>>>() {

        @Override
        public Triple<Tree<T>> apply(Triple<Tree<T>> p) {
            return p;
        }
    };

    private List<T> recursiveFlattenInOrder(Tree<T> tree, List<T> list) {
        if (tree == null)
            throw new IllegalArgumentException();

        if (tree.get().isLeft()) {
            list.add(tree.get().ifLeft(leafFunction));
            return list;
        }

        Triple<Tree<T>> branches = tree.get().ifRight(nodeFunction);

        recursiveFlattenInOrder(branches.left(), list);
        recursiveFlattenInOrder(branches.middle(), list);
        recursiveFlattenInOrder(branches.right(), list);

        return list;

    }

    public List<T> flattenInOrder(Tree<T> tree) {
        return recursiveFlattenInOrder(tree, new LinkedList<T>());
    }

}
