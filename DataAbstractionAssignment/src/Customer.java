import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber = numberOfCustomers;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;
    private static int numberOfCustomers = 0;

    Customer(){
        //create default constructor
        checkBalance = 0;
        savingBalance = 0;
        name = "name";
        numberOfCustomers++;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        numberOfCustomers++;
    }

    //requires: double, Date, String
    //modifies this, deposits
    //effects: adds amt to either the checking or savings account; modifies deposits
    public double deposit(double amt, Date date, String account){
        //determine which account to deposit in
        if(account == CHECKING) {
            this.checkBalance += amt;
        }
        else if(account == SAVING) {
            this.savingBalance += amt;
        }
        //create temporary deposit instance to store info
        Deposit depositInfo = new Deposit(amt, date, account);
        //enter deposit info into the records
        this.deposits.add(depositInfo);
        return 0;
    }

    //requires: double, Date, String
    //modifies this, withdrawals
    //effects: subtract money from either the checking or savings account. can only withdraw to the overdraft limit; modifies withdrawals
    public double withdraw(double amt, Date date, String account){
        //withdraw money
        //determine which account to withdraw from
        if(account == CHECKING) {
            //make sure customer doesn't withdraw past the allowed overdraft amount
            if((this.checkBalance - amt) < OVERDRAFT){
                amt = this.checkBalance - OVERDRAFT;
                this.checkBalance = OVERDRAFT;
            }
            else {
                this.checkBalance -= amt;
            }
        }
        else if (account == SAVING){
            //make sure customer doesn't withdraw past overdraft limit
            if(this.savingBalance - amt < OVERDRAFT) {
                amt = this.savingBalance - OVERDRAFT;
                this.savingBalance = OVERDRAFT;
            }
            else{
                this.savingBalance -= amt;
            }
        }
        //record withdrawal info
        Withdraw withdrawInfo = new Withdraw(amt, date, account);
        withdraws.add(withdrawInfo);
        return 0;
    }

    //requires: double, String
    //modifies: N/A
    //effects: checks if either the checking or savings account is in overdraft; returns the result
    private boolean checkOverdraft(double amt, String account){
        //determines if the checking account or the savings account is in overdraft
        if((account == Customer.CHECKING && (this.checkBalance - amt) < 0) || (account == Customer.SAVING && (this.savingBalance - amt) < 0)){
            return true;
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    //getters
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
}
