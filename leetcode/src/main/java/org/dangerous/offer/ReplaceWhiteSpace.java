package org.dangerous.offer;

/**
 * Created by limeng on 18-7-4.
 */
public class ReplaceWhiteSpace {

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char whiteSpace = ' ';
        int whiteSpaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (whiteSpace == str.charAt(i)) {
                whiteSpaceCount++;
            }
        }
        char[] result = new char[str.length() + 2 * whiteSpaceCount];
        int j = result.length - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == whiteSpace) {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            } else {
                result[j--] = str.charAt(i);
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ReplaceWhiteSpace rws = new ReplaceWhiteSpace();
        System.out.println(rws.replaceSpace(new StringBuffer(" 1 2 ")));
    }
}
