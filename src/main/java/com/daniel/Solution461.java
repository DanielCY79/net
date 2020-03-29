package com.daniel;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-29 22:46
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((xor & (1 << i)) > 0){
                count++;
            }
        }
        return count;
    }
}
