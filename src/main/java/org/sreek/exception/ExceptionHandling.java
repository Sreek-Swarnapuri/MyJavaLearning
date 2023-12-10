package org.sreek.exception;

public class ExceptionHandling {

    public static void main(String[] args) {

        // without a try catch block, the application code will not continue further and "Process will exit with code 1"
        // General try catch block to show basic exception functionality
        // All Exception classes are subclasses of Throwable which has two methods - getMessage() & printStackTrace() that are inherited by all.
        try {
            System.out.println("sum of 13422 and 22344 is " + Calculator.addTwoNumbers(13422,22344));
            System.out.println("sum of -22325 and 21233 is " + Calculator.addTwoNumbers(-22325,21233));
            // Code will not reach the statement below as the statement above throws an exception since negative numbers are not allowed in this addition
            System.out.println("sum of 396574 and 15645 is " + Calculator.addTwoNumbers(396574,15645));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception - " + e.getMessage());
            e.printStackTrace();
        }

        // Finally block can be used to execute any code that needs be always executed
        try {
            System.out.println("Divide 10 by 2 - " + Calculator.divide(10,2));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception - " + e.getMessage());
        } finally {
            System.out.println("In finally block without any exception");
        }

        try {
            System.out.println("Divide 10 by 0 - " + Calculator.divide(10,0));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception - " + e.getMessage());
        } finally {
            System.out.println("In finally block with an exception");
        }


    }

}
