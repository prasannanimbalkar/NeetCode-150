package org.example;

//NeetCode-150- 5__Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build the frequency map
        // This map stores each number and its frequency in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            // Increment the frequency count for each number
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        System.out.println("Frequency Map: " +frequencyMap);

        // Step 2: Create a priority queue (max-heap) based on frequency
        // The lambda (a, b) -> map.get(b) - map.get(a) defines a comparator
        // that orders elements by decreasing frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n2) - frequencyMap.get(n1));
        // Add all unique elements (keys from the frequency map) to the priority queue
        heap.addAll(frequencyMap.keySet());

        System.out.println("PQ : " +heap);


        // Step 3: Extract the top k frequent elements
        int[] result = new int[k]; // Array to store the result
        for(int i = 0;i<k;i++){
            // Poll the element with the highest frequency from the priority queue
            result[i] = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        // Test the function with the provided examples
        int[] nums1 = {1,1,1,2,2,3,3,3,3,5,5,5,5,5,5};
        int k1 = 2;
        int[] result1 = topKFrequent(nums1, k1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1)); //Expected [5,3]

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = topKFrequent(nums2, k2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2)); //Expected [1]
    }
}
