package com.algorithms.datastructure;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int x = 0; x < nums.length; x ++){
            if(nums[x] != val){
                nums[count] = nums[x];
                count ++;

                continue;
            }
        }
        return count;
    }
}
