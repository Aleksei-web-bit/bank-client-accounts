package application;

import java.util.Objects;

public class Account {
    private static int currentAccountId = 0;
    private final int accountId;
    private int coins;

    public Account() {
        this.accountId = currentAccountId;
        currentAccountId++;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId && coins == account.coins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, coins);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                '}';
    }
}
