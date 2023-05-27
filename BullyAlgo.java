package Practical6;

import java.util.Scanner;

class BullyAlgo {
    static int noofprocess;
    static int priority[] = new int[100];
    static int S[] = new int[100];
    static int C;

    public static void main(String args[]) {
        System.out.println("Select the number of processes:");
        Scanner sc = new Scanner(System.in);
        noofprocess = sc.nextInt();

        int i;

        for (i = 0; i < noofprocess; i++) {
            System.out.println("Status for process " + (i + 1) + ":");
            S[i] = sc.nextInt();
            System.out.println("Priority of the current process " + (i + 1) + ":");
            priority[i] = sc.nextInt();
        }

        System.out.println("Which process should be elected for initiation?");
        int e = sc.nextInt();
        sc.close();

        electProcess(e);
        System.out.println("After electing process, the final coordinator is " + C);
    }

    static void electProcess(int e) {
        e = e - 1;
        C = e + 1;

        for (int i = 0; i < noofprocess; i++) {
            if (S[i] == 1 && priority[e] < priority[i]) {
                System.out.println("Election message is sent from " + (e + 1) + " to " + (i + 1));
                electProcess(i + 1);
            }
        }
    }
}
