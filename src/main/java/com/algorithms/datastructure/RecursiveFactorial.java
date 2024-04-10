package com.algorithms.datastructure;

public class RecursiveFactorial {
    // Factorial F4 = 4*3*2*1
    public static int factorial(int number){
        if(number <= 1){
            return number;
        }

        return number * factorial(number -1);
    }
}
