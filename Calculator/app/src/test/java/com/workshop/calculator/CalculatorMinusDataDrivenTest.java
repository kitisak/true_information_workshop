package com.workshop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorMinusDataDrivenTest {

    Calculator calculator = new Calculator();

    private int param1;
    private int param2;
    private int expectedResult;

    public CalculatorMinusDataDrivenTest(int param1, int param2, int expectedResult) {
        this.param1 = param1;
        this.param2 = param2;
        this.expectedResult = expectedResult;
    }

    @Parameters(name = "minus({0}-{1}) = {2}")
    public static List<Object[]> xxx(){
        return Arrays.asList(new Object[][]{
                {2, 1, 1},
                {10, 5, 5}
        });
    }


    @Test public void
    บวกเลข (){
        //Act
        int actualResult = calculator.minus(param1, param2);
        //Assert
        assertEquals("ผิดวะ", expectedResult, actualResult);
    }


}
