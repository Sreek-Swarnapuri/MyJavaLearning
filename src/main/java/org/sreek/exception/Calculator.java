package org.sreek.exception;

public class Calculator {

    public static int addTwoNumbers(int a, int b) {

        if(a < 0 || b < 0)
            throw new ArithmeticException("Negative numbers are not allowed");
        return a + b;
    }

    public static double divide(int a, int b) {

        if(b==0)
            throw new ArithmeticException("Cannot divide by zero");

        return (double) a / b;
    }

}
