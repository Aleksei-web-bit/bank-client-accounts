package application;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(int accountId) {
        super("Account id = " + accountId + " не найден.");
    }
}
