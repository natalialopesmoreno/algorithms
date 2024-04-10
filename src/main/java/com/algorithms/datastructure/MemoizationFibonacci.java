package com.algorithms.datastructure;

import java.util.Map;

public class MemoizationFibonacci {

    public int fibonacci(int number, Map<Integer, Integer> map){
        map.put(0,1);
        map.put(1,1);
        if(!map.containsKey(number)){
            map.put(number, (fibonacci(number -1,map) + fibonacci(number -2,map)));
        }

        return map.get(number);
    }
}
