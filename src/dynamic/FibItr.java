package dynamic;

import java.util.Scanner;

public class FibItr {

    // Method to generate the nth Fibonacci number using iteration
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter how many Fibonacci numbers to print: ");
        int terms = sc.nextInt();

        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b);

        for (int i = 2; i < terms; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }

        sc.close();
    }
}
