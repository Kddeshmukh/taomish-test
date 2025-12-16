package src.java.service;

public class EnglishConversationService implements ConversationService {
    public String welcome() { return "Welcome to the ATM"; }
    public String askLanguage() { return "Choose language: 1) English  2) Hindi"; }
    public String enterPin() { return "Enter your 4-digit PIN:"; }
    public String pinIncorrect(int remainingTries) {
        return "Incorrect PIN. Remaining tries: " + remainingTries;
    }
    public String pinLocked() { return "Too many wrong attempts. Card locked."; }
    public String menu() {
        return """
                   ===== MENU =====
                   1) Check Balance
                   2) Deposit
                   3) Withdraw
                   4) Exit
                   """;
    }
    public String chooseOption() { return "Choose an option (1-4):"; }
    public String enterAmount() { return "Enter amount:"; }
    public String invalidChoice() { return "Invalid option. Try again."; }
    public String invalidAmount() { return "Invalid amount. Enter a positive number."; }
    public String depositSuccess(double amount, double newBalance) {
        return "Deposit successful: " + amount + " | New balance: " + newBalance;
    }
    public String withdrawSuccess(double amount, double newBalance) {
        return "Withdraw successful: " + amount + " | New balance: " + newBalance;
    }
    public String insufficientFunds(double balance) {
        return "Insufficient funds. Current balance: " + balance;
    }
    public String currentBalance(double balance) { return "Current balance: " + balance; }
    public String goodbye() { return "Thank you! Goodbye."; }
}
