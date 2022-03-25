package application;

import java.util.Set;

public class App {

    public static void main(String[] args) {
        Client client1 = new Client("Ivan", 18);
        Client client2 = new Client("Petr", 19);
        Client client3 = new Client("Dmitrii", 20);
        Client client4 = new Client("Sergey", 26);

        Bank bank = new Bank();

        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Account account4 = new Account();
        Account account5 = new Account();
        Account account6 = new Account();
        Account account7 = new Account();

        bank.addAccountClient(account1, client1);
        bank.addAccountClient(account2, client2);
        bank.addAccountClient(account3, client2);
        bank.addAccountClient(account4, client3);
        bank.addAccountClient(account5, client3);
        bank.addAccountClient(account6, client3);

        // Поиск клиента по номеру счёта.
        try {
        Client clientResult1 = bank.findClient(account1);
        System.out.println("Результат поиска клиента по первому запросу: " + clientResult1);

        Client clientResult2 = bank.findClient(account7);
        System.out.println("Результат поиска клиента по второму запросу: " + clientResult2);

        Client clientResult3 = bank.findClient(null);
        System.out.println("Результат поиска клиента по третьему запросу: " + clientResult3);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }finally {
            System.out.println("Final");
        }

        // Поиск счетов клиента.
        try {
            Set<Account> accountSet1 = bank.findAccounts(client1);
            System.out.println("Результат поиска счетов по первому запросу: " + accountSet1);

            Set<Account> accountSet2 = bank.findAccounts(client4);
            System.out.println("Результат поиска счетов по второму запросу: " + accountSet2);

            Set<Account> accountSet3 = bank.findAccounts(null);
            System.out.println("Результат поиска счетов по третьему запросу: " + accountSet3);
        } catch (IllegalArgumentException | IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

//        System.out.println("Результат поиска клиента до его удаления: " + bank.hasClient(client4));

        // Удаление клиента и всех его счетов.
//        bank.removeClient(client4);

//        System.out.println("Результат поиска клиента после его удаления: " + bank.hasClient(client4));
//        System.out.println(bank.isNotNull(client3));
    }
}
