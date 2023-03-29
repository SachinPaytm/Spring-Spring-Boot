package com.udemy.mockito.mockBasic.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessStubTest {


    @Test
    void findGreatestBasic(){
        DataService dataService = new DataServiceStub1();
        Business business = new Business(dataService);
        assertEquals(6,business.findGreatest());

    }

    @Test
    void findGreatestOne(){
        DataService dataService = new DataServiceStub2();
        Business business = new Business(dataService);
        assertEquals(6,business.findGreatest());

    }
}
class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5, -5, 6};
    }

}
class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{6};
    }

}
