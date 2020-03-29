package com.daniel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel Xia
 * @since 2019-06-24 21:18
 */
public class Solution315 {
    private List<Integer> resList = new ArrayList<>();

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return resList;
        }
        if(nums.length == 1){
            resList.add(0);
            return resList;
        }

        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resList.add(0);
            pairs[i] = new Pair(i, nums[i]);
        }

        mergeSort(pairs, 0, nums.length - 1);
        return resList;

    }

    public void mergeSort(Pair[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(Pair[] nums, int left, int mid, int right) {
        Pair[] help = new Pair[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1].value <= nums[p2].value) {
                int great = p2 - (mid + 1);
                if (great > 0) {
                    resList.set(nums[p1].index, resList.get(nums[p1].index) + great);
                }
                help[i++] = nums[p1++];
            } else {
                help[i++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            int great = p2 - (mid + 1);
            resList.set(nums[p1].index, resList.get(nums[p1].index) + great);
            help[i++] = nums[p1++];
        }
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }

        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }



    private static class Pair {
        private Integer index;

        private Integer value;

        public Pair(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Solution315 solution315 = new Solution315();
        int[] nums = {5, 2, 6, 1};
        System.out.println(solution315.countSmaller(nums));

    }

}
