package myException;

/** 
 * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
*/
public class InsufficientFundsException extends Exception  {

    /** поле сумма вывода */
    private int withdrawalAmount;
    /** поле начальный баланс */
    private int startBalance;

    public InsufficientFundsException(int withdrawalAmount, int startBalance) {
        super();
        this.withdrawalAmount = withdrawalAmount;
        this.startBalance = startBalance;
    }

    @Override
    public String getMessage() {
        return String.format("Попытка снять средства, сумма которых превышает текущий баланс. Сумма вывода %d не должна превышать текущий баланс %d.",
        withdrawalAmount, startBalance);
    }

}
