package com.stulikov.tasksFromInterview.charCount;

public class JewelsStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        boolean[] jewel = new boolean[128];

        for (char j : jewels.toCharArray()) {
            jewel[j] = true;
        }

        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewel[s]) {
                count++;
            }
        }

        return count;
    }
}
