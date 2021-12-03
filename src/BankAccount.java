import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    BankAccount(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0)
            System.out.println("Deposited: " + previousTransaction);

        else if (previousTransaction < 0)
            System.out.println("Withdrew: " + Math.abs(previousTransaction));

        else
            System.out.println("No transaction occurred");
    }

    public void showMenu() {
        char option;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerID);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("==================================================");
            System.out.println("Enter an option");
            System.out.println("==================================================");
            option = scnr.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("----------------------------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("----------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("----------------------------------");
                    int amount = scnr.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("----------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("----------------------------------");
                    int amount2 = scnr.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("----------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("***********************************");
                    break;

                default:
                    System.out.println("Invalid Option! Please enter again");
                    break;
            }
        } while(option != 'E');

        System.out.println("Thank you for using our services");
    }


}
