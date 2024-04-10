package com.algorithms.datastructure;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()){
            return false;
        }
        if(t.contains(s)){
            return true;
        }
        int i =0;
        int j = 0;
        while(i< s.length() && j < t.length()){
            if(s.charAt(i)== t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
