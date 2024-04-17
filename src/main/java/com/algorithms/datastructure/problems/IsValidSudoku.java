package com.algorithms.datastructure.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> mapRow = new HashMap<Integer, Set<Character>>();
        Map<Integer, Set<Character>> mapCol = new HashMap<Integer, Set<Character>>();
        Map<Integer, Set<Character>> mapBox = new HashMap<Integer, Set<Character>>();

        for (int i = 0; i < 9; i++) {
            mapRow.put(i, new HashSet<Character>());
            mapCol.put(i, new HashSet<Character>());
            mapBox.put(i, new HashSet<Character>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!mapRow.get(i).add(num) || !mapCol.get(j).add(num) || !mapBox.get((i / 3) * 3 + j / 3).add(num)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
