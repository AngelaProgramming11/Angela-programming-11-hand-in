import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Date;

public class CustomerTest {
    Customer testCustomer;
    Date theDate;
    @Before
    public void setup(){
        testCustomer = new Customer();
    }
    @Test
    public void displayDepositTest(){
        //deposit amount into checking account
        theDate = new Date();
        testCustomer.deposit(50, theDate, Customer.CHECKING);
        //check displayed amount, date and account
        assertEquals(testCustomer.getDeposits().get(0).toString(), "Deposit of: $50.0 Date: " + theDate + " into account: Checking");
        //deposit into savings account
        theDate = new Date();
        testCustomer.deposit(60, theDate, Customer.SAVING);
        //check displayed amount, date, and account
        assertEquals(testCustomer.getDeposits().get(1).toString(), "Deposit of: $60.0 Date: " + theDate + " into account: Saving");
    }
    @Test
    public void displayWithdrawalTest(){
        //deposit amount into checking account
        theDate = new Date();
        testCustomer.deposit(70, theDate, Customer.CHECKING);
        //withdraw amount
        testCustomer.withdraw(20, theDate, Customer.CHECKING);
        //check displayed amount, date and account
        assertEquals(testCustomer.getWithdraws().get(0).toString(), "Withdraw of: $20.0 Date: " + theDate + " from account: Checking");
        //deposit into savings account
        theDate = new Date();
        testCustomer.deposit(80, theDate, Customer.SAVING);
        //withdraw amount
        testCustomer.withdraw(10, theDate, Customer.SAVING);
        //check displayed amount, date and account
        assertEquals(testCustomer.getWithdraws().get(1).toString(), "Withdraw of: $10.0 Date: " + theDate + " from account: Saving");

    }
    @Test
    public void depositTest(){
        //check amount
        assertTrue(testCustomer.getDeposits().isEmpty());
        //deposit amount into checking account
        theDate = new Date();
        testCustomer.deposit(90, theDate, Customer.CHECKING);
        //check amount
        assertEquals(testCustomer.getDeposits().get(0).getAmount(), 90, 0);
        //check date
        assertEquals(testCustomer.getDeposits().get(0).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getDeposits().get(0).getAccount(), "Checking");
        //deposit amount into savings account
        theDate = new Date();
        testCustomer.deposit(95, theDate, Customer.SAVING);
        //check amount
        assertEquals(testCustomer.getDeposits().get(1).getAmount(), 95, 0);
        //check date
        assertEquals(testCustomer.getDeposits().get(1).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getDeposits().get(1).getAccount(), "Saving");
    }
    @Test
    public void enoughMoneyWithdrawalTest(){
        //check amount
        assertTrue(testCustomer.getDeposits().isEmpty());
        //deposit amount into checking account
        theDate = new Date();
        testCustomer.deposit(105, theDate, Customer.CHECKING);
        //withdraw amount
        testCustomer.withdraw(50, theDate, Customer.CHECKING);
        //check amount
        assertEquals(testCustomer.getWithdraws().get(0).getAmount(), 50, 0);
        //check date
        assertEquals(testCustomer.getWithdraws().get(0).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getWithdraws().get(0).getAccount(), "Checking");
        //check balance
        assertEquals(testCustomer.getCheckBalance(), 55, 0);
        //deposit amount into savings account
        theDate = new Date();
        testCustomer.deposit(110, theDate, Customer.SAVING);
        //withdraw amount
        testCustomer.withdraw(40, theDate, Customer.SAVING);
        //check amount
        assertEquals(testCustomer.getWithdraws().get(1).getAmount(), 40, 0);
        //check date
        assertEquals(testCustomer.getWithdraws().get(1).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getWithdraws().get(1).getAccount(), "Saving");
        //check balance
        assertEquals(testCustomer.getSavingBalance(), 70, 0);
    }
    @Test
    public void overdraftWithdrawalTest(){
        //check amount
        assertTrue(testCustomer.getDeposits().isEmpty());
        //deposit amount into checking account
        theDate = new Date();
        testCustomer.deposit(35, theDate, Customer.CHECKING);
        //withdraw amount
        testCustomer.withdraw(90, theDate, Customer.CHECKING);
        //check amount
        assertEquals(testCustomer.getWithdraws().get(0).getAmount(), 90, 0);
        //check date
        assertEquals(testCustomer.getWithdraws().get(0).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getWithdraws().get(0).getAccount(), "Checking");
        //check balance
        assertEquals(testCustomer.getCheckBalance(), -55, 0);
        //deposit amount into savings account
        theDate = new Date();
        testCustomer.deposit(25, theDate, Customer.SAVING);
        //withdraw amount
        testCustomer.withdraw(60, theDate, Customer.SAVING);
        //check amount
        assertEquals(testCustomer.getWithdraws().get(1).getAmount(), 60, 0);
        //check date
        assertEquals(testCustomer.getWithdraws().get(1).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getWithdraws().get(1).getAccount(), "Saving");
        //check balance
        assertEquals(testCustomer.getSavingBalance(), -35, 0);

    }
    @Test
    public void overWithdrawalLimitTest(){
        //check amount
        assertTrue(testCustomer.getDeposits().isEmpty());
        //deposit amount into checking account
        theDate = new Date();
        testCustomer.deposit(120, theDate, Customer.CHECKING);
        //withdraw amount
        testCustomer.withdraw(240, theDate, Customer.CHECKING);
        //check amount
        assertEquals(testCustomer.getWithdraws().get(0).getAmount(), 220, 0);
        //check date
        assertEquals(testCustomer.getWithdraws().get(0).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getWithdraws().get(0).getAccount(), "Checking");
        //check balance
        assertEquals(testCustomer.getCheckBalance(), -100, 0);
        //deposit amount into savings account
        theDate = new Date();
        testCustomer.deposit(10, theDate, Customer.SAVING);
        //withdraw amount
        testCustomer.withdraw(300, theDate, Customer.SAVING);
        //check amount
        assertEquals(testCustomer.getWithdraws().get(1).getAmount(), 110, 0);
        //check date
        assertEquals(testCustomer.getWithdraws().get(1).getDate(), theDate);
        //check account
        assertEquals(testCustomer.getWithdraws().get(1).getAccount(), "Saving");
        //check balance
        assertEquals(testCustomer.getSavingBalance(), -100, 0);
    }
}
