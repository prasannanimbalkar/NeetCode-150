package org.example.SlidingWindow;
import java.util.*;

//Longest Repeating Character Replacement

//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
//https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int maxCount = 0; // Maximum count of a single character in the current window
        int maxLength = 0; // Maximum length of the substring
        int start = 0; // Start index of the sliding window

        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(rightChar));

            // If the current window size minus the count of the most frequent character is greater than k,
            // it means we have to perform more than k operations, so we shrink the window
            if (end - start + 1 - maxCount > k) {
                char leftChar = s.charAt(start);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Length of the longest substring: " + characterReplacement(s, k));
    }
}
