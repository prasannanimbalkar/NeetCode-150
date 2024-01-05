package org.example.SlidingWindow;


//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//In other words, return true if one of s1's permutations is the substring of s2.
//https://leetcode.com/problems/permutation-in-string/description/

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s) {
        // Create a frequency array for characters in s1
        int[] target = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }

        // Create a frequency array to keep track of characters in the current window of s
        int[] pending = new int[26];

        // Initialize pointers and variables for window size and string lengths
        int begin = 0, end = 0, n = s.length(), m = s1.length();
        char c;

        // Iterate over string s
        while (end < n) {
            c = s.charAt(end); // Get current character
            pending[c - 'a']++; // Update its frequency in the current window

            // If the frequency of the current character in the window exceeds its frequency in s1
            while (pending[c - 'a'] > target[c - 'a']) {
                // Move the start of the window forward and decrease the frequency of the character at 'begin'
                pending[s.charAt(begin++) - 'a']--;
            }

            // Move the end of the window forward
            end++;

            // Check if the size of the current window matches the length of s1
            // If so, it means a permutation of s1 is found in s
            if (end - begin == m) return true;
        }

        // Return false if no permutation of s1 is found in s
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("s2 contains a permutation of s1: " + checkInclusion(s1, s2));

        String s1b = "ab";
        String s2b = "eidboaoo";
        System.out.println("s2 contains a permutation of s1: " + checkInclusion(s1b, s2b));
    }
}


//Two frequency arrays target and pending are used. target stores the frequency of each character in s1, while pending tracks the frequencies in the current sliding window of s.
//The window is defined by begin and end pointers.
//The outer while loop expands the window by moving end. If the frequency of any character in the window exceeds its frequency in s1, the inner while loop contracts the window by moving begin.
//If at any point the size of the window (end - begin) equals the length of s1 (m), it implies that a permutation of s1 is found in s, and the method returns true.
//If the loop completes without finding such a window, the method returns false.