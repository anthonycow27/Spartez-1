package com.mlytvyn.iteration;

import com.mlytvyn.iteration.i.Folder;
import com.mlytvyn.iteration.i.Function2;

import java.util.Queue;

/**
 * Question.
 * Reimplement this code so that its results will always be the same, but that
 * it does not cause a stack overflow on large inputs. Your solution must still
 * implement the Folder interface.
 */
public class MyFolder<T, U> implements Folder<T, U> {

    @Override
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function) {
        if (u == null || ts == null || function == null) {
            throw new IllegalArgumentException();
        }

        do {
            u = function.apply(ts.poll(), u);
        } while (!ts.isEmpty());
        return u;
    }

    /**
     * Original fold method
     */
    @Deprecated
    public U originalFold(U u, Queue<T> ts, Function2<T, U, U> function) {
        if (u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        // return fold(function.apply(ts.poll(), u), ts, function);
        return null; // TODO implement it
    }
}
