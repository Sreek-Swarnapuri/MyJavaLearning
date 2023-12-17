package org.sreek.networking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final Logger logger = LogManager.getLogger(Server.class);

    public static void main(String[] args) {
        try (// Create a server socket on port 8080
             ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             // Setup streams for reading from and writing to the client
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream())) {

            logger.info("Server is waiting for a client........");

            logger.info("Client connected: " + clientSocket.getInetAddress());

            // Read from the client
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                logger.info("Client: " + inputLine);
                // Echo back to the client
                out.println("Server received: " + inputLine);
            }

        } catch (IOException e) {
            logger.error("Error occurred in Server Socket - ", e);
        }
    }
}
