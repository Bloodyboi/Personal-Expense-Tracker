import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Expense {
    LocalDate date;
    String category;
    double amount;

    public Expense(LocalDate date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | ₹" + amount;
    }
}

public class PersonalExpenseTracker {
    private static final String FILE_NAME = "expenses.csv";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        loadExpenses();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Personal Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Show Monthly Total");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    showMonthlyTotal(sc);
                    break;
                case 4:
                    saveExpenses();
                    System.out.println("Exiting... Expenses saved.");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void addExpense(Scanner sc) {
        try {
            System.out.print("Enter date (yyyy-MM-dd): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), DATE_FORMAT);

            System.out.print("Enter category (Food, Travel, etc.): ");
            String category = sc.nextLine();

            System.out.print("Enter amount: ₹");
            double amount = sc.nextDouble();
            sc.nextLine(); // clear buffer

            Expense e = new Expense(date, category, amount);
            expenses.add(e);
            System.out.println("Expense added!");
        } catch (Exception ex) {
            System.out.println("Error: Invalid input format.");
        }
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("\n--- All Expenses ---");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    private static void showMonthlyTotal(Scanner sc) {
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        double total = expenses.stream()
                .filter(e -> e.date.getMonthValue() == month && e.date.getYear() == year)
                .mapToDouble(e -> e.amount)
                .sum();

        System.out.println("Total expenses for " + month + "/" + year + ": ₹" + total);
    }

    private static void loadExpenses() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDate date = LocalDate.parse(parts[0], DATE_FORMAT);
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                expenses.add(new Expense(date, category, amount));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses.");
        }
    }

    private static void saveExpenses() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                bw.write(e.date.format(DATE_FORMAT) + "," + e.category + "," + e.amount);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }
}
