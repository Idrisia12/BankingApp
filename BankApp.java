import java.util.Scanner; // Scanner is used to get user inputs.

class BankInfo {
  private String account_number;
  private String name;
  private String account_type;
  private long balance;

  Scanner sc = new Scanner(System.in); // System in is the input stream connected to the console/terminal.

  // Opening New Account
  public void openAccount() {
    System.out.print("Welcome, Please Enter an Account Number");
    // The next() method in java is present in the Scanner class and is used to get the input from the user
    account_number = sc.next();
    System.out.print("Enter Name");
    name = sc.next();
    System.out.print("Enter Account Type");
    account_type = sc.next();
    System.out.print("Enter Balance");
    balance = sc.nextLong();
  }

  // Displaying the Account Details
  public void showAccount() {
    System.out.println("Name of account holder: " + name);
    System.out.println("Account Number: " + account_number);
    System.out.println("Account Type: " + account_type);
    System.out.println("Account Balance: " + balance);
  }

  // Depositing money into the Bank Account
  public void deposit() {
    long amount;
    System.out.println("Enter Deposit Amount");
    amount = sc.nextLong();
    balance = balance + amount;
  }

  // Withdrawing some cool cash
  public void withdrawal() {
    long amount;
    System.out.println("Enter withdrawal amount");
    amount = sc.nextLong();

    if (balance >= amount) { // If balance is greater than or equal to amount,
      balance = balance - amount;
      System.out.println("Balance After Withdrawing: " + balance);
    } else {
      System.out.println("Your balance is less than " + amount + "\t Sorry, Transaction Failed");

    }
  }

  // Searching for An Account Number
  public boolean search(String account_no) {
    if(account_number.equals(account_no)) {
      showAccount();
      return (true);
    }
    return (false);
  }
}

class BankApp {
  public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    //create initial accounts
    System.out.print("How many number of customers do you want to input? ");
    int n = sc.nextInt();
    BankInfo C[] = new BankInfo[n];
    for (int i = 0; i < C.length; i++) {
        C[i] = new BankInfo();
        C[i].openAccount();
    }
    // loop runs until number 5 is not pressed to exit
    int ch;
    do {
        System.out.println("\n ***Banking System Application***");
        System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
        System.out.println("Enter your choice: ");
        ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
            }
        }
        while (ch != 5);
    }
}
