package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019-07-07 21:52
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] manacher = getManacher(s);
        int[] pArr = new int[manacher.length];
        int c = -1;
        int r = -1;
        int maxC = -1;
        int maxLength = -1;
        for (int i = 0; i < manacher.length; i++) {
            pArr[i] = i < r ? Math.min(pArr[2 * c - i], r - i) : 1;
            while (i + pArr[i] < manacher.length && i - pArr[i] > -1) {
                if (manacher[i + pArr[i]] == manacher[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > r) {
                r = i + pArr[i];
                c = i;
            }
            if (pArr[i] > maxLength) {
                maxLength = pArr[i];
                maxC = i;
            }
        }

        int length = maxLength - 1;
        int startIndex = (maxC - length) / 2;
        return s.substring(startIndex, startIndex + length);
    }

    private char[] getManacher(String s) {
        String manacher = "#";
        for (int i = 0; i < s.length(); i++) {
            manacher += s.charAt(i);
            manacher += "#";
        }
        return manacher.toCharArray();
    }
}
