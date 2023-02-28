package lab01.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BankAccountTest {

    protected static final int DEPOSIT_AMOUNT = 100;
    protected static final int WITHDRAW_AMOUNT = 70;
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
    }

    @Test
    void testWrongDeposit() {
        final double anotherAmount = 50;
        final int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(wrongUserId, anotherAmount);
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
    }

    @Test
    void testWrongWithdraw() {
        final int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(wrongUserId, WITHDRAW_AMOUNT);
    }

}
