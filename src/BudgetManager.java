public class BudgetManager {
    private String[] operations = new String[10];
    private double[] amounts = new double[10];
    private String[] descriptions = new String[10];
    private int transactionCount = 0;

    private void expand() {
        String[] newOperations = new String[operations.length * 2];
        double[] newAmounts = new double[amounts.length * 2];
        String[] newDescriptions = new String[descriptions.length * 2];

        System.arraycopy(operations, 0, newOperations, 0, operations.length);
        System.arraycopy(amounts, 0, newAmounts, 0, amounts.length);
        System.arraycopy(descriptions, 0, newDescriptions, 0, descriptions.length);

        operations = newOperations;
        amounts = newAmounts;
        descriptions = newDescriptions;
    }

    public void addTransaction(String type, double amount, String description) {
        if (transactionCount == operations.length) {
            expand();
        }

        operations[transactionCount] = type;
        amounts[transactionCount] = amount;
        descriptions[transactionCount] = description;
        transactionCount++;
        System.out.println("Transaction is added");
    }

    public void viewBalance() {
        double balance = 0;
        for (int i = 0; i < transactionCount; i++) {
            if (operations[i].equals("+")) {
                balance += amounts[i];
            } else if (operations[i].equals("-")) {
                balance -= amounts[i];
            }
        }
        System.out.println("Balance: " + balance + " grn");
    }

    public void viewTransactions() {
        if (transactionCount == 0) {
            System.out.println("No available transactions");
            return;
        }

        System.out.println("History of transactions:");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println((i + 1) + ". " + operations[i] + ": " + amounts[i] + " grn - " + descriptions[i]);
        }
    }

    public void updateTransaction(int index, String type, double amount, String description) {
        if (index >= 0 && index < transactionCount) {
            operations[index] = type;
            amounts[index] = amount;
            descriptions[index] = description;
            System.out.println("Transaction updated!");
        } else {
            System.out.println("Error. Transaction with this index cannot be found");
        }
    }

    public void deleteTransaction(int index) {
        if (index >= 0 && index < transactionCount) {
            for (int i = index; i < transactionCount - 1; i++) {
                operations[i] = operations[i + 1];
                amounts[i] = amounts[i + 1];
                descriptions[i] = descriptions[i + 1];
            }
            transactionCount--;
            System.out.println("Transaction deleted!");
        } else {
            System.out.println("Error. Transaction with this index cannot be found");
        }
    }
}