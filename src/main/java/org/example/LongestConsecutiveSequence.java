package org.example;

import java.util.*;

////NeetCode-150- 9__Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//https://leetcode.com/problems/longest-consecutive-sequence/description/


public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // Using a HashSet for constant-time lookups.
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Add each number to the set
        }

        int longestStreak = 0; // Variable to store the length of the longest streak

        // Iterate through each number in the set
        for (int num : numSet) {
            // Check if it's the start of a sequence
            // A number is the start of a sequence if num-1 is not in the set
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1; // Start the streak count from 1

                // Continue to the next number in the sequence if it exists in the set
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1; // Increase the streak count
                }

                // Update the longest streak if the current streak is longer
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        // Return the length of the longest consecutive sequence found
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2}; //expected output 4
        // Output the result
        System.out.println("The length of the longest consecutive elements sequence is " + longestConsecutive(nums));
    }
}
