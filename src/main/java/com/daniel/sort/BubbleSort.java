package com.daniel.sort;

import java.util.Arrays;

/**
 * @author danielxia
 * @since 2020/4/12
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {9, 6, 0, 5, 4, 3, 2, 1};
        BubbleSort bubbleSort = new BubbleSort();
        nums = bubbleSort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }

        bubbleSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void bubbleSort(int[] nums, int index, int length) {
        for(int i = nums.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j + 1, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
