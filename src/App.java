public class App {
    public static void main(String[] args) {
        WalletManager walletManager = new WalletManager();
        TransactionFeeCalculator transactionFeeCalculator = new TransactionFeeCalculator();
        walletManager.createWallet("Personal", "Harry", 100);
        walletManager.createWallet("Personal", "Ron", 95);
        walletManager.createWallet("Personal", "Hermione", 104);
        walletManager.createWallet("Business", "Albus,ALBUSGST121", 200);
        walletManager.createWallet("Business", "Draco,DracoGST123", 500);

        System.out.println("Overview");
        walletManager.displayOverview();

        Wallet harryWallet = walletManager.findWalletByUsername("Harry");
        Wallet albusWallet = walletManager.findWalletByUsername("Albus");
        Wallet hermioneWallet = walletManager.findWalletByUsername("Hermione");
        Wallet dracoWallet = walletManager.findWalletByUsername("Draco");

        harryWallet.transferMoney(albusWallet, 100); 
        hermioneWallet.transferMoney(harryWallet, 2);
        albusWallet.transferMoney(dracoWallet, 5);
        albusWallet.transferMoney(harryWallet, 30);
        harryWallet.transferMoney(albusWallet, 100);

        System.out.println("Overview");
        walletManager.displayOverview();

        System.out.println("Balance Harry");
        harryWallet.displayBalance();

        System.out.println("Balance Albus");
        albusWallet.displayBalance();

        System.out.println("Total Transaction Fee: " + transactionFeeCalculator.getTotalTransactionFee());
    }
}
