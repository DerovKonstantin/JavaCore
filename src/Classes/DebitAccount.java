package Classes;

public class DebitAccount extends Account {

    // номер рсчетного счета
    int currentAccountNumber;

    public DebitAccount(String name, int balance, int deposit, int currentAccountNumber) {
        super(name, balance, deposit);
        this.currentAccountNumber = currentAccountNumber;
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(int currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }
    
}
