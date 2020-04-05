package com.daniel;

/**
 * @author danielxia
 * @since 2020/3/29
 */
public class Solution33 {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        search(nums, 1);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            // 计算中间下标 (防止溢出)
            mid = start + (end - start) / 2;
            // 若中间位置的数等于 target，立即返回下标
            if (nums[mid] == target) {
                return mid;
            }
            // 若 nums[start] 小于等于 num[mid]，说明是 3 4 5 6 7 1 2 的情况，此时左边有序
            if (nums[start] <= nums[mid]) {
                // nums[start] <= target < nums[mid]，说明 target 在左边，从左边找
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    // 反之，从右边找
                    start = mid + 1;
                }
            } else {
                // 若 nums[start] 小于等于 num[mid]，说明是 6 7 1 2 3 4 5 的情况，此时右边有序
                // nums[mid] < target <= nums[end]，说明 target 在右边，从右边找
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    // 反之，从左边找
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
