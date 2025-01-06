
// src/test/java/BankAccountTest.java
import org.junit.jupiter.api.Test;

import com.example1.BankAccount;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount();
        account.deposit(50.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    public void testDepositNegativeAmount() {
        BankAccount account = new BankAccount();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.0);
        });
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10.0);
        });
        assertEquals("Amount must be greater than zero", exception.getMessage());
    }
}
