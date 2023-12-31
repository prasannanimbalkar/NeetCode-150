package org.example.TwoPointers;
import java.util.*;

//NeetCode-150-  __Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for i
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        // Add the found triplet to the list
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Move left and right pointers and skip duplicates
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skipping duplicates for the right pointer as well
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + threeSum(nums1));

        int[] nums2 = {0, 1, 1};
        System.out.println("Triplets: " + threeSum(nums2));

        int[] nums3 = {0, 0, 0};
        System.out.println("Triplets: " + threeSum(nums3));
    }
}
