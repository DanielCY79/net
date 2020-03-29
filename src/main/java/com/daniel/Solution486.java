package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019/7/4 10:22
 */
public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }

        return first(nums, 0, nums.length - 1) >= second(nums, 0, nums.length - 1);
    }

    private int second(int[] nums, int left, int right) {
        if(left == right){
            return 0;
        }

        return Math.min(
            first(nums, left + 1, right),
            first(nums, left, right - 1)
        );

    }

    private int first(int[] nums, int left, int right) {
        if(left == right){
            return nums[left];
        }

        return Math.max(
                nums[left] + second(nums, left + 1, right),
                nums[right] + second(nums, left, right - 1)
        );
    }


}
