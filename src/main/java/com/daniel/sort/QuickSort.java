package com.daniel.sort;

/**
 * @author Daniel Xia
 * @since 2019-07-07 10:59
 */
public class QuickSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, right, left + (int) (Math.random() * (right - left + 1)));
            int[] p = partition(nums, left, right);
            quickSort(nums, left, p[0] - 1);
            quickSort(nums, p[1] + 1, right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, --more, left);
            } else {
                left++;
            }
        }
        swap(nums, right, more);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
