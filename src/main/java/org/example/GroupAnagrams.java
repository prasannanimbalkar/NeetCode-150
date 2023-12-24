package org.example;

import java.util.*;

//NeetCode-150- 4__Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Handle the edge case where the input array is empty
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // HashMap to store the groups of anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array and sort it
            System.out.println(s);
            char[] characters = s.toCharArray();
            Arrays.sort(characters);

            // Convert the sorted character array back to a string
            String sorted = new String(characters);

            // Check if the sorted string is already a key in the map
            if (!map.containsKey(sorted)) {
                // If it's not, add it with a new list as its value
                map.put(sorted, new ArrayList<>());
            }
            // Add the original string to the list associated with the sorted string
            map.get(sorted).add(s);
        }

        // Return the values of the map as a new list
        // Each value in the map is a list of anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Create an instance of the solution class
        GroupAnagrams solution = new GroupAnagrams();

        // Example input array of strings
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Group the anagrams
        List<List<String>> groupedAnagrams = solution.groupAnagrams(strs);

        // Print each group of anagrams
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}

