package org.example.TwoPointers;

//Two Sum II - Input Array Is Sorted

////NeetCode-150-  __Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

public class TwoSum_SortedArray {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0; // Start pointer
        int right = numbers.length - 1; // End pointer

        while (left < right) {
            int sum = numbers[left] + numbers[right]; // Calculate sum of two numbers

            if (sum == target) {
                // If the sum equals the target, return the indices (1-indexed)
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                // If sum is less than target, move left pointer to the right
                left++;
            } else {
                // If sum is greater than target, move right pointer to the left
                right--;
            }
        }

        return new int[] {-1, -1}; // Return -1 if no solution is found (should not happen as per problem statement)
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Indices: " + java.util.Arrays.toString(twoSum(numbers1, target1)));

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        System.out.println("Indices: " + java.util.Arrays.toString(twoSum(numbers2, target2)));

        int[] numbers3 = {-1, 0};
        int target3 = -1;
        System.out.println("Indices: " + java.util.Arrays.toString(twoSum(numbers3, target3)));
    }
}
