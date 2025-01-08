import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example1.BankAccount;

public class BankAccountTest {

    // private BankAccount account;

    @BeforeEach
    public void setUp() {
        // Thiết lập môi trường kiểm thử trước mỗi bài kiểm thử
        // account = new BankAccount();
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be 100.0 after deposit.");
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), "Balance should be 50.0 after withdrawal of 50.0.");
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount();
        account.deposit(50.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        });
        assertEquals("Insufficient balance", exception.getMessage(),
                "Should throw exception when withdrawing more than balance.");
    }

    @Test
    public void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BankAccount account = new BankAccount();
            account.deposit(-10.0);
        });
        assertEquals("Amount must be greater than zero", exception.getMessage(),
                "Should throw exception when depositing a negative amount.");
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BankAccount account = new BankAccount();
            account.withdraw(-10.0);
        });
        assertEquals("Amount must be greater than zero", exception.getMessage(),
                "Should throw exception when withdrawing a negative amount.");
    }

    @Test
    public void testDepositZeroAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BankAccount account = new BankAccount();
            account.deposit(0.0);
        });
        assertEquals("Amount must be greater than zero", exception.getMessage(),
                "Should throw exception when depositing zero amount.");
    }

    @Test
    public void testWithdrawZeroAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BankAccount account = new BankAccount();
            account.withdraw(0.0);
        });
        assertEquals("Amount must be greater than zero", exception.getMessage(),
                "Should throw exception when withdrawing zero amount.");
    }

    @Test
    public void testBalanceAfterMultipleTransactions() {
        BankAccount account = new BankAccount();
        account.deposit(200.0);
        account.withdraw(50.0);
        account.deposit(150.0);
        account.withdraw(100.0);
        assertEquals(200.0, account.getBalance(), "Balance should be 200.0 after multiple deposits and withdrawals.");
    }

    @Test
    public void testBalanceInitialState() {
        BankAccount account = new BankAccount();
        assertEquals(0.0, account.getBalance(), "Initial balance should be 0.0.");
    }

    @Test
    public void testWithdrawToZeroBalance() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance(), "Balance should be 0.0 after withdrawing all funds.");
    }
}
