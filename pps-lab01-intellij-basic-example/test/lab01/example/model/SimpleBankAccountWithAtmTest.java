package lab01.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static lab01.example.model.SimpleBankAccountWithAtm.ATM_FEE;

class SimpleBankAccountWithAtmTest extends BankAccountTest {

    @BeforeEach
    @Override
    void beforeEach() {
        super.beforeEach();
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    @Override
    void testDeposit() {
        super.testDeposit();
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testAvoidDepositLessThanFees() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(accountHolder.getId(), 0);
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongDeposit() {
        super.testWrongDeposit();
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWithdraw() {
        super.testWithdraw();
        final double expected = DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - 2*ATM_FEE;
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongWithdraw() {
        super.testWrongWithdraw();
        assertEquals(DEPOSIT_AMOUNT - ATM_FEE, bankAccount.getBalance());
    }
}