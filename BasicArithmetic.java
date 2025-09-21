import java.util.Scanner;
public class BasicArithmetic {
    public static void main(String[] args) {
        // Hey there, start typing your Java code here...
        Scanner input = new Scanner(System.in);
        int a, b, c, d;
        
        System.out.print("Enter a: ");
        a = input.nextInt();
        System.out.print("Enter b: ");
        b = input.nextInt();
        System.out.print("Enter c: ");
        c = input.nextInt();
        System.out.print("Enter d: ");
        d = input.nextInt();
        input.close(); //closing the scanner object for memory leak prevention
        
        int sum = (a + b) * (c + d);
        
    System.out.println("(" + a + " + " + b + ") * (" + c + " + " + d + ") = " + sum);
    
    }
}
