package com.workshop.calculator;


import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycleTest {

    @BeforeClass
    public static void startOnce(){
        System.out.println("startOnce");
    }

    @AfterClass
    public static void afterOnce(){
        System.out.println("afterOnce");
    }

    @Before
    public void start(){
        System.out.println("start");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @Test public void t1(){
        System.out.println("t1");
    }

    @Test public void t2(){
        System.out.println("t2");
    }

}
