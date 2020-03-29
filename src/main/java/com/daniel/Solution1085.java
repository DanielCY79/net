package com.daniel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-15 22:32
 */
public class Solution1085 {

    public int sumOfDigits(int[] A) {
        if(A == null || A.length == 0){
            throw new IllegalArgumentException();
        }

        List<Integer> arrList = new ArrayList<>();
        for(int a : A){
            arrList.add(a);
        }

        Collections.sort(arrList);

        int min = arrList.get(0);
        int sum = 0;
        while(min != 0){
            sum = sum + min % 10;
            min = min / 10;
        }
        if(sum % 2 == 0){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] testArr = {34,23,1,24,75,33,54,8};
        Solution1085 solution1085 = new Solution1085();
        System.out.println(solution1085.sumOfDigits(testArr));
    }



}
