import java.util.Scanner;
public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variable declarations: Employee details
        String employeeName, departmentCode, statusCode;
        // Variable declarations: Hour time based details
        int hoursWorked, ratePerHour;
        // Variable declarations: Salary details
        double grossIncome;
        // Variable declarations: Deductions
        double birTax, securityTax, totalDeductions;
        // Variable declarations: Net Income
        double netIncome;

        // Input: Employee details
        System.out.print("Enter Employee Name: ");
        employeeName = input.nextLine();

        System.out.print("Enter Department Code: ");
        departmentCode = input.nextLine();
        if (departmentCode.equalsIgnoreCase("MIS")) { // Management Information Systems
            ratePerHour = 500;
        }
        else if (departmentCode.equalsIgnoreCase("MKT")) { // Marketing
            ratePerHour = 400;
        }
        else if (departmentCode.equalsIgnoreCase("ACT")) { // Accounting
            ratePerHour = 550;
        }
        else {
            System.out.println("Invalid Department Code");
            System.out.println("Goodbye...");
            input.close();
            return; // Our professor suggests that we should use System.exit(0) instead of return. This is similar to System.exit(0) don't worry.
        }
        
        System.out.print("Enter Hours Worked: ");
        hoursWorked = input.nextInt();
        input.nextLine(); // fix bug that skips next input

        System.out.print("Enter Status Code: ");
        statusCode = input.nextLine();
        if (statusCode.equalsIgnoreCase("HOF")) { // Head of Family
            birTax = 0.1;
            securityTax = 0.05;
        }
        else if (statusCode.equalsIgnoreCase("SWD")) { // Single with Dependents
            birTax = 0.15;
            securityTax = 0.1;
        }
        else if (statusCode.equalsIgnoreCase("SOD")) { // Single without Dependents
            birTax = 0.2;
            securityTax = 0.15;
        }
        else {
            System.out.println("Invalid Status Code");
            System.out.println("Goodbye...");
            input.close();
            return; // Our professor suggests that we should use System.exit(0) instead of return. This is similar to System.exit(0) don't worry.
        }

        // Process: Salary calculations
        grossIncome = hoursWorked * ratePerHour;
        System.out.println("\nGross Salary is: PHP " + (grossIncome)); // added newline para maganda
        totalDeductions = (birTax + securityTax) * grossIncome;
        System.out.println("Total Deductions is: PHP " + (totalDeductions));
        netIncome = grossIncome - totalDeductions;
        System.out.println("Net Salary is: PHP " + (netIncome));

        input.close();
    }
}