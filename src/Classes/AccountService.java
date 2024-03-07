package Classes;

import myException.InsufficientFundsException;
import myException.IllegalArgumentException;

/** 
 * Класс - служба учетных записей, необходим для управления банковским счетом //////////////////////////
 * @author --
 * @version 1.0
*/
public class AccountService {

    /**
     * Метод для проверки состояния аккаунта
     * Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
     * Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
     * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
     * @param account - аккаунт
     * @param ithdrawFunds - сумма вывода / вывод средств
     */
    public static boolean checkAccountService(Account account, int withdrawFunds) throws IllegalArgumentException, InsufficientFundsException {
        
        // положительный баланс
        boolean balance = account.getBalance() < 0;
        // депозит с положительный суммой
        boolean deposit = account.getDeposit() < 0;
        // сумма вывода / вывод средств
        int withdrawalAmount = withdrawFunds;
        // начальный баланс
        int startBalance = account.getBalance();

        if (balance || deposit)
            throw new IllegalArgumentException(balance); // отрицательный баланс или отрицательный депозит
        else if (withdrawalAmount >= startBalance)
            throw new InsufficientFundsException(withdrawalAmount, startBalance); // снять сумму превышающую текущий баланс
        else
            return true;
    }
    
}
