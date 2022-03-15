package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<Account, Client> accountClientMap = new HashMap<>();
    private final Map<Client, List<Account>> clientAccountsMap = new HashMap<>();

    public void addAccountClient(Account account, Client client) {
        accountClientMap.put(account, client);
        if (!clientAccountsMap.containsKey(client)) {
            clientAccountsMap.put(client, new ArrayList<>(List.of(account)));
        } else {
            clientAccountsMap.get(client).add(account);
        }
    }

    Client findClient(Account account) {
        return accountClientMap.get(account);
    }

    List<Account> findAccounts(Client client) {
        return clientAccountsMap.get(client);
    }

    public static void main(String[] args) {
        Client client1 = new Client("Ivan", 18);
        Client client2 = new Client("Petr", 19);
        Client client3 = new Client("Dmitrii", 20);

        Bank bank = new Bank();

        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Account account4 = new Account();
        Account account5 = new Account();
        Account account6 = new Account();

        bank.addAccountClient(account1, client1);
        bank.addAccountClient(account2, client2);
        bank.addAccountClient(account3, client2);
        bank.addAccountClient(account4, client3);
        bank.addAccountClient(account5, client3);
        bank.addAccountClient(account6, client3);

        // Поиск клиента по номеру счёта.
        Client clientResult = bank.findClient(account6);
        System.out.println("Результат поиска клиента по счёту: " + clientResult);

        List<Account> accountList1 = bank.findAccounts(client1);
        List<Account> accountList2 = bank.findAccounts(client2);
        List<Account> accountList3 = bank.findAccounts(client3);

// Поиск счетов клиента.
        System.out.println("Результат поиска счетов клиента: " + accountList3);
    }
}
