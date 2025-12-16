package src.java;

import src.java.model.Account;
import src.java.service.ConversationService;
import src.java.service.EnglishConversationService;
import src.java.service.HindiConversationService;

import java.util.Scanner;

public class AtmApp {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConversationService cs = chooseConversationService(sc);

        Account account = new Account(1234, 5000.0);

        System.out.println(cs.welcome());

        int tries = 3;
        boolean authenticated = false;

        while (tries > 0) {
            System.out.println(cs.enterPin());
            int pinInput = sc.nextInt();

            if (account.verifyPin(pinInput)) {
                authenticated = true;
                break;
            }

            tries--;
            if (tries > 0) System.out.println(cs.pinIncorrect(tries));
        }

        if (!authenticated) {
            System.out.println(cs.pinLocked());
            return;
        }

        while (true) {
            System.out.println(cs.menu());
            System.out.println(cs.chooseOption());
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println(cs.currentBalance(account.getBalance()));

                case 2 -> {
                    System.out.println(cs.enterAmount());
                    double amt =sc.nextDouble();
                    if (amt <= 0) {
                        System.out.println(cs.invalidAmount());
                    } else {
                        account.deposit(amt);
                        System.out.println(cs.depositSuccess(amt, account.getBalance()));
                    }
                }

                case 3 -> {
                    System.out.println(cs.enterAmount());
                    double amt = sc.nextDouble();
                    if (amt <= 0) {
                        System.out.println(cs.invalidAmount());
                    } else if (!account.withdraw(amt)) {
                        System.out.println(cs.insufficientFunds(account.getBalance()));
                    } else {
                        System.out.println(cs.withdrawSuccess(amt, account.getBalance()));
                    }
                }

                case 4 -> {
                    System.out.println(cs.goodbye());
                    return;
                }

                default -> System.out.println(cs.invalidChoice());
            }
        }
    }

    private static ConversationService chooseConversationService(Scanner sc) {
        System.out.println("Choose language: \n1) English  \n2) Hindi");
        int lang = sc.nextInt();
        return (lang == 2) ? new HindiConversationService() : new EnglishConversationService();
    }

}
