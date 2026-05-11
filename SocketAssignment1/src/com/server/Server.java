package com.server;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server Started, Waiting for Client...");

        Socket s = ss.accept();
        System.out.println("Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader receive = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        String clientMsg = "", serverMsg = "";

        while (true) {
            clientMsg = receive.readLine();
            System.out.println("Client: " + clientMsg);

            if (clientMsg.equals("bye")) break;

            System.out.print("Server: ");
            serverMsg = br.readLine();
            pw.println(serverMsg);

            if (serverMsg.equals("bye")) break;
        }

        s.close();
        ss.close();
        System.out.println("Connection Closed");
    }
}