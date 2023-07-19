public class TransactionFeeCalculator {
    private double totalTransactionFee;

    public TransactionFeeCalculator() {
        totalTransactionFee = 0;
    }

    public void addTransactionFee(double fee) {
        totalTransactionFee += fee;
    }

    public double getTotalTransactionFee() {
        return totalTransactionFee;
    }
}
