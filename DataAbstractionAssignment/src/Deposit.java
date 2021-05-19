import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //constructor
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //requires: N/A
    //modifies: N/A
    //effects: returns deposit info: amount, date and deposit account
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
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
