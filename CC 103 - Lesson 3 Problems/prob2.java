import java.util.Scanner;

// Problem 2: Average Computation
public class prob2 {
    public static void main(String[] args) {
        int s=0;
        int num1=0;
        int num2=0;

        Scanner input = new Scanner(System.in);
        System.out.print("(Num1) Enter first number: ");
        num1 = input.nextInt();
        System.out.print("(Num2) Enter second number: ");
        num2 = input.nextInt();
        s = (num1 + num2);
        int ave = (s / 2);
        System.out.println("(ave)Average: " + ave);
    }
}