package org.example.TwoPointers;


//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0; // To keep track of the maximum area found
        int left = 0; // Starting pointer
        int right = height.length - 1; // Ending pointer

        while (left < right) {
            // Calculate the area with the current pair of lines
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea); // Update maxArea if the current area is larger

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum area found
    }

    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum Water Container Area: " + maxArea(height1));

        int[] height2 = {1,1};
        System.out.println("Maximum Water Container Area: " + maxArea(height2));
    }
}
