package com.algorithms.datastructure.problems;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_amount = 0;
        int amount = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_amount += gas[i] - cost[i];
            amount += gas[i] - cost[i];
            if(amount < 0){
                amount = 0;
                start = i + 1;
            }
        }
        return (total_amount < 0) ? -1 : start;
    }
}
