package com.algorithms.datastructure.problems;

import java.util.*;

public class MinimunHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> returnList = new ArrayList<>();
        if(n == 1){
            returnList.add(0);
            return returnList;
        }else if(n == 2){
            returnList.add(edges[0][0]);
            returnList.add(edges[0][1]);
            return returnList;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int x = 0; x< edges.length; x++){
            int node1 = edges[x][0];
            int node2 = edges[x][1];

            map.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
            map.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);

        }

        Deque<Integer> leaves = new ArrayDeque<>();
        //populating the first leaves
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                leaves.offer(entry.getKey());
            }
        }

        //removing all the leaves till remains just the roots
        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;

            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                List<Integer> neighbors = map.get(leaf);

                for (int neighbor : neighbors) {
                    map.get(neighbor).remove(map.get(neighbor).indexOf(leaf));
                    if (map.get(neighbor).size() == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        returnList.addAll(leaves);

        return returnList;
    }
}
