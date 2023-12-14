package org.sreek.io;

import java.io.*;

public class FileIO {

    public void writeToFile(String filePath) {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("First Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Third Line");

        } catch (IOException e) {
            System.out.println("IOException occurred while writing to file - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void readFromFile(String filePath) {
        File file = new File(filePath);

        StringBuilder stringBuffer = new StringBuilder();

        try(FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append(System.lineSeparator());
            }

            System.out.println("Contents of the file are: ");
            System.out.println(stringBuffer);

        } catch (IOException e) {
            System.out.println("IOException occurred while reading from file - " + e.getMessage());
            e.printStackTrace();
        }
    }

}
