package org.sreek.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassWithMain {

    private static final Logger logger = LogManager.getLogger(ClassWithMain.class);

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();

        logger.info("First file - text.txt - ");
        fileIO.writeToFile("text.txt");

        logger.info("text.txt");

        logger.info("Second file - text1.txt - ");
        fileIO.writeToFile("text1.txt");

        fileIO.readFromFile("text1.txt");

    }

}
