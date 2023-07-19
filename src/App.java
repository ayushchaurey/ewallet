public class App {
    public static void main(String[] args) {
        WalletManager walletManager = new WalletManager();
        TransactionFeeCalculator transactionFeeCalculator = new TransactionFeeCalculator();
        System.out.println("Overview");
        walletManager.createWallet("Personal", "A", 400);
        walletManager.createWallet("Personal", "B", 405);
        
       
      //  walletManager.displayOverview();
         walletManager.createWallet("Personal", "C", 104);
        walletManager.createWallet("Personal", "D", 100);
         walletManager.displayOverview();
        Wallet Cwallet = walletManager.findWalletByUsername("C");
        Wallet Dwallet = walletManager.findWalletByUsername("D");
        Cwallet.transferMoney(Dwallet, 4);      //fail Bisiness to Personal not allowed
        //Dwallet.transferMoney(hermioneWallet, 80);   //fail Bisiness to Personal not allowedSystem.out.println("Overview");
    walletManager.displayOverview();
        
                      
        System.out.println("Total Transaction Fee: " + walletManager.getTransactionFeeCalculator().getTotalTransactionFee());

    }
}
