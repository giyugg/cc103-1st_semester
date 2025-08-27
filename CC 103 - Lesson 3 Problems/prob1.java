import java.util.Scanner;

// Problem 1: Sum Computation
public class prob1 {
    public static void main(String[] args) {
        int s=0;
        int num1=0;
        int num2=0;

        Scanner input = new Scanner(System.in);
        System.out.print("(num1) Enter first number: ");
        num1 = input.nextInt();
        System.out.print("(num2) Enter second number: ");
        num2 = input.nextInt();
        s = num1 + num2;
        System.out.println("(s) The sum is: " + s);
    }
}