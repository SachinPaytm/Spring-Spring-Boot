package com.udemy.learnaop.dataservices;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
    public int[] retrieveData() {
        return new int[]{10,20,30,40,50};
    }
}
