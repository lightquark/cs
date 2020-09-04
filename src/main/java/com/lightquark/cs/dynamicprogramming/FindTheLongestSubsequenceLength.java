package com.lightquark.cs.dynamicprogramming;

public class FindTheLongestSubsequenceLength {

    public int find(String first, String second) {

        int firstSize = first.length();
        int secondSize = second.length();
        int[][] lookup = new int[firstSize + 1][secondSize + 1];

        for (int i = 1; i <= firstSize; i++) {
            for (int j = 1; j <= secondSize; j++) {

                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }

        return lookup[firstSize][secondSize];
    }

}
