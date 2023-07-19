public class BusinessWallet implements Wallet {
    private String companyName;
    private String gst;
    private double balance;

    public BusinessWallet(String companyName, String gst, double balance) {
        this.companyName = companyName;
        this.gst = gst;
        this.balance = balance;
    }

    @Override
    public String getUsername() {
        return companyName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addMoney(double amount) {
        balance += amount;
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
            System.out.println("Failed");
        }
    }
    
    @Override
    public String toString() {
        return "Company Name: " + companyName + "\n" +
               "GST Number: " + gst + "\n" +
               "Balance: F₹ " + balance;
    }

    @Override
    public void displayBalance() {
        System.out.println(companyName + " " + balance);
    }
}

