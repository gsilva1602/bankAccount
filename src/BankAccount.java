public class BankAccount {

    private final String accountHolder;
    private double balance;

    //Métodos
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        //Atributos
        this.balance = initialBalance;
        this.accountHolder = accountHolder;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depósito de R$" + amount + " realizado pelo(a) " + accountHolder + " com sucesso! Novo saldo: R$" +balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Saque de R$" + amount + " realizado pelo(a) " + accountHolder + ". Novo saldo: R$" + balance);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}
