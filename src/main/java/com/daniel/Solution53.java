package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019/7/3 11:03
 */
public class Solution53 {

    private int max = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return maxSubArrayProcess(nums, 0, nums.length - 1);
//        return maxSubArrayProcessDp(nums);
    }

    public int maxSubArrayProcess(int[] arr, int start, int stop){
        if(start == stop){
            return arr[start];
        }

        int sum = 0;
        for(int i = start; i <= stop; i++){
            sum += arr[i];
        }

        max = Math.max(sum, Math.max(maxSubArrayProcess(arr, start, stop - 1), maxSubArrayProcess(arr, start + 1, stop)));
        return max;
    }

//    public int maxSubArrayProcessDp(int[] arr){
//        if(arr == null || arr.length == 0){
//            return 0;
//        }
//        if(arr.length == 1){
//            return arr[0];
//        }
//
//
//        return dp[0];
//    }

    public static void main(String[] args) {
        int[] testArr = {-2,1,-3,4,-1,2,1,-5,4};
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(testArr));
    }
}
