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

    }

    @Test
    @Override
    void testWrongDeposit() {
        super.testWrongDeposit();
    }

    @Test
    @Override
    void testWithdraw() {
        super.testWithdraw();
    }

    @Test
    @Override
    void testWrongWithdraw() {
        super.testWrongWithdraw();
    }
}