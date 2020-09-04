package com.lightquark.cs.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllLongestSubsequences {

    public Set<String> find(String first, String second) {

        int firstSize = first.length();
        int secondSize = second.length();
        int[][] lookup = fillLookup(first, second);

        List<String> values = findLCS(first, second, firstSize, secondSize, lookup);

        return new HashSet<>(values);
    }

    private List<String> findLCS(String first, String second, int firstIndex, int secondIndex, int[][] lookup) {

        if (firstIndex == 0 || secondIndex == 0) {
            List<String> values = new ArrayList<>();
            values.add("");
            return values;
        }

        if (first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {
            List<String> values = findLCS(first, second, firstIndex - 1, secondIndex - 1, lookup);
            for (int i = 0; i < values.size(); i++) {
                String v = values.get(i);
                values.set(i, values.get(i) + first.charAt(firstIndex - 1));
            }
            return values;
        }

        if (lookup[firstIndex - 1][secondIndex] > lookup[firstIndex][secondIndex - 1]) {
            return findLCS(first, second, firstIndex - 1, secondIndex, lookup);
        }

        if (lookup[firstIndex][secondIndex - 1] > lookup[firstIndex - 1][secondIndex]) {
            return findLCS(first, second, firstIndex, secondIndex - 1, lookup);
        }

        List<String> one = findLCS(first, second, firstIndex - 1, secondIndex, lookup);
        List<String> two = findLCS(first, second, firstIndex, secondIndex - 1, lookup);
        one.addAll(two);
        return one;
    }

    private int[][] fillLookup(String first, String second) {

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
        return lookup;
    }

}
