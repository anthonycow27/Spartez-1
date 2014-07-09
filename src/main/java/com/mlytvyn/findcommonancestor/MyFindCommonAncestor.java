package com.mlytvyn.findcommonancestor;

import com.mlytvyn.findcommonancestor.i.FindCommonAncestor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Implement a function that will find the most recent common ancestor of any
 * two commits from a given commit graph. The commit graph is represented as a
 * String[] called commits containing all commit IDs in sorted date order (most
 * recent first) and a String[][] called parents. The parent IDs for the commit
 * ID at index i can be found at parents[i]. The last item in the parents array
 * is always null since this represents the parent of the root commit. For
 * example, the following commit graph:
 */
/*
 * ____E-F
 * ___/___\
 * A-B-C-D-G
 * Sample input:
 * String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
 * String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
 * String commit1 = "D";
 * String commit2 = "F";
 */
/*
 * The answer is B
 * Hint: It is possible to write an O(n) solution to this problem.
 */
public class MyFindCommonAncestor implements FindCommonAncestor {

    public String findCommonAncestor(String[] commitHashes, String[][] parentHashes, String commitHash1, String commitHash2) {
        Map<String, String[]> hashes = new HashMap<String, String[]>();
        for (int i = 0; i < commitHashes.length; i++) {
            hashes.put(commitHashes[i], parentHashes[i]);
        }
        List<String> commit1path = getCommitPath(commitHash1, hashes);
        List<String> commit2path = getCommitPath(commitHash2, hashes);

        System.out.println(commit1path);
        System.out.println(commit2path);
        for (String hash : commit1path) {
            if (commit2path.contains(hash)) {
                return hash;
            }
        }
        return null;
    }

    private List<String> getCommitPath(String commitHash, Map<String, String[]> hashes) {
        List<String> path = new LinkedList<String>();
        path.add(commitHash);
        int index = 0;
        while (hashes.get(path.get(index)) != null) {
            for (String hash : hashes.get(path.get(index))) {
                if (!path.contains(hash)) {
                    path.add(hash);
                }
            }
            index++;
            System.out.println(index + " " + path);
        }
//        path.remove(commitHash);
        return path;
    }

}
