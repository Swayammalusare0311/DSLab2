import java.util.*;

class Assignment6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print(
                "Enter number of processes: ");

        int n = sc.nextInt();

        // Initially token with process 0
        int token = 0;

        while (true) {

            // Display token holder
            System.out.println(
                    "\nToken is with Process "
                            + token);

            // Ask process for critical section
            System.out.print(
                    "Does Process "
                            + token +
                            " want to enter CS? (1/0): ");

            int choice = sc.nextInt();

            // Enter critical section
            if (choice == 1) {

                System.out.println(
                        "Process "
                                + token +
                                " is in Critical Section...");

                System.out.println(
                        "Process "
                                + token +
                                " exiting Critical Section...");
            }

            // Pass token to next process
            token = (token + 1) % n;

            // Continue program
            System.out.print(
                    "Continue? (1/0): ");

            int cont = sc.nextInt();

            if (cont == 0)
                break;
        }

        sc.close();
    }
}