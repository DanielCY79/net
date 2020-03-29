package com.daniel;

/**
 *
 * @author Daniel Xia
 * @since 2019-07-07 08:37
 */
public class Solution912 {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;

    }

    public int[] heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while(heapSize > 0){
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }

        return nums;
    }

    private void heapify(int[] nums, int index, int heapSize) {
        int left = index * 2 + 1;
        while(left < heapSize){
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(nums, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] nums, int index) {
        while(nums[index] > nums[(index - 1) / 2]){
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /// Quick sort

    private void quickSort(int[]nums, int left, int right){
        if(left < right){
            swap(nums, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(nums, left, right);
            quickSort(nums, left, p[0] - 1);
            quickSort(nums, p[0] + 1, right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        while(left < more){
            if(nums[left] < nums[right]){
                swap(nums, ++less, left++);
            }else if(nums[left] > nums[right]){
                swap(nums, --more, left);
            }else{
                left++;
            }
        }

        swap(nums, more, right);
        return new int[]{less + 1, more};
    }


    /// Merge sort

    private void mergeSort(int[] nums, int left, int right) {
        if(left == right){
            return;
        }

        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int i = 0;
        while(p1 <= mid && p2 <= right){
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
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

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
