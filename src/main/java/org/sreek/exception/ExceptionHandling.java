package org.sreek.exception;

public class ExceptionHandling {

    public static void main(String[] args) {

        // General try catch block to show basic exception functionality
        try {
            System.out.println("sum of 13422 and 22344 is " + Calculator.addTwoNumbers(13422,22344));
            System.out.println("sum of -22325 and 21233 is " + Calculator.addTwoNumbers(-22325,21233));
            // Code will not reach the statement below as the statement above throws an exception since negative numbers are not allowed in this addition
            System.out.println("sum of 396574 and 15645 is " + Calculator.addTwoNumbers(396574,15645));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception");
            e.printStackTrace();
        }

    }

}
