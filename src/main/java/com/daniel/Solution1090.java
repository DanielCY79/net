package com.daniel;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-16 11:07
 */
public class Solution1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        if (values == null || labels == null || labels.length == 0 || values.length != labels.length || num_wanted == 0 || use_limit == 0) {
            return 0;
        }
        int sum = 0;
        int countSum = 0;

        PriorityQueue<Ele> elePriorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        int length = values.length;
        for (int i = 0; i < length; i++) {
            elePriorityQueue.add(new Ele(values[i], labels[i]));
        }

        HashMap<Integer, Integer> labelMap = new HashMap<>();
        while (!elePriorityQueue.isEmpty()) {
            if(countSum >= num_wanted){
                break;
            }
            Ele maxEle = elePriorityQueue.peek();

            if (labelMap.containsKey(maxEle.label)) {
                int countUse = labelMap.get(maxEle.label);
                if(countUse < use_limit){
                    labelMap.put(maxEle.label, ++countUse);
                    sum = sum + maxEle.value;
                    countSum++;
                }
            } else {
                labelMap.put(maxEle.label, 1);
                sum = sum + maxEle.value;
                countSum++;
            }

            elePriorityQueue.poll();

        }

        return sum;
    }

    public static void main(String[] args) {
        Solution1090 solution1090 = new Solution1090();
        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        int num_wanted = 3;
        int use_limit = 2;
        System.out.println(solution1090.largestValsFromLabels(values, labels, num_wanted, use_limit));
    }

    static class Ele {
        int value;
        int label;

        public Ele(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
