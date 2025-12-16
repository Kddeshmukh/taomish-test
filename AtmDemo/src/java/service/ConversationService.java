package src.java.service;

public interface ConversationService {

    String welcome();

    String askLanguage();

    String enterPin();

    String pinIncorrect(int remainingTries);

    String pinLocked();

    String menu();

    String chooseOption();

    String enterAmount();

    String invalidChoice();

    String invalidAmount();

    String depositSuccess(double amount, double newBalance);

    String withdrawSuccess(double amount, double newBalance);

    String insufficientFunds(double balance);

    String currentBalance(double balance);

    String goodbye();

}
