import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.util.Scanner;

class ReverseClient {

    public static void main(String args[]) {

        try {

            ORB orb =
                    ORB.init(args, null);

            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references(
                            "NameService"
                    );

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(
                            objRef
                    );

            Reverse reverseImpl =
                    ReverseHelper.narrow(
                            ncRef.resolve_str("Reverse")
                    );

            Scanner sc =
                    new Scanner(System.in);

            System.out.print(
                    "Enter String: "
            );

            String str =
                    sc.nextLine();

            String result =
                    reverseImpl.reverse_string(str);

            System.out.println(
                    "Reversed String: "
                            + result
            );

        } catch (Exception e) {

            System.out.println(
                    "ERROR: " + e
            );

            e.printStackTrace();
        }
    }
}
