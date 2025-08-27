import java.util.Scanner;

// Problem 4: Selection/Conditional - Passed or Failed, considered 75 as passing grade.
public class prob4 {
    public static void main(String[] args) {
        int grade =0;

        Scanner input = new Scanner(System.in);
        System.out.print("(grade) Enter grade: ");
        grade = input.nextInt();
        if (grade >= 75) {
            System.out.print("Passed");
        } else {
            System.out.print("Failed");
        }
    }
}
