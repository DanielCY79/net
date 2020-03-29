package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019/7/2 10:28
 */
public class Solution70 {
    public int climbStairs(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 0 || n == 1){
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int process(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int[] dp = new int[n];
        dp[n - 1] = 1;
        dp[n - 2] = 2;
        for(int i = n - 3; i >= 0; i--){
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }
}
