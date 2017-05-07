package com.workshop.calculator;

import org.junit.Test;

import static org.junit.Assert.*;


public class XXXServiceTest {
    @Test
    public void doProcess(){
        StubService1 stubService1 = new StubService1();
        XXXService xxxService = new XXXService();
        xxxService.setService1(stubService1);
        xxxService.doProcess();
        assertTrue(stubService1.callInsert);
    }
}

class StubService1 implements Service1{
    public boolean callInsert = false;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void insert() {
        callInsert = true;
    }
}