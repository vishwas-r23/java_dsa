package dynamic;

import java.util.Scanner;

public class FibRec {

    // Recursive method to find the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Main method to print the Fibonacci series
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms to print: ");
        int terms = sc.nextInt();

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < terms; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        sc.close();
    }
}
