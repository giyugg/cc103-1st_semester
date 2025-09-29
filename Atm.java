import java.util.Scanner;
public class Atm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double balance = 10000;
        boolean running = true;

        // switch
        // ATM Transaction Simulation
        // [B]alance Inquiry
        // [W]ithdraw
        // [D]eposit
        // [C]hange Password
        // [E]xit

        while (running) {
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
                case "b":
                    System.out.println("Your balance is PHP " + balance);
                    break;
                case "W":
                case "w": {
                    double withdrawAmount;
                    do {
                        System.out.print("Enter amount to withdraw (minimum PHP 100): PHP ");
                        withdrawAmount = scan.nextDouble();
                        if (withdrawAmount < 100) {
                            System.out.println("Amount must be at least PHP 100. Please try again.");
                        } else if (withdrawAmount > balance) {
                            System.out.println("Insufficient funds. Please try again.");
                            withdrawAmount = 0; // force loop to continue
                        }
                    } while (withdrawAmount < 100 || withdrawAmount > balance);
                    balance -= withdrawAmount;
                    System.out.println("You have withdrawn PHP " + withdrawAmount);
                    break;
                }
                case "D":
                case "d": {
                    double depositAmount;
                    do {
                        System.out.print("Enter amount to deposit (minimum PHP 100): PHP ");
                        depositAmount = scan.nextDouble();
                        if (depositAmount < 100) {
                            System.out.println("Amount must be at least PHP 100. Please try again.");
                        }
                    } while (depositAmount < 100);
                    balance += depositAmount;
                    System.out.println("You have deposited PHP " + depositAmount);
                    break;
                }
                case "C":
                case "c": {
                    String currentPassword = "bulsucict";
                    String oldPassword;
                    String newPassword;
                    do {
                        System.out.print("Enter your current password: ");
                        oldPassword = scan.next();
                        if (!oldPassword.equals(currentPassword)) {
                            System.out.println("Incorrect password. Please try again.");
                        }
                    } while (!oldPassword.equals(currentPassword));
                    System.out.print("Enter your new password: ");
                    newPassword = scan.next();
                    System.out.println("Your password has been changed successfully.");
                    currentPassword = newPassword;
                    break;
                }
                case "E":
                case "e":
                    System.out.println("Thank you for using our ATM service. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input... Please try again!");
            }
            System.out.println();
        }
        scan.close();
    }
}