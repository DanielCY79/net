package com.daniel.other;

/**
 * bag problem with values
 *
 * @author Daniel Xia
 * @since 2019-07-03 21:12
 */
public class Other4 {

    public int backPackII(int m, int[] A, int[] V) {
        if(m == 0){
            return 0;
        }

        return process(A, V, 0, 0, 0, m);
    }

    public int process(int[] weights, int[] values, int alreadyWeight, int index, int alreadyValue, int bag){
        if(index == weights.length){
            return alreadyValue;
        }
        if(alreadyWeight + weights[index] > bag){
            return alreadyValue;
        }

        return Math.max(
                process(weights, values, alreadyWeight, index + 1, alreadyValue, bag),
                process(weights, values, alreadyWeight + weights[index], index + 1, alreadyValue + values[index], bag)
        );
    }

}
