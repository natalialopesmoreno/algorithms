package com.algorithms.datastructure.problems;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> verified = new HashSet<Integer>();
        return isNumberHappy(n,verified);

    }

    public boolean isNumberHappy(int n, HashSet<Integer> set){
        if(n ==1){
            return true;
        }
        int result = 0;
        while(n>0){
            int rem = n%10;
            result += rem*rem;
            n/=10;
        }

        if(!set.add(result)){
            return false;
        }

        return isNumberHappy(result,set);


    }
}
