import java.util.ArrayList;
import java.util.List;

public class WalletManager {
    private List<Wallet> wallets;
    private TransactionFeeCalculator transactionFeeCalculator;

    public WalletManager() {
        wallets = new ArrayList<>();
        transactionFeeCalculator = new TransactionFeeCalculator();
    }

   

    public void createWallet(String type, String user, double balance) {
        if ("Personal".equalsIgnoreCase(type)) {
            if(balance>=50){
            wallets.add(new PersonalWallet(user, balance, transactionFeeCalculator));}
        } else if ("Business".equalsIgnoreCase(type)) {
            // Assuming you have the GST number in the user parameter for simplicity.
            String[] businessInfo = user.split(",");
            wallets.add(new BusinessWallet(businessInfo[0].trim(), businessInfo[1].trim(), balance));
        }
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public Wallet findWalletByUsername(String username) {
        for (Wallet wallet : wallets) {
            if (wallet.getUsername().equalsIgnoreCase(username)) {
                return wallet;
            }
        }
        return null;
    }

    public void displayOverview() {
        for (Wallet wallet : wallets) {
            wallet.displayBalance();
            
        }
    }

    public TransactionFeeCalculator getTransactionFeeCalculator() {
        return transactionFeeCalculator;
    }
}
