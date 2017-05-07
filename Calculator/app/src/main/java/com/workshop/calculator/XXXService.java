package com.workshop.calculator;


public class XXXService {

    private Service1 service1;

    public XXXService(Service1 service1) {
        this.service1 = service1;
    }

    public XXXService() {

    }

    public void doProcess() {
        service1.getName();
        service1.insert();
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }
}

interface Service1 {
    String getName();
    void insert();
}

