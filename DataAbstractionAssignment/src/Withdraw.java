import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //constructor
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //requires: N/A
    //modifies: N/A
    //effects: returns withdrawal info: amount, date and account
    public String toString(){
        //your code here
        return "Withdraw of: $" + amount + " Date: " + date + " from account: " + account;
    }

    //getters
    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getAccount() {
        return account;
    }
}
