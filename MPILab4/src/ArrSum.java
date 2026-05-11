import mpi.*;

public class ArrSum {

    public static void main(String[] args)
            throws Exception {

        // Initialize MPI
        MPI.Init(args);

        // Process ID
        int rank = MPI.COMM_WORLD.Rank();

        // Total number of processes
        int size = MPI.COMM_WORLD.Size();

        // Elements handled by each process
        int unitSize = 4;

        // Root process
        int root = 0;

        // Main array (allocate for all processes)
        int[] sendBuffer =
                new int[unitSize * size];

        // Each process receives part of array
        int[] receiveBuffer =
                new int[unitSize];

        // Stores local sums from all processes
        int[] gatherBuffer =
                new int[size];

        // Root process initializes array
        if(rank == root) {

            System.out.println("Original Array:");

            for(int i = 0;
                i < sendBuffer.length;
                i++) {

                sendBuffer[i] = i + 1;

                System.out.print(
                        sendBuffer[i] + " ");
            }

            System.out.println();
        }

        // Distribute array among processes
        MPI.COMM_WORLD.Scatter(
                sendBuffer,
                0,
                unitSize,
                MPI.INT,

                receiveBuffer,
                0,
                unitSize,
                MPI.INT,

                root
        );

        // Calculate local sum
        int localSum = 0;

        for(int i = 0;
            i < unitSize;
            i++) {

            localSum += receiveBuffer[i];
        }

        // Display local sum
        System.out.println(
                "Process "
                        + rank +
                        " local sum = "
                        + localSum);

        // Store local sum into array
        int[] localBuffer =
                new int[]{localSum};

        // Gather local sums at root
        MPI.COMM_WORLD.Gather(
                localBuffer,
                0,
                1,
                MPI.INT,

                gatherBuffer,
                0,
                1,
                MPI.INT,

                root
        );

        // Root process calculates final sum
        if(rank == root) {

            int finalSum = 0;

            for(int i = 0;
                i < size;
                i++) {

                finalSum += gatherBuffer[i];
            }

            System.out.println(
                    "Final Sum = "
                            + finalSum);
        }

        // Finalize MPI
        MPI.Finalize();
    }
}