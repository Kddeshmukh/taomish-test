package src.java.service;

public class HindiConversationService implements ConversationService {
    public String welcome() { return "ATM mein aapka swagat hai"; }
    public String askLanguage() { return "Bhasha chunen: 1) English  2) Hindi"; }
    public String enterPin() { return "Apna 4-digit PIN daaliye:"; }
    public String pinIncorrect(int remainingTries) {
        return "Galat PIN. Bache hue attempts: " + remainingTries;
    }
    public String pinLocked() { return "Bahut saare galat attempts. Card lock ho gaya."; }
    public String menu() {
        return """
                   ===== MENU =====
                   1) Balance dekhen
                   2) Deposit
                   3) Withdraw
                   4) Exit
                   """;
    }
    public String chooseOption() { return "Option chunen (1-4):"; }
    public String enterAmount() { return "Amount daaliye:"; }
    public String invalidChoice() { return "Galat option. Dobara koshish karein."; }
    public String invalidAmount() { return "Galat amount. Positive number daaliye."; }
    public String depositSuccess(double amount, double newBalance) {
        return "Deposit successful: " + amount + " | Naya balance: " + newBalance;
    }
    public String withdrawSuccess(double amount, double newBalance) {
        return "Withdraw successful: " + amount + " | Naya balance: " + newBalance;
    }
    public String insufficientFunds(double balance) {
        return "Paise kam hain. Current balance: " + balance;
    }
    public String currentBalance(double balance) { return "Current balance: " + balance; }
    public String goodbye() { return "Dhanyavaad! Alvida."; }
}