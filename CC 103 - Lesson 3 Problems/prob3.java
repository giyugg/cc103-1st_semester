import java.util.Scanner;

// Problem 3: Bonus Computation
public class prob3 {
    public static void main(String[] args) {
        int h=0;
        int r=0;
        double b=0;
        int s=0;

        Scanner input = new Scanner(System.in);
        System.out.print("(h) Enter hours worked: ");
        h = input.nextInt();
        System.out.print("(r) Enter hourly rate: ");
        r = input.nextInt();
        s = (h * r);
        System.out.println("(s) Total Salary: " + s);
        b = (s * .25);
        System.out.println("(b) Bonus (25% of Salary): " + b);
    }
}