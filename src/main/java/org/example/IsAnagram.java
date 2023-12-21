package org.example;

import java.util.HashMap;
import java.util.Map;

//Valid Anagram


//NeetCode-150- 2__Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//https://leetcode.com/problems/valid-anagram/description/

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        // If the lengths of the strings are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counter = new HashMap<>();

        //This loop goes through each character in s. For each character,
        // it uses the getOrDefault method to get the current count
        // (defaulting to 0 if the character is not yet in the map) and then increments this count by 1.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        //This loop checks each character in t. There are two conditions that lead to returning false:
        //If a character ch from t is not found in the map (!counter.containsKey(ch)), it means t has a character not present in s.
        //If the count of ch in the map is 0 (counter.get(ch) == 0), it means t has more occurrences of ch than s does.
        //If neither condition is met, the count of ch in the map is decremented by 1.
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!counter.containsKey(ch) || counter.get(ch) == 0) {
                return false;
            }
            counter.put(ch, counter.get(ch) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t)); // Output: true

        s = "rat";
        t = "car";
        System.out.println(isAnagram(s, t)); // Output: false
    }
}
