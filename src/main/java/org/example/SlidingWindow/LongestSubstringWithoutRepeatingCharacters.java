package org.example.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest
//substring
// without repeating characters.
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0; // Handle empty string case
        }

        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map, move the start pointer
            if (charMap.containsKey(currentChar)) {
                start = Math.max(start, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, end); // Update the character's index

            maxLength = Math.max(maxLength, end - start + 1); // Update the max length
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Length of the longest substring: " + lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Length of the longest substring: " + lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Length of the longest substring: " + lengthOfLongestSubstring(s3));
    }
}


//Handling Special Cases:
//
//java
//Copy code
//if (s == null || s.length() == 0) {
//    return 0; // Handle empty string case
//}
//This checks if the input string s is null or empty. If it is, the function returns 0 since there's no substring to consider.
//
//Data Structures Used:
//
//java
//Copy code
//Map<Character, Integer> charMap = new HashMap<>();
//int maxLength = 0;
//int start = 0;
//charMap: A HashMap that stores characters and their indices. This helps in quickly finding and updating the last occurrence of a character.
//maxLength: Tracks the length of the longest substring found so far.
//start: The starting index of the current window of unique characters.
//Iterating Through the String:
//
//java
//Copy code
//for (int end = 0; end < s.length(); end++) {
//    char currentChar = s.charAt(end);
//    ...
//}
//A for loop iterates over the string with end acting as the ending index of the current window. currentChar is the character at the current end index.
//
//Adjusting the Start Index:
//
//java
//Copy code
//if (charMap.containsKey(currentChar)) {
//    start = Math.max(start, charMap.get(currentChar) + 1);
//}
//If currentChar is already in charMap, it means the character has been seen before within the current window. The start index is moved to the right of the last occurrence of currentChar to ensure the window has unique characters only. The Math.max is used to handle cases where start is already ahead of the last occurrence of currentChar.
//
//Updating HashMap and Maximum Length:
//
//java
//Copy code
//charMap.put(currentChar, end); // Update the character's index
//maxLength = Math.max(maxLength, end - start + 1); // Update the max length
//The current character's index is updated in charMap.
//The length of the current window (end - start + 1) is calculated. If this is greater than maxLength, then maxLength is updated. This keeps track of the maximum length of a substring without repeating characters found so far.
//Returning the Result:
//
//java
//Copy code
//return maxLength;
//After the loop completes, maxLength holds the length of the longest substring without repeating characters, which is returned as the result.
//
//The code efficiently finds the longest substring without repeating characters by dynamically adjusting the window (start to end) to ensure uniqueness of characters within it and calculating the length of such windows.
