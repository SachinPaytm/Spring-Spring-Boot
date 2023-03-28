package com.udemy.junit;

public class MyMath {
    public int getSum(int[] numbers){
        int sum = 0;
        for(int num:numbers){
            sum+=num;
        }
        return sum;
    }
}
