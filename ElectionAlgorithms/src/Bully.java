import java.util.*;

public class Bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print(
                "Enter number of processes: ");

        int n = sc.nextInt();

        int[] process = new int[n];

        // Input process IDs
        System.out.println(
                "Enter process IDs:");

        for(int i = 0; i < n; i++) {

            process[i] = sc.nextInt();
        }

        // Input failed coordinator
        System.out.print(
                "Enter failed coordinator process ID: ");

        int failed = sc.nextInt();

        // Input initiator process
        System.out.print(
                "Enter process that detects failure: ");

        int initiator = sc.nextInt();

        System.out.println(
                "\nElection process started...\n");

        int newCoordinator = -1;

        // Send election messages
        for(int i = 0; i < n; i++) {

            // Ignore failed process
            if(process[i] != failed &&
               process[i] > initiator) {

                System.out.println(
                        "Process "
                                + initiator +
                                " sends message to "
                                + process[i]);

                // Select highest active process
                if(process[i] > newCoordinator) {

                    newCoordinator = process[i];
                }
            }
        }

        // If no higher process exists
        if(newCoordinator == -1) {

            newCoordinator = initiator;
        }

        System.out.println(
                "\nProcess "
                        + newCoordinator +
                        " becomes the new coordinator");

        sc.close();
    }
}