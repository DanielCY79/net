package com.daniel;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Daniel Xia
 * @since 2019/6/18 14:11
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        mergeSort(nums);
        return nums[nums.length / 2];
    }

    public void mergeSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        mergeProcess(nums, 0, nums.length - 1);
    }

    public void mergeProcess(int[] nums, int left, int right){
        if(left == right){
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeProcess(nums, left, mid);
        mergeProcess(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int i = 0;
        while(p1 <= mid && p2 <= right){
            if(nums[p1] <= nums[p2]){
                help[i++] = nums[p1++];
            }
            if(nums[p2] < nums[p1]){
                help[i++] = nums[p2++];
            }
        }

        while(p1 <= mid){
            help[i++] = nums[p1++];
        }

        while(p2 <= right){
            help[i++] = nums[p2++];
        }

        for(i = 0; i < help.length; i++){
            nums[left + i] = help[i];
        }
    }


}
