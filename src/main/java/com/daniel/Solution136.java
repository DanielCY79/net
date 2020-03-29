package com.daniel;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-29 18:23
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }

}
