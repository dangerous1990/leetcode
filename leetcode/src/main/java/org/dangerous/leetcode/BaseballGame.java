package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/baseball-game/description/
 * Created by limeng on 17-11-29.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> validScore = new ArrayList<>(ops.length);
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            if ("C".equals(ops[i])) {
                sum -= validScore.get(validScore.size() - 1);
                validScore.remove(validScore.size() - 1);
            } else if ("+".equals(ops[i])) {
                int score1 = validScore.get(validScore.size() - 2);
                int score2 = validScore.get(validScore.size() - 1);
                int score = score1 + score2;
                validScore.add(score);
                sum += score;
            } else if ("D".equals(ops[i])) {
                int score = validScore.get(validScore.size() - 1) * 2;
                validScore.add(score);
                sum += score;
            } else {
                int score = Integer.parseInt(ops[i]);
                sum += score;
                validScore.add(score);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballGame bbg = new BaseballGame();
        System.out.println(bbg.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
