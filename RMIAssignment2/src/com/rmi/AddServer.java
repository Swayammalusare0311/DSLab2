package com.rmi;

import java.rmi.*;

public class AddServer {

    public static void main(String[] args) {

        try {

            AddServerImpl obj =
                    new AddServerImpl();

            Naming.rebind(
                    "rmi://localhost/AddServer",
                    obj
            );

            System.out.println(
                    "Server Ready..."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e
            );
        }
    }
}
