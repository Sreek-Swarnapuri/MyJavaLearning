package org.sreek.io;

public class ClassWithMain {

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();

        System.out.println("First file - text.txt - ");
        fileIO.writeToFile("text.txt");

        fileIO.readFromFile("text.txt");

        System.out.println("Second file - text1.txt - ");
        fileIO.writeToFile("text1.txt");

        fileIO.readFromFile("text1.txt");

    }

}
