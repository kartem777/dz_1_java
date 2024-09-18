//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BudgetManager manager = new BudgetManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add transaction");
            System.out.println("2. View current balance");
            System.out.println("3. View history of transactions");
            System.out.println("4. Update transaction");
            System.out.println("5. Delete transaction");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Input operation type (+/-) ");
                    String type = scanner.nextLine();
                    System.out.print("Input sum: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Input description: ");
                    String description = scanner.nextLine();
                    manager.addTransaction(type, amount, description);
                    break;
                case 2:
                    manager.viewBalance();
                    break;
                case 3:
                    manager.viewTransactions();
                    break;
                case 4:
                    System.out.print("Input index of operation for updating: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Input new operation type (+/-)");
                    String newType = scanner.nextLine();
                    System.out.print("Input new sum: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Input new description: ");
                    String newDescription = scanner.nextLine();
                    manager.updateTransaction(updateIndex, newType, newAmount, newDescription);
                    break;
                case 5:
                    System.out.print("Input index of operation for deleting: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    manager.deleteTransaction(deleteIndex);
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Error. Option:" + choice + " is not available" );
            }
        }
    }
}