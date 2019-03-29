package org.dangerous.leetcode;


public class ToLowerCase709 {
    public String toLowerCase(String str) {
        char[] result = new char[str.toCharArray().length];
        for (int i =0;i<str.length();i++){
            char x =str.charAt(i);
            if (x >= 'A' && x <= 'Z'){
                result[i] = (char)((int)x + 32);
            }else {
                result[i] = x ;
            }
        }
        return new String(result);
    }
}