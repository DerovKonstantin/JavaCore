package myException;


/** 
 * Попытка произвести перевод средств со счета с отрицательным балансом.
 * Попытка произвести перевод средств на отрицательную суму.
*/
public class IllegalTransactionArgumentException  extends Exception  {

    /** поле баланс или депозит */
    private boolean balanceOrTransfer;

    public IllegalTransactionArgumentException(boolean balance) {
        super();
        this.balanceOrTransfer = balance;
    }

    @Override
    public String getMessage() {
        return String.format("Попытка произвести перевод средств %s. %s должен быть положительным.",
                ((balanceOrTransfer) ? "со счета с отрицательным балансом" : "на отрицательную суму"),
                ((balanceOrTransfer) ? "Баланс счета списания" : "Перевод"));
    }
}
