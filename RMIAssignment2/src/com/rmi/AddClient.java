package com.rmi;

import java.rmi.*;

public class AddClient {

    public static void main(String[] args) {

        try {

            AddServerIntf obj =
                    (AddServerIntf)
                    Naming.lookup(
                            "rmi://localhost/AddServer"
                    );

            double result =
                    obj.add(10, 5);

            System.out.println(
                    "Result = " + result
            );

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e
            );
        }
    }
}