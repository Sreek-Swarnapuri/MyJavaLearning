package org.sreek.exception;

import java.io.*;

public class ExceptionHandling {

    public static void main(String[] args) {

        // Java 1.0: The initial version introduced basic exception handling using try, catch, and finally blocks.
        // without a try catch block, the application code will not continue further and "Process will exit with code 1"
        // General try catch block to show basic exception functionality
        // All Exception classes are subclasses of Throwable which has two methods - getMessage() & printStackTrace() that are inherited by all.
        try {
            System.out.println("sum of 13422 and 22344 is " + Calculator.addTwoNumbers(13422, 22344));
            System.out.println("sum of -22325 and 21233 is " + Calculator.addTwoNumbers(-22325, 21233));
            // Code will not reach the statement below as the statement above throws an exception since negative numbers are not allowed in this addition
            System.out.println("sum of 396574 and 15645 is " + Calculator.addTwoNumbers(396574, 15645));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception - " + e.getMessage());
            e.printStackTrace();
        }

        // Finally block can be used to execute any code that needs be always executed
        try {
            System.out.println("Divide 10 by 2 - " + Calculator.divide(10, 2));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception - " + e.getMessage());
        } finally {
            System.out.println("In finally block without any exception");
        }

        // Java 1.4: The introduction of chained exceptions (Throwable constructor that takes another Throwable as a parameter), enabling better exception wrapping and handling.
        try {
            System.out.println("Divide 10 by 0 - " + Calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Caught exception - " + e.getMessage());
            // Commenting below as it would break the code flow
            //throw new ArithmeticException("Cannot divide by Zero");
        } finally {
            System.out.println("In finally block with an exception");
        }

        // Java 5 (Java SE 5.0): This version brought significant enhancements with the introduction of the java.lang.Exception class and its subclasses, like RuntimeException.
        // Additionally, it introduced the try-with-resources statement, simplifying resource management by automatically closing resources like files, streams, etc., after they are no longer needed.
        // Try with resources
        System.out.println("Objects before serialization:");
        serializeObjects(new Object[]{new SerializationTest(), new SerializationTest(22, "Test22")});

        SerializationTest[] deserializationTests = deserializeObjects("serialized.obj", 2);
        System.out.println("Objects after deserialization:");
        for (SerializationTest st : deserializationTests) {
            System.out.println(st);
        }

        // Java 7: The addition of the multi-catch feature allowed catching multiple exceptions in a single catch block, reducing redundancy in code.
        sumOfArray(new int[]{1,2,3,4,5,6,293});
        sumOfArray(null);

    }

    private static void serializeObjects(Object[] obs) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("serialized.obj");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            for (Object object : obs) {
                System.out.println(object);
                objectOutputStream.writeObject(object);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException in serializeObject - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException in serializeObject - " + e.getMessage());
        }

    }

    private static SerializationTest[] deserializeObjects(String fileName, int numberOfObjects) {

        SerializationTest[] deserializedObjects = new SerializationTest[numberOfObjects];

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            for (int i = 0; i < numberOfObjects; i++) {
                deserializedObjects[i] = (SerializationTest) objectInputStream.readObject();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException in serializeObject - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException in serializeObject - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Caught ClassNotFoundException in serializeObject - " + e.getMessage());
        }

        return deserializedObjects;
    }

    private static int sumOfArray(int[] arr) {
        try{
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            //System.out.println(arr[arr.length]);
            return sum;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Exception Caught - " + e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

}

class SerializationTest implements Serializable {

    private static final long serialVersionUID = -8054334744134588496L;

    private int test = 10;
    private String testString = "testValue";

    public SerializationTest() {
    }

    public SerializationTest(int test, String testString) {
        this.test = test;
        this.testString = testString;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    @Override
    public String toString() {
        return "SerializationTest{" + "test=" + test + ", testString='" + testString + '\'' + '}';
    }
}