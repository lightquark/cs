package com.lightquark.cs.dynamicprogramming;

/**
 * Time complexity: O(n^2)
 * Space: O(n^2)
 */
public class FindTheLongestSubstring {

    public String find(String first, String second) {

        int firstSize = first.length();
        int secondSize = second.length();
        int maxlen = -1;
        int endIndex = -1;

        int[][] lookup = new int[firstSize + 1][secondSize + 1];
        for (int i = 0; i < firstSize; i++) {
            for (int j = 0; j < secondSize; j++) {

                if (first.charAt(i) == second.charAt(j)) {
                    lookup[i + 1][j + 1] = lookup[i][j] + 1;
                    if (lookup[i + 1][j + 1] > maxlen) {
                        maxlen = lookup[i + 1][j + 1];
                        endIndex = i + 1;
                    }
                }
            }
        }

        return maxlen >= 0 ? first.substring(endIndex - maxlen, endIndex) : null;
    }
}
