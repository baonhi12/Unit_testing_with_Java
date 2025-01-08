
# Unit_testing_with_Java

This project demonstrates the implementation of a simple BankAccount class in Java with unit testing using JUnit 5. It covers basic functionality such as depositing, withdrawing, and retrieving the account balance, alongside robust error handling. Additionally, unit tests ensure that all methods function correctly under various conditions.


## Authors

- FullName: PHAM BAO NHI 
- SID: BIT220127
- Class: 22IT-SE2


## Implementation

### BankAccount Class

The BankAccount class handles operations related to managing an account's balance.

- Deposit: Adds a specified amount to the account balance. Throws an exception if the amount is non-positive.

- Withdraw: Subtracts a specified amount from the account balance. Throws exceptions for non-positive amounts or insufficient balance.

- Get Balance: Retrieves the current account balance.

### BankAccountTest Class

The BankAccountTest class uses JUnit 5 to validate the correctness of the BankAccount methods.

- testDeposit: Verifies that depositing a positive amount updates the balance correctly.

- testWithdraw: Verifies that withdrawing a valid amount decreases the balance correctly.

- testWithdrawInsufficientBalance: Ensures an exception is thrown when attempting to withdraw more than the balance.

- testDepositNegativeAmount: Ensures an exception is thrown when depositing a negative amount.

- testWithdrawNegativeAmount: Ensures an exception is thrown when withdrawing a negative amount.


## Results

- The testDeposit and testWithdraw tests confirm that the balance is updated as expected.

- The exception tests validate the proper handling of invalid inputs (e.g., negative amounts or insufficient balance).

```bash
Running BankAccountTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 sec

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.707 s
[INFO] Finished at: 2025-01-06T15:32:00+07:00
[INFO] ------------------------------------------------------------------------
```





## ChatGPT Link

https://chatgpt.com/share/677b9599-b190-8011-ba79-e51a556d286c 