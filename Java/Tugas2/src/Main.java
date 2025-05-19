import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Account Holder: ");
        String accountHolder = scanner.nextLine();
        
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Masukkan Saldo Awal:");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);

        while (true) {
            System.out.println("\nATM Bank Niagara");
            System.out.println("Menu pilihan:");
            System.out.println("1. Tarik Tunai");
            System.out.println("2. Deposit");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.print("Masukkan Jumlah yang Ingin di Tarik: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } while (confirmTransaction(scanner));
                    break;
                case 2:
                    do {
                        System.out.print("Masukkan Jumlah yang Ingin di Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } while (confirmTransaction(scanner));
                    break;
                case 3:
                    do {
                        checkBalanceMenu(scanner, account);
                    } while (confirmTransaction(scanner));
                    break;
                case 4:
                    System.out.println("Terimakasih Telah Menggunakan Jasa Bank Kami Sampai Jumpa Kembali!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan Menu Tidak Terdaftar, Pilih Nomer dari Daftar Nomer yang Ada!!");
            }
        }
    }

    private static void checkBalanceMenu(Scanner scanner, BankAccount account) {
        System.out.println("\nCek Saldo Menu:");
        System.out.println("1. Cek Saldo Sekarang");
        System.out.println("2. Cek Saldo Masa Depan");
        System.out.print("Masukkan Pilihan: ");

        int balanceChoice = scanner.nextInt();

        switch (balanceChoice) {
            case 1:
                account.checkBalance(); 
                break;
            case 2:
                System.out.print("Masukkan Jumlah Bulan: ");
                int months = scanner.nextInt();
                account.checkBalance(months); 
                break;
            default:
                System.out.println("Pilihan Menu Tidak Terdaftar, Kembali ke Menu Utama.");
        }
    }

    private static boolean confirmTransaction(Scanner scanner) {
        System.out.print("Apakah Anda Ingin Melanjutkan Transaksi (y/n): ");
        scanner.nextLine(); 
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }
}