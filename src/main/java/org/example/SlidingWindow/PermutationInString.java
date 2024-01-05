package org.example.SlidingWindow;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false; // s1 can't be a substring of s2 if it's longer
        }

        // Frequency maps for characters in s1 and the current window in s2
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Fill the frequency map for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Map, s2Map)) {
                return true; // Found a permutation
            }
            // Move the window: remove the first character and add the next one
            s2Map[s2.charAt(i) - 'a']--;
            s2Map[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check the last window
        return matches(s1Map, s2Map);
    }

    // Helper function to compare two frequency maps
    private static boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("s2 contains a permutation of s1: " + checkInclusion(s1, s2));

        String s1b = "ab";
        String s2b = "eidboaoo";
        System.out.println("s2 contains a permutation of s1: " + checkInclusion(s1b, s2b));
    }
}
