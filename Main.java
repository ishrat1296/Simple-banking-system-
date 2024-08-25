import model.BankAccount;
import model.Customer;
import viewmodel.BankingViewModel;
import view.BankingView;

public class Main {
    public static void main(String[] args) {
        // Create a new BankAccount and Customer
        BankAccount account = new BankAccount("123456789", 5000.0);
        Customer customer = new Customer("John Doe", "C001", account);

        // Initialize ViewModel and Swing-based View
        BankingViewModel viewModel = new BankingViewModel(customer);
        new BankingView(viewModel);  // Display the Swing UI
    }
}
