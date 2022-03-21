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
        return accountClientMap.get(account);
    }

    Set<Account> findAccounts(Client client) {
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
}
