package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019/7/6 10:36
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
        if (haystack != null && needle != null && needle.length() == 0) {
            return 0;
        }
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int[] next = getNextArray(str2);

        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] != -1) {
                i2 = next[i2];
            } else {
                i1++;
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < str2.length) {
            if (str2[index - 1] == str2[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }
}