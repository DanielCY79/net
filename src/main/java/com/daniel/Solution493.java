package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019/6/26 9:15
 */
public class Solution493 {
    private int reverseCount;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        mergeSort(nums, 0, nums.length - 1);
        return reverseCount;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= right) {
            if(nums[p1] > 2 * (long)nums[p2]) {
                reverseCount += mid - p1 + 1;
                p2++;
            }else {
                p1++;
            }
        }

        p1 = left;
        p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                help[i++] = nums[p1++];
            } else {
                help[i++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }

        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{1, 3, 2, 3, 1};
        Solution493 solution493 = new Solution493();
        System.out.println(solution493.reversePairs(testArr));
    }
}
