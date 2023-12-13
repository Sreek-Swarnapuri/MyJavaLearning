package org.sreek.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    public static void main(String[] args) {
        File file = new File("test.txt");
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("First Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Third Line");

        } catch (IOException e) {
            System.out.println("IOException occurred - " + e.getMessage());
            e.printStackTrace();
        }
    }



}
