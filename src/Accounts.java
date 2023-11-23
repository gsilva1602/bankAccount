import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Accounts {
    private final Map<String, BankAccount> accounts;

    public Accounts() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double initialBalance){
        BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Conta criada para " + accountHolder + " com número " + accountNumber);
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void performDeposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Conta não encontrada para o número " + accountNumber);
        }

    }

    public void performWithdrawal(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Conta não encontrada para o número " + accountNumber);
        }
    }

    public void runCommandLoop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite um comando (1-criar, 2-depositar, 3-sacar, 4-sair):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "1":
                    System.out.println("Digite o número da conta: ");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Digite o nome do titular: ");
                    String accountHolder = scanner.nextLine();
                    System.out.println("Digite o saldo inicial: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    createAccount(accountNumber, accountHolder, initialBalance);
                    break;

                case "2":
                    System.out.println("Digite o número da conta: ");
                    accountNumber = scanner.nextLine();
                    System.out.println("Digite o valor a ser depositado: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    performDeposit(accountNumber, depositAmount);
                    break;

                case "3":
                    System.out.println("Digite o número da conta: ");
                    accountNumber = scanner.nextLine();
                    System.out.println("Digite o valor a ser sacado: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    performWithdrawal(accountNumber, withdrawalAmount);
                    break;

                case "4":
                    System.out.println("Saindo do programa.");
                    return;

                default:
                    System.out.println("Comando inválido. Tente novamente");
            }
        }
    }

    public static void main(String[] args) {
        Accounts bank = new Accounts();

        bank.runCommandLoop();
    }
}
