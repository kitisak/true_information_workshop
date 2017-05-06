package com.workshop.calculator;

class Calculator {
    public int add(int param1, int param2){
        validate(param1, param2);
        return param1 + param2;
    }

    private void validate(int param1, int param2) {
        boolean ติดลบหรือเปล่า = param1 < 0;
        if(ติดลบหรือเปล่า){
            throw new InvalidNumberException();
        }
        if(param2 < 0){
            throw new InvalidNumberException();
        }
    }

    public int minus(int param1, int param2) {
        validate(param1, param2);
        return param1 - param2;
    }
}
