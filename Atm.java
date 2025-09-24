import java.util.Scanner;
public class Atm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // switch
        // ATM Transaction Simulation
        // [B]alance Inquiry
        // [W]ithdraw
        // [D]eposit
        // [C]hange Password
        // [E]xit

        System.out.println("**************************");
        System.out.println("     [B]alance Inquiry    ");
        System.out.println("     [W]ithdraw           ");
        System.out.println("     [D]eposit            ");
        System.out.println("     [C]hange Password    ");
        System.out.println("     [E]xit               ");
        System.out.println("**************************");
        System.out.print("Enter your choice: ");
        String choice = scan.next();
    }
}
