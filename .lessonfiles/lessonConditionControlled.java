import java.util.Scanner;

public class lessonConditionControlled {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        int n1;

        System.out.print("Enter a #: ");
        n1 = scan.nextInt();

        while (n1 != 3) {
            sum = sum + n1;
            System.out.print("Enter a #: ");
            n1 = scan.nextInt();
        }

        System.out.print("Sum: " + sum);
        scan.close();
    }
}