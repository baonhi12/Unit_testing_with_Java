import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example1.BankAccount;

public class BankAccountTest {

    // private BankAccount account;

    // @BeforeEach
    // public void setUp() {
    // // Thiết lập môi trường kiểm thử trước mỗi bài kiểm thử
    // // account = new BankAccount();
    // }

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount();
        assertEquals(0.0, account.getBalance(), "Initial balance should be 0.0.");
    }

    @Test
    public void testDepositPositiveAmount() {
        BankAccount account = new BankAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be 100.0 after depositing 100.0.");
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

    @Test
    public void testConcurrencySafety() {
        BankAccount account = new BankAccount();
        // Kiểm tra tính an toàn trong môi trường đa luồng
        account.deposit(1000.0);
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(10.0);
            }
        };

        Thread thread1 = new Thread(withdrawTask);
        Thread thread2 = new Thread(withdrawTask);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            fail("Thread interrupted.");
        }

        assertEquals(800.0, account.getBalance(), "Balance should be consistent after concurrent withdrawals.");
    }

    @Test
    public void testLargeTransactionAmount() {
        BankAccount account = new BankAccount();
        account.deposit(1_000_000.0);
        assertEquals(1_000_000.0, account.getBalance(), "Balance should handle large transaction amounts correctly.");
    }

    @Test
    public void testSmallTransactionAmount() {
        BankAccount account = new BankAccount();
        account.deposit(0.01);
        assertEquals(0.01, account.getBalance(), "Balance should handle small transaction amounts correctly.");
    }
}
