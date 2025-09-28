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

        switch (choice) {
            case "B":
            case "b": { // Balance Inquiry
                System.out.println("Your balance is PHP 10,000.");
                break;
            }  
            case "W":
            case "w": { // Withdraw
                double withdrawAmount;
                System.out.print("Enter amount to withdraw: PHP ");
                withdrawAmount = scan.nextDouble();

                if (withdrawAmount < 100) {
                    System.out.println("Amount must be at least PHP 100. Please try again.");
                }
                while (withdrawAmount < 100) {
                    System.out.println("You have withdrawn PHP " + withdrawAmount);
                    break;
                }
            }
            case "D":
            case "d": { // Deposit
                double depositAmount;
                System.out.print("Enter amount to deposit: PHP ");
                depositAmount = scan.nextDouble();

                if (depositAmount < 100) {
                    System.out.println("Amount must be at least PHP 100. Please try again.");
                }
                while (depositAmount < 100) {
                    System.out.println("You have deposited PHP " + depositAmount);
                    break;
                }
            }
            case "C":
            case "c": { // Change Password
                String currentPassword = "bulsucict";
                String oldPassword;
                String newPassword;
                System.out.print("Enter your current password: ");
                oldPassword = scan.next();
                if (oldPassword.equals(currentPassword)) {
                    System.out.print("Enter your new password: ");
                    newPassword = scan.next();
                    System.out.println("Your password has been changed successfully.");
                } while (!oldPassword.equals(currentPassword)) {
                    System.out.println("Incorrect password. Please try again.");
                }
                break;
            }
            case "E":
            case "e": { // Exit
                System.out.println("Thank you for using our ATM service. Goodbye!");
                break;
            }
            default: { // Invalid choice
                System.out.println("Invalid input... Please try again!");
                main(args); // Loop back to the start if invalid input :>>
            }
        }          
        scan.close();
    }
}