package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    protected static final int ATM_FEE = 1;
    private final BankAccount delegate;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.delegate = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.delegate.getHolder();
    }

    @Override
    public double getBalance() {
        return this.delegate.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        if (amount > ATM_FEE) {
            this.delegate.deposit(userID, amount - ATM_FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        this.delegate.withdraw(userID, amount + ATM_FEE);
    }

}
