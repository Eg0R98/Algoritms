package com.stulikov.tasksFromInterview.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagramArray("anagram", "nagaram"));
    }

    public static boolean isAnagramMap(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();

        char[] charS = s.toCharArray();

        for (int i = 0; i < charS.length; i++) {
            if(mapS.containsKey(charS[i])){
                mapS.put(charS[i], mapS.get(charS[i])+1);
            } else {
                mapS.put(charS[i], 1);
            }
        }

        System.out.println(mapS);

        Map<Character, Integer> mapT = new HashMap<>();
        char[] charT = t.toCharArray();

        for (int i = 0; i < charT.length; i++) {
            if(mapT.containsKey(charT[i])){
                mapT.put(charT[i], mapT.get(charT[i])+1);
            } else {
                mapT.put(charT[i], 1);
            }
        }

        System.out.println(mapT);


        return mapS.equals(mapT);
    }

    public static boolean isAnagramArray(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] counts = new int[26];

        for(char c: s.toCharArray()){
            counts[c- 'a']++;
        }

        for(char c: t.toCharArray()){
            counts[c- 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramSort(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}
