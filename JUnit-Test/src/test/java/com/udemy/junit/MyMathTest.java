package com.udemy.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private MyMath myMath;

    @Test
    void getSumLenght3() {
        assertEquals(new MyMath().getSum(new int[]{1,2,3}), 6);
    }
    @Test
    void getSumLenght0() {
        assertEquals(new MyMath().getSum(new int[]{0}), 0);
    }
}