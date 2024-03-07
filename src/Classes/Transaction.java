package Classes;

import myException.InsufficientFundsException;
import myException.IllegalTransactionArgumentException;

public class Transaction {
    
    /**
     * Метод проводить транзакции между счетами (переводить сумму с одного счета на другой)
     * @param debitAccount - аккаунт списания средств
     * @param creditAccount - аккаунт зачисления средств
     * @param ithdrawFunds - сумма вывода / вывод средств
     */
    public static void checktransactionAccountService(DebitAccount debitAccount, CreditAcciunt creditAccount, int transaction) {

        try {
            if (checkTransaction(debitAccount, transaction)) creditAccount.setBalance(creditAccount.getBalance() + transaction);
            System.out.printf("Успешный перевод средств, счет пополнени на %d р. и составляет %d р.\n", transaction, creditAccount.getBalance());
        } catch (IllegalTransactionArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Метод прверяет корректность проводимой транзакции
     * @param debitAccount - аккаунт списания средств
     * @param transaction - сумма списания средств
     */
    public static boolean checkTransaction(DebitAccount debitAccount, int transaction) throws IllegalTransactionArgumentException, InsufficientFundsException {

        // положительный дебитовый баланс 
        boolean positiveBalance = debitAccount.getBalance() < 0;
        // перевод положительной суммой
        boolean positiveTransfer = transaction < 0;
        // начальный баланс
        int debitBalance = debitAccount.getBalance();

        if (positiveBalance || positiveTransfer)
            throw new IllegalTransactionArgumentException(positiveBalance); // отрицательный баланс или отрицательный перевод
        else if (transaction >= debitBalance)
            throw new InsufficientFundsException(transaction, debitBalance); // снять сумму превышающую текущий баланс
        else
            return true;

    }
 
}
