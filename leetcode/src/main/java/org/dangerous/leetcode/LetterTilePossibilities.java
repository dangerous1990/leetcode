package org.dangerous.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        backtrace(0, tiles.toCharArray(), set, new StringBuilder());
        return set.size();

    }

    public void backtrace(int index, char[] tiles, Set<String> result, StringBuilder sb) {
        if (sb.length() != 0) {
            result.add(sb.toString());
        }
        if (index == tiles.length) {
            return;
        }
        for (int i = 0; i < tiles.length; i++) {
            char c = tiles[i];
            if (c == '0') {
                continue;
            }
            sb.append(c);
            tiles[i] = '0';
            backtrace(index + 1, tiles, result, sb);
            tiles[i] = c;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAB"));
    }
}
