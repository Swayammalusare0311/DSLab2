import java.util.*;

public class Ring {

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

        // Input initiator index
        System.out.print(
                "Enter initiator process index (0 to n-1): ");

        int initiator = sc.nextInt();

        System.out.println(
                "\nElection message passing:\n");

        int max = -1;

        int i = initiator;

        do {

            // Ignore failed process
            if(process[i] != failed) {

                System.out.println(
                        "Process "
                                + process[i] +
                                " passes election message");

                // Find highest active process
                if(process[i] > max) {

                    max = process[i];
                }
            }

            // Move circularly
            i = (i + 1) % n;

        } while(i != initiator);

        System.out.println(
                "\nProcess "
                        + max +
                        " becomes new coordinator");

        sc.close();
    }
}