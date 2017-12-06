package org.dangerous.leetcode;

/**
 * Created by limeng on 17-12-4.
 */
public class OneBitTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {

        int prev = bits[0];
        for (int i = 0; i < bits.length - 1; i += 2) {
            if (bits[i] == 0 && bits[i + 1] == 1){
                return false;
            }
        }

        return false;
    }
}
