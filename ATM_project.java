import java.util.Scanner;

public class ATM_project {
    private double balance;
    private Scanner sc;

    public ATM_project(){
        balance = 1000.00;
        sc = new Scanner(System.in); // This Scanner is for operations within ATM_project methods
    }

    public void displayMenu(){
        System.out.println("\nEnter your choice :");
        System.out.println("1. Check current balance");
        System.out.println("2. Deposit cash");
        System.out.println("3. Withdraw cash");
        System.out.println("4. Exit");
    }

    public void checkBalance(){
        System.out.println("Your current balance is $"+balance);
    }

    public void depositCash(){
        System.out.print("Enter the cash to deposit: $"); // Added $ for better UX
        double cash = sc.nextDouble();
        if (cash > 0.0){
            balance += cash;
            System.out.println("Your cash has been deposited successfully.");
            System.out.println("Your current balance is $"+balance);
        }
        else{
            System.out.println("Entered amount is invalid. Please enter a valid amount.");
        }
    }

    public void withdrawCash(){
        System.out.print("Enter the cash to withdraw: $"); // Added $ for better UX
        double cash = sc.nextDouble();
        if (cash > 0.0){
            if (balance >= cash) { // Check if sufficient balance
                balance -= cash;
                System.out.println("Your cash has been withdrawn successfully.");
                System.out.println("Your current balance is $"+balance);
            } else {
                System.out.println("Insufficient balance. Cannot withdraw $"+cash);
                System.out.println("Your current balance is $"+balance);
            }
        }
        else{
            System.out.println("Enter a valid amount to withdraw.");
        }
    }

    public static void main(String[] args) {
        ATM_project atm = new ATM_project();

        // Use try-with-resources to ensure the mainScanner is closed properly
        try (Scanner mainScanner = new Scanner(System.in)) { // This Scanner is for menu choice in main
            int choice;
            do {
                atm.displayMenu(); // Display menu in each iteration
                System.out.print("Enter your choice: "); // Prompt for user input
                choice = mainScanner.nextInt(); // Read choice inside the loop

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        atm.depositCash();
                        break;
                    case 3:
                        atm.withdrawCash();
                        break;
                    case 4:
                        System.out.println("Thank you! Please visit again!");
                        break; // Break out of the switch, the do-while condition will then terminate the loop
                    default:
                        System.out.println("Invalid choice. Please select a valid option (1-4).");
                        break;
                }
            } while (choice != 4); // Loop continues as long as choice is not 4
        }
    }
}