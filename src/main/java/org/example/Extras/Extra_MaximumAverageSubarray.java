package org.example.Extras;

//https://leetcode.com/problems/maximum-average-subarray-i/description/

public class Extra_MaximumAverageSubarray {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0; // Sum of the current window
        double maxAvg = Integer.MIN_VALUE; // Initialize maxAvg with the smallest possible value

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Add the current element to the sum

            // Once we have a full window of size 'k'
            if (i >= k - 1) {
                double avg = sum / k; // Calculate the average for the current window
                maxAvg = Math.max(maxAvg, avg); // Update maxAvg if the current avg is greater

                sum -= nums[i - (k - 1)]; // Remove the element that is leaving the window
            }
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3}; //expected 12.75000
        int k = 4;
        System.out.println("Maximum average of a subarray of length " + k + " is: " + findMaxAverage(nums, k));
    }
}
