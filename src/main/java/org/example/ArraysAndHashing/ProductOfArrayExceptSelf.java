package org.example.ArraysAndHashing;

//NeetCode-150- 6___Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//https://leetcode.com/problems/product-of-array-except-self/description/


public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        // Initialize the answer array with the same length as nums
        int[] answer = new int[nums.length];

        // Initialize left product as 1
        int leftprod = 1;
        // First loop: Calculate the product of all elements to the left of each element
        for (int i = 0; i < nums.length; i++) {
            // Set the current answer element to the product of all elements to the left
            answer[i] = leftprod;
            // Update the left product to include the current element
            leftprod *= nums[i];
        }


        // Initialize right product as 1
        int rightprod = 1;
        // Second loop: Calculate the product of all elements to the right of each element
        // and multiply it with the left product
        for (int i = nums.length - 1; i >= 0; i--) {
            // Multiply the current answer element with the product of all elements to the right
            answer[i] *= rightprod;
            // Update the right product to include the current element
            rightprod *= nums[i];
        }


        // Return the completed answer array
        return answer;
    }

    public static void main(String[] args) {
        // Example array
        int[] nums = {1, 2, 3, 4}; //Output: [24,12,8,6]
        int[] nums2 ={-1,1,0,-3,3}; //Output: [0,0,9,0,0]


        int[] result = productExceptSelf(nums);

        // Print the result
        System.out.print("Output: ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }



}
