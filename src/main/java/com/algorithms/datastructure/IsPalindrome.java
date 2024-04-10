package com.algorithms.datastructure;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.replace(" ", "");
        s = s.replaceAll("\\p{Punct}", "");
        s = s.toLowerCase();

        int lengthIndex = s.length() -1;
        for(int x = 0; x< s.length()/2; x++){
            if(s.charAt(x) != s.charAt(lengthIndex -x)){
                return false;
            }
        }
        return true;
    }
}
