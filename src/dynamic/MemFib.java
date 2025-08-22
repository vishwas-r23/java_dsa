package dynamic;

import java.util.Scanner;

public class MemFib {

    // Recursive method with memoization to find nth Fibonacci number
    public static int fibonacci(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Print Fibonacci series
        System.out.print("Enter how many Fibonacci numbers to print: ");
        int terms = sc.nextInt();

        // Initialize memo array with -1 indicating values not calculated yet
        int[] memo = new int[terms];
        for (int i = 0; i < terms; i++) {
            memo[i] = -1;
        }

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < terms; i++) {
            System.out.print(fibonacci(i, memo) + " ");
        }

        sc.close();
    }
}
