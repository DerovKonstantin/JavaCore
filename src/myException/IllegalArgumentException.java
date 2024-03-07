package myException;

/** 
 * Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
*/
public class IllegalArgumentException extends Exception  {

    /** поле баланс или депозит */
    private boolean balanceOrDeposit;

    public IllegalArgumentException(boolean balance) {
        super();
        this.balanceOrDeposit = balance;
    }

    @Override
    public String getMessage() {
        return String.format("Попытка %s с отрицательн%s. %s должен быть положительным.",
                ((balanceOrDeposit) ? "создать счет" : "внести депозит"),
                ((balanceOrDeposit) ? "ым начальным балансом" : "ой суммой"),
                ((balanceOrDeposit) ? "Счет" : "Депозит"));
    }
}
