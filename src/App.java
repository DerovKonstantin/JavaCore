import Classes.Account;
import Classes.AccountService;
import Classes.CreditAcciunt;
import Classes.DebitAccount;
import Classes.Transaction;
import myException.InsufficientFundsException;
import myException.IllegalArgumentException;

public class App {
    public static void main(String[] args) throws Exception {

        // 1. Создать программу управления банковским счетом (Account).
        // Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств. При этом она должна обрабатывать следующие исключительные ситуации:
        // Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
        // Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
        // Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
        // Продемонстрируйте работу вашего приложения:
        // Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.

        // Создаем список банковских аккаунтов
        Account[] accountList = {
            new Account("Ivan", -1, 0),
            new Account("Sergey", 10, 100),
            new Account("Vasikii", 10, -10),
            new Account("Igor", 100000, 10),
            new Account("Konstantin", 1000000000, 10000)
        };

        // Проверка состояний аккаунтов
        int withdrawFunds = 10000; // сумма вывода средств
        for (Account account : accountList) {
            try {
                System.out.println(AccountService.checkAccountService(account, withdrawFunds));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("=====================================================================================================");

        // 2*.
        // Создать несколько типов счетов, унаследованных от Account, например: CreditAcciunt, DebitAccount.
        // Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета на другой)
        // Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.
        // Продемонстрируйте работу вашего приложения:
        // Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.

        // Создаем список банковских аккаунтов
        DebitAccount Igor = new DebitAccount("Igor", 100000, 10, 123654789);
        CreditAcciunt Ivan = new CreditAcciunt("Ivan", -1, 0, 123457894);
        DebitAccount Sergey = new DebitAccount("Sergey", 10, 100, 123554789);
        CreditAcciunt Vasikii = new CreditAcciunt("Vasikii", 10, -10, 132456789);
        DebitAccount Jon = new DebitAccount("Jon", 100000, 10, 145789145);
        CreditAcciunt Konstantin = new CreditAcciunt("Konstantin", 100000000, 10000, 123546798);
        
        // Переводим деньги
        Transaction.checktransactionAccountService(Igor, Ivan, -1);
        Transaction.checktransactionAccountService(Sergey, Vasikii, 2);
        Transaction.checktransactionAccountService(Jon, Konstantin, 10000000);

    }
}
