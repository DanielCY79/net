package com.daniel.other;

/**
 * 0 1 2 3 ... 9 对应 26 个英文字母 问有几种方案
 * <p>
 * 111 AAA KA 有两种
 *
 * @author Daniel Xia
 * @since 2019-07-03 19:55
 */
public class Other2 {

    public int getC(char[] cArr) {
        if(cArr == null || cArr.length == 0){
            return 0;
        }

        return process(cArr, 0);
    }

    public int process(char[] cArr, int index){
        if(index == cArr.length){
            return 1;
        }
        if(cArr[index] == '0'){
            return 0;
        }

        int res = 0;
        if(cArr[index] == '1'){
            res += process(cArr, index + 1);
            if(index + 1 < cArr.length){
                res += process(cArr, index + 2);
            }
            return res;
        }

        if(cArr[index] == '2'){
            res += process(cArr, index + 1);
            if(index + 1 < cArr.length && cArr[index + 1] >= 0 && cArr[index + 1] <= '6'){
                res += process(cArr, index + 2);
            }
            return res;
        }

        return process(cArr, index + 1);
    }

    public static void main(String[] args) {
        char[] cArr = {'1', '2', '6'};

        Other2 other2 = new Other2();
        System.out.println(other2.getC(cArr));
    }
}
