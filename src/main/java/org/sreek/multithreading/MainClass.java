package org.sreek.multithreading;

public class MainClass {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            ClassUsingThread classUsingThread = new ClassUsingThread();
            classUsingThread.setThreadNum(i);

            Thread t = new Thread(classUsingThread);
            t.start();
        }
    }

}
