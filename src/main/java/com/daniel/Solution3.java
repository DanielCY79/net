package com.daniel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Xia
 * @since 2019/7/4 16:16
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int end = 0; end < s.length(); end++){
            if(map.containsKey(s.charAt(end))){
               start = Math.max(start, map.get(s.charAt(end)));
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }

        return maxLength;
    }

}
