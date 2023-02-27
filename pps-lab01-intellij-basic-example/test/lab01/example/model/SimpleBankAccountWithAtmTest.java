package lab01.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongDeposit() {
        super.testWrongDeposit();
        assertEquals(AMOUNT - SimpleBankAccountWithAtm.ATM_FEE, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWithdraw() {
        super.testWithdraw();
        assertEquals(28, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongWithdraw() {
        super.testWrongWithdraw();
        assertEquals(AMOUNT - SimpleBankAccountWithAtm.ATM_FEE, bankAccount.getBalance());
    }
}