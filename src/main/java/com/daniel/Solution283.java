package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019/7/5 11:25
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }

        int start = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[end] != 0){
                nums[start++] = nums[end];
            }
        }

        for(int k = start; k < nums.length; k++){
            nums[k] = 0;
        }
    }
}
