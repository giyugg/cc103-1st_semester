import java.util.Scanner;

// Problem 5: Selection/Conditional - Bonus considerations (if and else)
public class prob5 {
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
        if (s >= 10000) {
            b = (s * .25);
            System.out.print("(b) Bonus (25% of Salary): " + b);
        }
        else {
            b = (s / 2);
            System.out.print("(b) Bonus (50% of Salary): " + b);
        }
    }
}