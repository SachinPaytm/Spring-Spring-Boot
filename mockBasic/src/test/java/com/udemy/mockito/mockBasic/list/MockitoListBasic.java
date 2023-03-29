package com.udemy.mockito.mockBasic.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoListBasic {
    @Test
    void basicsTest(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(3, listMock.size());
    }
    @Test
    void parametersTest(){
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Mockito");
        assertEquals("Mockito", listMock.get(1));
        assertEquals("Mockito", listMock.get(0));
        assertEquals("Mockito", listMock.get(1000));
    }
}
