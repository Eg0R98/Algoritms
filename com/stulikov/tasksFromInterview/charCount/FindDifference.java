package com.stulikov.tasksFromInterview.charCount;

public class FindDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd",  "abcde"));
    }

    public static char findTheDifference(String s, String t) {
        int[] counts = new int[26];

        char res = '0';

        for(char c: t.toCharArray()){
            counts[c- 'a']--;
        }

        for(char c: s.toCharArray()){
            counts[c- 'a']++;
        }

        for (int i = 0; i < counts.length; i++) {
            if(counts[i] != 0){
                res = (char) (i+'a');
            }
        }

        return res;
    }
}
