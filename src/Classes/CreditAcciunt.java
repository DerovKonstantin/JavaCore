package Classes;

public class CreditAcciunt extends Account {

    // номер рсчетного счета
    int currentAccountNumber;

    public CreditAcciunt(String name, int balance, int deposit, int currentAccountNumber) {
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
