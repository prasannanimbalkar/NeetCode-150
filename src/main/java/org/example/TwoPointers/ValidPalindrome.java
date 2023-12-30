package org.example.TwoPointers;

//Valid Palindrome

//NeetCode-150- __A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
// it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.

//https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {
        public static boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1; // Initialize two pointers

            while (left < right) {
                // Skip non-alphanumeric characters from the left
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                // Skip non-alphanumeric characters from the right
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                // Compare the characters at the left and right pointers
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false; // If they are not equal, it's not a palindrome
                }

                // Move the pointers towards the center
                left++;
                right--;
            }

            return true; // If all characters matched correctly, it's a palindrome
        }

        public static void main(String[] args) {
            // Example 1
            String input1 = "A man, a plan, a canal: Panama";
            System.out.println("Is \"" + input1 + "\" a palindrome? " + isPalindrome(input1));

            // Example 2
            String input2 = "race a car";
            System.out.println("Is \"" + input2 + "\" a palindrome? " + isPalindrome(input2));

            // Example 3
            String input3 = " ";
            System.out.println("Is \"" + input3 + "\" a palindrome? " + isPalindrome(input3));
        }


}
