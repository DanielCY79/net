package com.daniel.sort;

/**
 * @author Daniel Xia
 * @since 2020-09-26 10:07
 */
public class HeapSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }

        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    private void heapify(int[] nums, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[largest] > nums[i] ? largest : i;
            if (largest == i) {
                break;
            }
            swap(nums, i, largest);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
