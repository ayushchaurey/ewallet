public interface Wallet {
    String getUsername();
    double getBalance();
    void addMoney(double amount);
    void transferMoney(Wallet receiver, double amount);
    void displayBalance();
    
}
