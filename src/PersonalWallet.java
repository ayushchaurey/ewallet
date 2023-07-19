public class PersonalWallet implements Wallet {
    private String username;
    private double balance;
    private static final double MINIMUM_BALANCE = 50;
    private static final double TRANSACTION_FEE = 5;
    private TransactionFeeCalculator transactionFeeCalculator;

    public PersonalWallet(String username, double balance, TransactionFeeCalculator transactionFeeCalculator) {
        this.username = username;
        this.balance = balance;
        this.transactionFeeCalculator = transactionFeeCalculator;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addMoney(double amount) {
        balance += amount;
    }
public void getTransaction(){
    
}
    @Override
    public void transferMoney(Wallet receiver, double amount) {
        if (receiver instanceof BusinessWallet) {
            if (balance >= amount) {
                balance -= amount;
                receiver.addMoney(amount);
            } else {
                System.out.println("Failed");
            }
        } else if (receiver instanceof PersonalWallet) {
            double totalAmount = amount;
            if (balance >= amount) {
                // Apply transaction fee for Personal to Personal transfer
                if (!receiver.getUsername().equals(username)) {
                    if (balance - (totalAmount + TRANSACTION_FEE) >= MINIMUM_BALANCE) {
                        balance -= (totalAmount + TRANSACTION_FEE);
                        transactionFeeCalculator.addTransactionFee(TRANSACTION_FEE);
                    } else {
                        System.out.println("Failed: Minimum balance of F₹ " + MINIMUM_BALANCE + " must be maintained.");
                        return;
                    }
                } else {
                    balance -= totalAmount;
                }
    
                receiver.addMoney(totalAmount);
                if (balance == ((PersonalWallet) receiver).getBalance()) {
                    balance += 10; // Reward
                    ((PersonalWallet) receiver).addMoney(10); // Reward
                }
            } else {
                System.out.println("Failed");
            }
        }
    }
    
    
    

    @Override
    public void displayBalance() {
        System.out.println(username + " " + balance);
    }
}
