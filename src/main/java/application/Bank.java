package application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bank {
    private final Map<Account, Client> accountClientMap = new HashMap<>();
    private final Map<Client, Set<Account>> clientAccountsMap = new HashMap<>();

    public void addAccountClient(Account account, Client client) {
        accountClientMap.put(account, client);
        if (!clientAccountsMap.containsKey(client)) {
            clientAccountsMap.put(client, new HashSet<>(Set.of(account)));
        } else {
            clientAccountsMap.get(client).add(account);
        }
    }

    Client findClient(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Значение account не должно быть null.");
        }

        if (!hasAccount(account)) {
            throw new AccountNotFoundException(account.getAccountId());
        }

        return accountClientMap.get(account);
    }

    Client findClientOld(Account account) {
        if (account == null) {
            System.out.println("Значение account: null");
            return null;
        }

        if (hasAccount(account) == true) {
            return accountClientMap.get(account);
        } else {
            System.out.println("Данного счёта не существует!");
            return null;
        }
    }

    Set<Account> findAccounts(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Значение client не должно быть null.");
        }

        if (!hasClient(client)) {
            throw new IllegalStateException("Клиент с именем: " + client.getName() + " не найден.");
        }

        return clientAccountsMap.get(client);
    }

    public void removeClient(Client client) {
        Set<Account> accounts = findAccounts(client);

        for (Account account : accounts) {
            accountClientMap.remove(account);
        }

        clientAccountsMap.remove(client);
    }

    public boolean hasClient(Client client) {
        return clientAccountsMap.containsKey(client);
    }

    public boolean hasAccount(Account account) {
        return accountClientMap.containsKey(account);
    }

    public boolean isNotNull(Object obj) {
        if (obj != null) {
            return true;
        } else {
            System.out.println("Значение объекта: null");
            return false;
        }
    }
}
