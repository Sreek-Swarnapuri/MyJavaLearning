package org.sreek.networking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final Logger logger = LogManager.getLogger(Client.class);

    public static void main(String[] args) {

        try (// Connect to the server running on localhost:8080
             Socket socket = new Socket("localhost", 8080);
             // Setup streams for reading from and writing to the server
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // Write to the server
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String userInputLine;

            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);

                // read from the server
                logger.info("Server: " + in.readLine());
            }

        } catch (IOException e) {
            logger.error("Error occurred in Server Socket - ", e);
        }

    }

}
