package com.server;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("127.0.0.1", 5555);
        System.out.println("Connected to Server");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader receive = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        String clientMsg = "", serverMsg = "";

        while (true) {
            System.out.print("Client: ");
            clientMsg = br.readLine();
            pw.println(clientMsg);

            if (clientMsg.equals("bye")) break;

            serverMsg = receive.readLine();
            System.out.println("Server: " + serverMsg);

            if (serverMsg.equals("bye")) break;
        }

        s.close();
        System.out.println("Connection Closed");
    }
}