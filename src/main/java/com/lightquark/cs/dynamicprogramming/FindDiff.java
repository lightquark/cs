package com.lightquark.cs.dynamicprogramming;

public class FindDiff {

    public String find(String first, String second) {

        int firstSize = first.length();
        int secondSize = second.length();
        int[][] lookup = new int[firstSize + 1][secondSize + 1];

        fillLCS(first, second, firstSize, secondSize, lookup);

        return diff(first, second, firstSize, secondSize, lookup);
    }

    public String diff(String first, String second, int firstIndex, int secondIndex, int[][] lookup) {

        if (firstIndex > 0 && secondIndex > 0 && first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1)) {

            return diff(first, second, firstIndex - 1, secondIndex - 1, lookup) + first.charAt(firstIndex - 1);

        } else if (firstIndex > 0 && (secondIndex == 0
                || lookup[firstIndex][secondIndex - 1] < lookup[firstIndex - 1][secondIndex])) {

            return diff(first, second, firstIndex - 1, secondIndex, lookup) + "-" + first.charAt(firstIndex - 1);

        } else if (secondIndex > 0 && (firstIndex == 0
                || lookup[firstIndex][secondIndex - 1] >= lookup[firstIndex - 1][secondIndex])) {

            return diff(first, second, firstIndex, secondIndex - 1, lookup) + "+" + second.charAt(secondIndex - 1);
        }
        return "";
    }

    public void fillLCS(String first, String second, int firstIndex, int secondIndex, int[][] lookup) {

        for (int i = 1; i <= firstIndex; i++) {
            for (int j = 1; j <= secondIndex; j++) {

                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
    }

}
