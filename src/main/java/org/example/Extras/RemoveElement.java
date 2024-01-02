package org.example.Extras;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        return insertPos;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = removeElement(nums, val);
        System.out.println("New length: " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
