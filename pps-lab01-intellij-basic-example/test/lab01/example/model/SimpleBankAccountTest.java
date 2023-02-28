package lab01.example.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BankAccountTest {


    @BeforeEach
    @Override
    void beforeEach(){
        super.beforeEach();
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    @Override
    void testDeposit() {
        super.testDeposit();
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongDeposit() {
        super.testWrongDeposit();
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWithdraw() {
        super.testWithdraw();
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongWithdraw() {
        super.testWrongWithdraw();
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}
