package com.udemy.junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAsserts {
    List<String> list = Arrays.asList("a","b","c");

    @Test
    void test(){
        boolean t = list.contains("a");
        boolean t2 = list.contains("d");
        assertTrue(t);
        assertFalse(t2);
        assertEquals(3,list.size());
        assertArrayEquals(new int[]{1,2} , new int[]{2,1});
    }
}
