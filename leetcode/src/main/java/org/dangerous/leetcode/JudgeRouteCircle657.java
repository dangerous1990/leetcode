package org.dangerous.leetcode;

/**
 * Created by limeng on 17-11-28.
 */
public class JudgeRouteCircle657 {
    public boolean judgeCircle(String moves) {
        int lcount = 0;
        int rcount = 0;
        int ucount = 0;
        int dcount = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'L':
                    lcount++;
                    break;
                case 'R':
                    rcount++;
                    break;
                case 'U':
                    ucount++;
                    break;
                case 'D':
                    dcount++;
                    break;
                default:
                    break;
            }
        }
        return (lcount == rcount) && (ucount == dcount);
    }

}
