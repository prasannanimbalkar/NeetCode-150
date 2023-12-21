package org.example;

import java.util.HashMap;
import java.util.Map;

//Two Sum

//NeetCode-150- 3__Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//https://leetcode.com/problems/two-sum/description/

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            //If the complement exists in the map, it means we have found a pair whose sum is equal to the target.
            //The indices of these two numbers (the current index i and the index of the complement from the map) are then returned.
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] indices = twoSum(nums, target);
        System.out.println("Index1: " + indices[0] + ", Index2: " + indices[1]);
    }
}
