package com.daniel;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-16 10:31
 */
public class Solution1089 {

    public void duplicateZeros(int[] arr) {
        if(arr == null){
            return;
        }

        int length = arr.length;
        if(length == 0){
            return;
        }

        for(int i = 0; i < length;){
            if(arr[i] == 0){
                i++;
                if(i < length){
                    backRemove(arr, i, length);
                    arr[i] = 0;
                    i++;
                }

            }else{
                i++;
            }
        }

    }

    public void backRemove(int[] arr, int index, int length){
        for(int i = length - 1; i >= index;){
            arr[i] = arr[--i];
        }
    }

    public static void main(String[] args) {
        Solution1089 solution1089 = new Solution1089();
        int[] arr = {};
        solution1089.duplicateZeros(arr);

        for(int tmp : arr){
            System.out.print(tmp + ",");
        }
        System.out.println();
    }
}
