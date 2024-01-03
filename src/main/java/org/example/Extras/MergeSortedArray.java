package org.example.Extras;

//https://leetcode.com/problems/merge-sorted-array/description/

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for nums1, nums2, and the merged array
        int p1 = m - 1, p2 = n - 1, pMerged = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerged] = nums1[p1];
                p1--;
            } else {
                nums1[pMerged] = nums2[p2];
                p2--;
            }
            pMerged--;
        }

        // Copy any remaining elements from nums2
        while (p2 >= 0) {
            nums1[pMerged] = nums2[p2];
            p2--;
            pMerged--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
