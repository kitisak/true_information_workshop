package com.workshop.myrecipe.myrecipes.test;


import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.workshop.myrecipe.myrecipes.injection.TestRecipeApplication;

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
