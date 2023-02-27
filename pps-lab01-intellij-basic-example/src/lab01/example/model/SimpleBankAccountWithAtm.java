package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {

    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
