package com.mlytvyn.findarray;

import com.mlytvyn.findarray.i.FindArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question
 * Implement a method that given two arrays as parameters will find the starting
 * index where the second parameter occurs as a sub-array in the array given as
 * the first parameter.
 * Your implementations should return -1 if the sub-array cannot be found.
 * Your implementation must implement the FindArray interface.
 */

/**
 * Sample Input:
 * [4,9,3,7,8] and [3,7] should return 2.
 * [1,3,5] and [1] should return 0.
 * [7,8,9] and [8,9,10] should return -1.
 */
public class MyFindArray implements FindArray {

    @Override
    public int findArray(int[] array, int[] subArray) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (subArray == null || subArray.length == 0) {
            return -1;
        }
        if (subArray.length > array.length) {
            return -1;
        }
        return Collections.indexOfSubList(convertArrayToList(array), convertArrayToList(subArray));
    }

    private List<Integer> convertArrayToList(int[] array) {
        if (array == null) {
            return null;
        }
        List<Integer> output = new ArrayList<Integer>(array.length);
        for (int i = 0; i < array.length; i++) {
            output.add(Integer.valueOf(array[i]));
        }
        return output;
    }

}
