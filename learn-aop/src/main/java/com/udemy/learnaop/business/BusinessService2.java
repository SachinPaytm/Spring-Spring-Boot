package com.udemy.learnaop.business;

import com.udemy.learnaop.dataservices.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    private DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }
    public int calculateMin() {
        int[] data = dataService2.retrieveData();
        return Arrays.stream(data).min().orElse(0);
    }

}
