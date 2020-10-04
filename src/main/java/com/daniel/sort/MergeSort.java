package com.daniel.sort;

/**
 * @author Daniel Xia
 * @since 2020-09-26 08:26
 */
public class MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            help[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while (p2 <= right) {
            help[index++] = nums[p2++];
        }
        for (index = 0; index < help.length; index++) {
            nums[left + index] = help[index];
        }
    }

}
