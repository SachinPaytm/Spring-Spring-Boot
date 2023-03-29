package com.udemy.mockito.mockBasic.business;

public class Business {

    private DataService dataService;

    public Business(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findGreatest() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for(int number:data) {
            if(number > greatestValue)
                greatestValue = number;
        }
        return greatestValue;
    }

}

interface DataService {
    int[] retrieveAllData();


}