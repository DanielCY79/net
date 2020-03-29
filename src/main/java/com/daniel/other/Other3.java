package com.daniel.other;

/**
 * [1, 2, 100, 4] 两个人，从两边取数，问获胜的人点数总和
 *
 * @author Daniel Xia
 * @since 2019-07-03 20:36
 */
public class Other3 {

    public int win(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return Math.max(
                first(nums, 0, nums.length - 1),
                second(nums, 0, nums.length - 1)
        );
    }

    public int first(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        return Math.max(
                nums[left] + second(nums, left + 1, right),
                nums[right] + second(nums, left, right - 1)
        );
    }

    public int second(int[] nums, int left, int right) {
        if(left == right){
            return 0;
        }

        return Math.min(
                first(nums, left + 1, right),
                first(nums, left, right - 1)
        );
    }

    public static void main(String[] args) {
        int[] testArr= {1, 5, 2};

        Other3 other3 = new Other3();
        System.out.println(other3.win(testArr));
    }

}
