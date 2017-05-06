package com.workshop.calculator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorAddTest {

    Calculator calculator = new Calculator();

    @Test(expected = InvalidNumberException.class)
    public void
    ถ้าเลขที่หนึ่งติดลบ_ต้องโยน_exception_ออกมา(){
        calculator.add(-1, 10);
    }

    @Test(expected = InvalidNumberException.class)
    public void
    ถ้าเลขที่สองติดลบ_ต้องโยน_exception_ออกมา(){
        calculator.add(10, -5);
    }

    @Test @Ignore public void
    บวกเลขด้วย_3_กับ_4_ต้องได้ค่า_7 (){
        //Act
        int actualResult = calculator.add(3, 4);
        //Assert
        assertEquals("ผิดวะ",7, actualResult);
    }

    @Test public void
    บวกเลขด้วย_1_กับ_2_ต้องได้ค่า_3 (){
        //Act
        int actualResult = calculator.add(1, 2);
        //Assert
        assertEquals("ผิดวะ",3, actualResult);
    }

}
