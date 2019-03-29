package org.dangerous.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(int i=0;i< emails.length;i++){
            StringBuilder sb = new StringBuilder();
            String email = emails[i];
            for(int j=0;j < email.length();j++){
                if (email.charAt(j) == '.' ){
                    continue;
                }
                if (email.charAt(j) == '+') {
                    sb.append(email.substring(email.indexOf("@")));
                    break;
                }
                if (email.charAt(j) == '@') {
                    sb.append(email.substring(j));
                    break;
                }
                sb.append(email.charAt(j));
            }
            set.add(sb.toString());
        }
        return set.size();   
    }

}