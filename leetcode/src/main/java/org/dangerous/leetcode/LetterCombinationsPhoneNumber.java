package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsPhoneNumber {
    private Map<Character, List<String>> m = new HashMap<>();

    {
        m.put('2', Arrays.asList("a", "b", "c"));
        m.put('3', Arrays.asList("d", "e", "f"));
        m.put('4', Arrays.asList("g", "h", "i"));
        m.put('5', Arrays.asList("j", "k", "l"));
        m.put('6', Arrays.asList("m", "n", "o"));
        m.put('7', Arrays.asList("q", "p", "r", "s"));
        m.put('8', Arrays.asList("t", "u", "v"));
        m.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }

        List<List<String>> data = new ArrayList<>(digits.length());
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '1') {
                data.add(m.get(digits.charAt(i)));
            }
        }
        List<String> result = new ArrayList<>();
        backtrace(data, 0, new StringBuilder(), result);
        return result;
    }


    private void backtrace(List<List<String>> data, int n, StringBuilder sb, List<String> result) {
        if (sb.length() == data.size()) {
            result.add(sb.toString());
        } else {
            for (int j = 0; j < data.get(n).size(); j++) {
                sb.append(data.get(n).get(j));
                backtrace(data, n + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
