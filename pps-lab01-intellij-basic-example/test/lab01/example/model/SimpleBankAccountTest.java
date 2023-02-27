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
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongDeposit() {
        super.testWrongDeposit();
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWithdraw() {
        super.testWithdraw();
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    @Override
    void testWrongWithdraw() {
        super.testWrongWithdraw();
        assertEquals(100, bankAccount.getBalance());
    }
}
