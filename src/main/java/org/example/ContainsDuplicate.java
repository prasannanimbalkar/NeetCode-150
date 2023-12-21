package org.example;

import java.util.HashSet;
import java.util.Set;

//Contains Duplicate


//NeetCode-150- 1__Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//https://leetcode.com/problems/contains-duplicate/description/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> seen = new HashSet<>();
//        for (int num : nums) {
//            if (seen.contains(num)) {
//                return true; // Found a duplicate
//            }
//            seen.add(num);
//        }
//        return false; // No duplicates found



        Set<Integer> set = new HashSet<>();

        for(int  num : nums){
            if(!set.add(num)) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Example 1: " + solution.containsDuplicate(nums1)); // Expected output: true

        // Test example 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Example 2: " + solution.containsDuplicate(nums2)); // Expected output: false

        // Test example 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Example 3: " + solution.containsDuplicate(nums3)); // Expected output: true
    }
}
