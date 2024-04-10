package com.algorithms.datastructure;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] findTwoSum(int[] nums , int target){
        Map<Integer, Integer> complMap = new HashMap<Integer, Integer>();
        for(int x = 0; x< nums.length; x++) {
            //calcular o complementar
            int complement = target - nums[x];
            if (complMap.containsKey(complement)) {
                return new int[]{x, complMap.get(complement)};
            }
            //verificar se o complementar estã na list
            // se estiver retor um novo array com index de cada um
            // se nao estiver adiciona no map
            complMap.put(nums[x], x);
        }
        return new int[]{};
    }

}
