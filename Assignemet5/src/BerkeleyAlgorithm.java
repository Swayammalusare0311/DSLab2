import java.util.*;

public class BerkeleyAlgorithm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[] time = new int[n];
        int sum = 0;

        // Input time of each node
        for (int i = 0; i < n; i++) {
            System.out.print("Enter time for node " + i + ": ");
            time[i] = sc.nextInt();
            sum += time[i];
        }

        // Calculate average time
        int avg = sum / n;
        
        System.out.println("\n--- Step 1: Find the Average ---");
        // ADDED CALCULATION: Show how the average is found
        System.out.println("Calculation: Sum of all times (" + sum + ") / Number of nodes (" + n + ") = " + avg);
        System.out.println("Average time = " + avg);

        // Calculate adjustment
        System.out.println("\n--- Step 2: Calculate Adjustments ---");
        
        // Let's store the differences in an array so we can clearly show the final math later
        int[] diff = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            diff[i] = avg - time[i];
          
            System.out.println("Node " + i + " adjustment: Average (" + avg + ") - Current Time (" + time[i] + ") = " + diff[i]);
        }
        System.out.println("\n--- Step 3: Apply Synchronized Times ---");
        
        for (int i = 0; i < n; i++) {
            
            int newTime = time[i] + diff[i];
            System.out.println("Node " + i + " new time: Old Time (" + time[i] + ") + Adjustment (" + diff[i] + ") = " + newTime);
            
            
            time[i] = newTime; 
        }

        sc.close();
    }
}