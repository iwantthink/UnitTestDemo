package com.hmt.analytics.unittestdemo;

/**
 * Created by renbo on 2017/6/8.
 */

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public float divide(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }
}
