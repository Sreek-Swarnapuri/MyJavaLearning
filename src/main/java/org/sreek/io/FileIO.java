package org.sreek.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileIO {

    private static final Logger logger = LogManager.getLogger(FileIO.class);

    public void writeToFile(String filePath) {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("First Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Third Line");

        } catch (IOException e) {
            logger.error("IOException occurred while writing to file - ", e);
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

            logger.info("Contents of the file are: ");
            logger.info(stringBuffer);

        } catch (IOException e) {
            logger.error("IOException occurred while reading from file - ", e);
        }
    }

}
