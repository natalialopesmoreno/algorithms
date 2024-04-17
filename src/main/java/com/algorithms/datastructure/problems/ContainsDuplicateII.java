package com.algorithms.datastructure.problems;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int x = 0; x< nums.length; x++){
            if(map.containsKey(nums[x])){
                if(Math.abs(map.get(nums[x]) - x) <= k){
                    return true;
                }
            }
            map.put(nums[x], x);
        }
        return false;
    }
}
