package org.sreek.reflections;

import org.sreek.exception.Calculator;
import org.sreek.exception.ExceptionHandling;

public class ReflectionUsage {

    public static void main(String[] args) {

        Calculator calculator = (Calculator) extracted("org.sreek.exception.Calculator", true);
        System.out.println("add 1 and 2 - " + calculator.add(1,2));

        ExceptionHandling exceptionHandling = (ExceptionHandling) extracted("org.sreek.exception.ExceptionHandling", false);
        System.out.println("ExceptionHandling class - " + exceptionHandling);

    }

    //classForNameOrThreadLoader - true for using class forName, false for thread class loader
    private static Object extracted(String className, boolean classForNameOrThreadLoader) {
        try {
            Class<?> clazz = classForNameOrThreadLoader ? Class.forName(className) : Thread.currentThread().getContextClassLoader().loadClass(className);

            return clazz.newInstance();

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException - " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("InstantiationException - " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException - " + e.getMessage());
        }

        return null;
    }

}
