package com.workshop.calculator;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorMinusTest {

    Calculator calculator = new Calculator();

    @Test public void
    บวกเลขด้วย_4_กับ_3_ต้องได้ค่า_1 (){
        //Act
        int actualResult = calculator.minus(4, 3);
        //Assert
        assertEquals("ผิดวะ",1, actualResult);
    }

    @Test public void
    บวกเลขด้วย_2_กับ_1_ต้องได้ค่า_1 (){
        //Act
        int actualResult = calculator.minus(2, 1);
        //Assert
        assertEquals("ผิดวะ",1, actualResult);
    }

}
