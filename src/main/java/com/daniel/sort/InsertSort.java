package com.daniel.sort;


/**
 * @author Daniel Xia
 * @since 2019/7/8 9:18
 */
public class InsertSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j - 1 > -1 && nums[j - 1] > nums[j]; j--) {
                swap(nums, j, j - 1);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int j, int i) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
