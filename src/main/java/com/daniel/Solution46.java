package com.daniel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Daniel Xia
 * @since 2019-07-01 19:55
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return resList;
        }

        List<Integer> repos = new ArrayList<>();
        for (int num : nums) {
            repos.add(num);
        }

        process(resList, repos, new ArrayList<>());
        return resList;
    }

    private void process(List<List<Integer>> resList, List<Integer> repos, List<Integer> answers) {
        if (repos.isEmpty()) {
            resList.add(answers);
            return;
        }

        Set<Integer> pickedSet = new HashSet<>();
        for (int i = 0; i < repos.size(); i++) {
            if (!pickedSet.contains(repos.get(i))) {
                pickedSet.add(repos.get(i));
                List<Integer> nextAnswers = new ArrayList<>(answers);
                nextAnswers.add(repos.get(i));

                List<Integer> nextRepos = new ArrayList<>(repos);
                nextRepos.remove(i);

                process(resList, nextRepos, nextAnswers);
            }
        }
    }

}
