package Classes;

/** 
 * Класс - аккаунт, необходим для хранения данных счета
 * @author --
 * @version 1.0
*/
public class Account {

    /** поле имя */
    private String name;
    /** поле баланс */
    private int balance;
    /** поле депозит */
    private int deposit;

    /**
     * Конструктор - создание нового объекта (аккаунт)
     * @param name - имя
     * @param balance - баланс
     * @param deposit - депозит
     */
    public Account(String name, int balance, int deposit) {
        this.name = name;
        this.balance = balance;
        this.deposit = deposit;
    }

    /**
     * Получение значения поля имя
     */
    protected String getName() {
        return name;
    }

    /**
     * Определение значения поля имя
     * @param name - поле имя
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Получение значения поля баланс
     */
    protected int getBalance() {
        return balance;
    }

    /**
     * Определение значения поля баланс
     * @param balance - поле баланс
     */
    protected void setBalance(int balance) {
        this.balance = balance;
    }


    /**
     * Получение значения поля депозит
     */
    protected int getDeposit() {
        return deposit;
    }

    /**
     * Определение значения поля депозит
     * @param deposit - поле депозит
     */
    protected void setDeposit(int deposit) {
        this.deposit = deposit;
    }


    @Override
    public String toString() {
        // return "Account [name=" + name + ", balance=" + balance + ", deposit=" + deposit + "]";
        return String.format("Account [ name = %s, balance = %d, deposit = %d ]", name, balance, deposit );
    }
    
}
