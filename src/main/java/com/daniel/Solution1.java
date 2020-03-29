package com.daniel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Xia
 * @since 2019-07-09 15:05
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int ele = target - nums[i];
            if(map.containsKey(ele)){
                return new int[]{i, map.get(ele)};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
