package com.udemy.mockito.mockBasic.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @Mock
    private DataService dataMockService;

    @InjectMocks
    private Business business;

    @Test
    void findGreatestOne(){
        when(dataMockService.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(3,business.findGreatest());
    }
    @Test
    void findGreatestEmpty(){
        when(dataMockService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE,business.findGreatest());
    }
    @Test
    void findGreatestGenral(){
        when(dataMockService.retrieveAllData()).thenReturn(new int[]{1,2,3,4,5});
        assertEquals(5,business.findGreatest());
    }
}
