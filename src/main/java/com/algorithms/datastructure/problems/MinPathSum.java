package com.algorithms.datastructure.problems;

import java.util.Arrays;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 201));

        return recursiveSum(grid, 0, 0,dp);

    }

    public int recursiveSum(int[][] grid , int row, int col, int[][] dp){
        if(dp[row][col] != 201){
            return dp[row][col];
        }
        //check if it is the end
        if(row == grid.length -1 && col == grid[0].length -1){
            dp[row][col] = grid[row][col];
            return dp[row][col] ;
        }
        //check if it is row border
        else if(row == grid.length -1){
            dp[row][col] = grid[row][col] + recursiveSum(grid, row, col +1, dp);
            return dp[row][col];
        }//check if it is col border
        else if(col == grid[0].length -1){
            dp[row][col] = grid[row][col] + recursiveSum(grid, row+1, col,dp);
            return dp[row][col];
            //else calculate each way has the min value;
        }else{
            dp[row][col] = grid[row][col] + Math.min(recursiveSum(grid, row, col +1,dp),recursiveSum(grid, row+1, col,dp));

        }
        return dp[row][col];
    }
}
