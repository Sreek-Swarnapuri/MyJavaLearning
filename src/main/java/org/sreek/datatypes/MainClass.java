package org.sreek.datatypes;

public class MainClass {

    public static void main(String[] args) {

        // NUMERIC data types
        // ------------------

        // 8-bit signed integer - byte : -128 to 127
        byte byt = -128;
        System.out.println(byt);

        // 16-bit signed integer - short : -32,768 to 32,767
        short shrt = 32767;
        System.out.println(shrt);

        // 32-bit signed integer int : -2^31 to 2^31-1
        int a = (int) Math.pow(2, 30);
        System.out.println(a);

        // 64-bit signed integer - long : -2^63 to 2^63-1
        // l or L is appended at the end of the numberical literal to explicitly denote that value is of type long.
        // L is used mostly as l can be confused with 1 in some fonts.
        long l1 = 2389749827947328l;
        System.out.println(l1);
        long l2 = 983475749567348568L;
        System.out.println(l2);

        // 32-bit floating-point number - float
        // floating point integer that store floating-point number or decimal numbers
        // f or F is suffixed to indicate floating point numbers. F is conventionally used to not confuse with 1 in some fonts
        // It consists of 1 sign bit, 8 exponent bits, and 23 fraction bits (including an implicit leading bit).
        float pi = (float) 22 / 7;
        System.out.println("Float precision - Pi is " + pi);

        // 64-bit floating-point number - double
        // We don't have to suffix a d or D for double literal values as decimal numbers in Java are treated as 'double' by default.
        // It consists of 1 sign bit, 11 exponent bits, and 52 fraction bits (including an implicit leading bit).
        double dub = (double) 22 / 7;
        System.out.println("double precision is " + dub);

        // NON-NUMBERIC data types
        // -----------------------

        // 16-bit unicode character - char: 0 to 65,535
        char ch= 'a';
        System.out.println("character is " + ch);

        // Represents one bit of information, can hold only two values: true or false
        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println("this is " + bool1);
        System.out.println("this is " + bool2);

        // Non-primitive data types - Wrapper classes
        // These are classes that encapsulate primitive data types, allowing them to be used as objects.
        // Part of java.lang package
        // primary purpose to convert primitive to objects and offer utility methods to perform operations on these values.
        // These values are inititalized directly by using the corresponding primitive values or literals.

        Byte b = 1;
        System.out.println(b);

        Short s =  234;
        System.out.println(s);

        Integer i = 100;
        System.out.println(i);

        Long l = 34434L;
        System.out.println(l);

        Float f = 123.23f;
        System.out.println(f);

        Double d = 19.23;
        System.out.println(d);

        Character c = 'C';
        System.out.println(c);

        Boolean bool = true;
        System.out.println(bool);


    }

}
