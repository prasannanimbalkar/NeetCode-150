package org.example.TwoPointers;

//Trapping Rain Water

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1; // Initialize pointers
        int maxLeft = 0, maxRight = 0; // Max heights from left and right
        int trappedWater = 0; // Total trapped water

        while (left < right) {
            if (height[left] < height[right]) {
                // If left height is smaller than right
                if (height[left] >= maxLeft) {
                    // Update maxLeft if current is greater
                    maxLeft = height[left];
                } else {
                    // Calculate and add trapped water to the total
                    trappedWater += maxLeft - height[left];
                }
                left++; // Move left pointer
            } else {
                // If right height is smaller or equal to left
                if (height[right] >= maxRight) {
                    // Update maxRight if current is greater
                    maxRight = height[right];
                } else {
                    // Calculate and add trapped water to the total
                    trappedWater += maxRight - height[right];
                }
                right--; // Move right pointer
            }
        }

        return trappedWater; // Return the total trapped water
    }

    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water: " + trap(height1));

        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Trapped Water: " + trap(height2));
    }
}
