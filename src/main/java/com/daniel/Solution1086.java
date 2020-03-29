package com.daniel;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * @author Daniel Xia
 * @since 2019-06-15 22:55
 */
public class Solution1086 {

    public int[][] highFive(int[][] items) {
        if(items == null){
            return null;
        }

        TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
        for(int[] scoreArr : items){
            int stu = scoreArr[0];
            int score = scoreArr[1];

            PriorityQueue<Integer> pq = treeMap.get(stu);
            if(pq == null || pq.isEmpty()){
                pq = new PriorityQueue<>();
            }
            if(pq.size() >= 5){
                int minQ = pq.peek();
                if(score > minQ){
                    pq.poll();
                    pq.add(score);
                }
            }else{
                pq.add(score);
            }

            treeMap.put(stu, pq);
        }

        int [][] res = new int[treeMap.size()][2];
        int count = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : treeMap.entrySet()){
            PriorityQueue<Integer> score = entry.getValue();
            int sumL = 0;
            for(Integer s : score){
                sumL+=s;
            }
            sumL = sumL / 5;

            res[count][0] = entry.getKey();
            res[count][1] = sumL;
            count ++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};

        Solution1086 solution1086 = new Solution1086();
        int [][] res = solution1086.highFive(test);
        System.out.println(res);
    }

}
