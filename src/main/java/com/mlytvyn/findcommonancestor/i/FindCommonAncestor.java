package com.mlytvyn.findcommonancestor.i;

public interface FindCommonAncestor {
    String findCommonAncestor(String[] commitHashes, String[][] parentHashes, String commitHash1, String commitHash2);
}
