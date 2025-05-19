public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final double interestRate = 0.60; 

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Penarikkan Berhasil, Jumlah Saldo Saat ini: " + balance);
        } else {
            System.out.println("Penarikkan Gagal, Saldo Tidak Mencukupi.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Berhasil di Lakukan!!.\nJumlah Saldo Saat ini: " + balance);
        } else {
            System.out.println("Jumlah Deposit Harus Lebih dari 0 Rp");
        }
    }

    public void checkBalance() {
        System.out.printf("Saldo Anda Saat ini: %.2f%n", balance);
    }

    public void checkBalance(int months) {
        double futureBalance = balance * Math.pow(1 + (interestRate / 12), months);
        System.out.printf("Saldo Anda Saat ini: %.2f%n", balance);
        System.out.printf("Saldo Anda dalam bulan %d menjadi: %.2f%n", months, futureBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}